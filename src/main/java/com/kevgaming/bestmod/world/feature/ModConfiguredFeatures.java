package com.kevgaming.bestmod.world.feature;

import com.kevgaming.bestmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class ModConfiguredFeatures
{
    public static final List<OreConfiguration.TargetBlockState> ORE_ALUMINUM_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ALUMINUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_TIN_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TIN_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_RUBY_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_SAPPHIRE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_AMETHYST_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.AMETHYST_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_AMETHYST_ORE.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_ALUMINUM_SMALL = FeatureUtils.register("ore_aluminum_small", Feature.ORE, new OreConfiguration(ORE_ALUMINUM_TARGET_LIST, 10));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_ALUMINUM_LARGE = FeatureUtils.register("ore_aluminum_large", Feature.ORE, new OreConfiguration(ORE_ALUMINUM_TARGET_LIST, 20));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_TIN_SMALL = FeatureUtils.register("ore_tin_small", Feature.ORE, new OreConfiguration(ORE_TIN_TARGET_LIST, 10));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_TIN_LARGE = FeatureUtils.register("ore_tin_large", Feature.ORE, new OreConfiguration(ORE_TIN_TARGET_LIST, 20));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_RUBY_SMALL = FeatureUtils.register("ore_ruby_small", Feature.ORE, new OreConfiguration(ORE_RUBY_TARGET_LIST, 3, 0.5F));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_RUBY_LARGE = FeatureUtils.register("ore_ruby_large", Feature.ORE, new OreConfiguration(ORE_RUBY_TARGET_LIST, 9, 0.7F));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_RUBY_BURIED = FeatureUtils.register("ore_ruby_buried", Feature.ORE, new OreConfiguration(ORE_RUBY_TARGET_LIST, 6, 1.0F));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_NETHER_RUBY = FeatureUtils.register("ore_nether_ruby", Feature.ORE, new OreConfiguration(OreFeatures.NETHERRACK, ModBlocks.NETHER_RUBY_ORE.get().defaultBlockState(), 5));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SAPPHIRE_SMALL = FeatureUtils.register("ore_sapphire_small", Feature.ORE, new OreConfiguration(ORE_SAPPHIRE_TARGET_LIST, 3, 0.5F));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SAPPHIRE_LARGE = FeatureUtils.register("ore_sapphire_large", Feature.ORE, new OreConfiguration(ORE_SAPPHIRE_TARGET_LIST, 9, 0.7F));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SAPPHIRE_BURIED = FeatureUtils.register("ore_sapphire_buried", Feature.ORE, new OreConfiguration(ORE_SAPPHIRE_TARGET_LIST, 6, 1.0F));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_AMETHYST_SMALL = FeatureUtils.register("ore_amethyst_small", Feature.ORE, new OreConfiguration(ORE_AMETHYST_TARGET_LIST, 2, 0.5F));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_AMETHYST_LARGE = FeatureUtils.register("ore_amethyst_large", Feature.ORE, new OreConfiguration(ORE_AMETHYST_TARGET_LIST, 6, 0.7F));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_AMETHYST_BURIED = FeatureUtils.register("ore_amethyst_buried", Feature.ORE, new OreConfiguration(ORE_AMETHYST_TARGET_LIST, 4, 1.0F));
}
