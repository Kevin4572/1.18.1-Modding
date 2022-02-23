package com.kevgaming.bestmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers
{
    public static final ForgeTier COPPER = new ForgeTier(1, 200, 5.0F, 4.0F, 15, BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.COPPER_INGOT));
    public static final ForgeTier ALUMINUM = new ForgeTier(1, 200, 5.0F, 4.0F, 15, BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(ModItems.ALUMINUM_INGOT.get()));
    public static final ForgeTier TIN = new ForgeTier(1, 200, 5.0F, 4.0F, 15, BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(ModItems.TIN_INGOT.get()));
    public static final ForgeTier RUBY = new ForgeTier(4, 2000, 14.0F, 7.5F, 25, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItems.RUBY.get()));
    public static final ForgeTier SAPPHIRE = new ForgeTier(4, 2000, 14.0F, 7.5F, 25, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItems.SAPPHIRE.get()));
    public static final ForgeTier AMETHYST = new ForgeTier(5, 5000, 20.0F, 9.0F, 30, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItems.AMETHYST.get()));
}
