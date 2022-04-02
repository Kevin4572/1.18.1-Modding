package com.kevgaming.bestmod.addons.mermaidtail;

import com.google.common.collect.ImmutableList;
import com.kevgaming.bestmod.BestMod;
import com.kevgaming.bestmod.addons.mermaidtail.tail.MermaidTailModel;
import com.kevgaming.bestmod.addons.mermaidtail.client.ClientHandler;
import com.kevgaming.bestmod.item.custom.NecklaceItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class MermaidTail
{
    public static final ResourceLocation ID = new ResourceLocation(BestMod.MOD_ID, "mermaid_tail");
    private static MermaidTail instance;
    public static MermaidTail instance()
    {
        if(instance == null) instance = new MermaidTail();
        return instance;
    }
    private final Map<ResourceLocation, MermaidTail> registeredMermaidTail = new HashMap<>();

    private MermaidTail()
    {
        MinecraftForge.EVENT_BUS.register(new MermaidTailEvents());
    }

    public List<MermaidTail> getRegisteredMermaidTail()
    {
        return ImmutableList.copyOf(this.registeredMermaidTail.values());
    }

    public Supplier<MermaidTailModel> getModelSupplier()
    {
        return ClientHandler.getModelInstances()::getMermaidTailModel;
    }

    public static ItemStack getNecklace(Player player)
    {
        ItemStack stack = MermaidTailEvents.getNecklaceStack(player);
        return (stack.getItem() instanceof NecklaceItem) ? stack : ItemStack.EMPTY;
    }
}
