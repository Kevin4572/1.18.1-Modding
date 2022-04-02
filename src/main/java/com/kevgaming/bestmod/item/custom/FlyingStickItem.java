package com.kevgaming.bestmod.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FlyingStickItem extends Item
{
    public FlyingStickItem(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand)
    {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        if(!pPlayer.isCreative())
        {
            pPlayer.getAbilities().mayfly = !pPlayer.getAbilities().mayfly;
            if(!pPlayer.getAbilities().mayfly) pPlayer.getAbilities().flying = false;
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
        }
        return new InteractionResultHolder<>(InteractionResult.FAIL, itemstack);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
    {
        if(Screen.hasShiftDown()) pTooltipComponents.add(new TranslatableComponent("tooltip.bestmod.flying_stick.tooltip.shift"));
        else pTooltipComponents.add(new TranslatableComponent("tooltip.bestmod.flying_stick.tooltip"));
    }
}
