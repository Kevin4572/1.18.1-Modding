package com.kevgaming.bestmod.addons.mermaidtail;

import com.kevgaming.bestmod.BestMod;
import com.kevgaming.bestmod.addons.mermaidtail.client.ClientHandler;
import com.kevgaming.bestmod.inventory.ExtendedInventory;
import com.kevgaming.bestmod.item.custom.NecklaceItem;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ContainerScreenEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MermaidTailEvents
{
    public static final ResourceLocation EMPTY_NECKLACE_SLOT = new ResourceLocation(BestMod.MOD_ID, "item/empty_necklace_slot");
    private static CreativeModeTab currentTab = null;
    private static final Field SLOT_X = removeFinal(ObfuscationReflectionHelper.findField(Slot.class, "f_40220_"));
    private static final Field SLOT_Y = removeFinal(ObfuscationReflectionHelper.findField(Slot.class, "f_40221_"));

    public MermaidTailEvents()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () ->
        {
            eventBus.addListener(ClientHandler::onRegisterLayers);
            eventBus.register(ClientHandler.getModelInstances());
        });
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void PreRender(RenderPlayerEvent.Pre event)
    {
        Player player = event.getPlayer();
        ItemStack stack = MermaidTail.getNecklace(player);
        if(player.isInWater() && !stack.isEmpty())
        {
            event.getRenderer().getModel().leftLeg.visible = false;
            event.getRenderer().getModel().rightLeg.visible = false;
            event.getRenderer().getModel().leftPants.visible = false;
            event.getRenderer().getModel().rightPants.visible = false;
        }
    }

    @SubscribeEvent
    public void onPlayerRenderScreen(ContainerScreenEvent.DrawBackground event)
    {
        AbstractContainerScreen<?> screen = event.getContainerScreen();
        if(screen instanceof InventoryScreen inventory)
        {
            int left = inventory.getGuiLeft();
            int top = inventory.getGuiTop();
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.setShaderTexture(0, AbstractContainerScreen.INVENTORY_LOCATION);
            Screen.blit(event.getPoseStack(), left + 76, top + 43, 7, 7, 18, 18, 256, 256);
        } else if(screen instanceof CreativeModeInventoryScreen inventory) {
            if(inventory.getSelectedTab() == CreativeModeTab.TAB_INVENTORY.getId())
            {
                int left = inventory.getGuiLeft();
                int top = inventory.getGuiTop();
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                RenderSystem.setShaderTexture(0, AbstractContainerScreen.INVENTORY_LOCATION);
                Screen.blit(event.getPoseStack(), left + 126, top + 19, 7, 7, 18, 18, 256, 256);
            }
        }
    }

    public static void onTextureStitch(TextureStitchEvent.Pre event)
    {
        if(event.getAtlas().location().equals(InventoryMenu.BLOCK_ATLAS)) event.addSprite(EMPTY_NECKLACE_SLOT);
    }

    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event)
    {
        Player oldPlayer = event.getOriginal();
        if(oldPlayer.getInventory() instanceof ExtendedInventory inventory1 && event.getPlayer().getInventory() instanceof ExtendedInventory inventory2) inventory2.copyNecklace(inventory1);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
        Player player = event.player;
        ItemStack stack = MermaidTail.getNecklace(player);
        if(player.isInWater() && !stack.isEmpty())
        {
            player.setAirSupply(300);
            player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 20, 0, false, false));
        }
        if(event.phase != TickEvent.Phase.START) return;
        if(!player.level.isClientSide && player.getInventory() instanceof ExtendedInventory inventory) if(!inventory.necklaceArray.get(0).equals(inventory.necklaceInventory.get(0))) inventory.necklaceArray.set(0, inventory.necklaceInventory.get(0));
    }

    @SubscribeEvent
    public void onRenderTickStart(TickEvent.RenderTickEvent event)
    {
        if(event.phase != TickEvent.Phase.START) return;
        Minecraft mc = Minecraft.getInstance();
        if(!(mc.screen instanceof CreativeModeInventoryScreen screen))
        {
            currentTab = null;
            return;
        }
        CreativeModeTab tab = CreativeModeTab.TABS[screen.getSelectedTab()];
        if(currentTab == null || currentTab != tab)
        {
            currentTab = tab;
            if(currentTab == CreativeModeTab.TAB_INVENTORY)
            {
                List<Slot> slots = screen.getMenu().slots;
                slots.stream().filter(slot -> slot.container instanceof ExtendedInventory && slot.getSlotIndex() == 41).findFirst().ifPresent(slot -> MermaidTailEvents.repositionSlot(slot, 127, 20));
            }
        }
    }

    public static ItemStack getNecklaceStack(Player player)
    {
        AtomicReference<ItemStack> necklace = new AtomicReference<>(ItemStack.EMPTY);
        if(player.getInventory() instanceof ExtendedInventory inventory)
        {
            ItemStack stack = inventory.getNecklaceItems().get(0);
            if(stack.getItem() instanceof NecklaceItem) necklace.set(stack);
        }
        return necklace.get();
    }

    public static void repositionSlot(Slot slot, int x, int y)
    {
        try
        {
            SLOT_X.set(slot, x);
            SLOT_Y.set(slot, y);
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static Field removeFinal(Field field)
    {
        try
        {
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        }
        catch(NoSuchFieldException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return field;
    }
}
