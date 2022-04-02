package com.kevgaming.bestmod.item.custom;

import com.kevgaming.bestmod.inventory.ExtendedInventory;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NecklaceItem extends Item implements DyeableLeatherItem
{
    private final boolean hasEffect;

    public NecklaceItem(Properties pProperties, boolean effect)
    {
        super(pProperties);
        hasEffect = effect;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand)
    {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        if(pPlayer.getInventory() instanceof ExtendedInventory)
        {
            ExtendedInventory inventory = (ExtendedInventory)pPlayer.getInventory();
            if(inventory.getNecklaceItems().get(0).isEmpty())
            {
                pPlayer.getInventory().setItem(41, itemstack.copy());
                if(!pLevel.isClientSide()) pPlayer.awardStat(Stats.ITEM_USED.get(this));
                itemstack.setCount(0);
                pPlayer.playSound(SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 1.0F);
                return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
            }
        }
        return new InteractionResultHolder<>(InteractionResult.FAIL, itemstack);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        if(Screen.hasShiftDown()) pTooltipComponents.add(new TranslatableComponent("tooltip.bestmod.deep_sea_necklace.tooltip.shift"));
        else pTooltipComponents.add(new TranslatableComponent("tooltip.bestmod.deep_sea_necklace.tooltip"));
    }

    @Override
    public int getColor(ItemStack pStack)
    {
        CompoundTag compoundtag = pStack.getTagElement("display");
        return compoundtag != null && compoundtag.contains("color", 99) ? compoundtag.getInt("color") : 16777215;
    }

    @Override
    public boolean isFoil(ItemStack pStack)
    {
        return hasEffect;
    }
}
