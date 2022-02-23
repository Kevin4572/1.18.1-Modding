package com.kevgaming.bestmod.world.gen;

import com.kevgaming.bestmod.BestMod;
import com.kevgaming.bestmod.block.ModBlocks;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

public class OreGeneration
{
    public static final List<OreConfiguration.TargetBlockState> ORE_ALUMINUM_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ALUMINUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_TIN_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TIN_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_RUBY_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_SAPPHIRE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_AMETHYST_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.AMETHYST_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_AMETHYST_ORE.get().defaultBlockState()));
    public static final ConfiguredFeature<?, ?> ORE_ALUMINUM_SMALL = FeatureUtils.register("ore_aluminum_small", Feature.ORE.configured(new OreConfiguration(ORE_ALUMINUM_TARGET_LIST, 10)));
    public static final ConfiguredFeature<?, ?> ORE_ALUMINUM_LARGE = FeatureUtils.register("ore_aluminum_large", Feature.ORE.configured(new OreConfiguration(ORE_ALUMINUM_TARGET_LIST, 20)));
    public static final ConfiguredFeature<?, ?> ORE_TIN_SMALL = FeatureUtils.register("ore_tin_small", Feature.ORE.configured(new OreConfiguration(ORE_TIN_TARGET_LIST, 10)));
    public static final ConfiguredFeature<?, ?> ORE_TIN_LARGE = FeatureUtils.register("ore_tin_large", Feature.ORE.configured(new OreConfiguration(ORE_TIN_TARGET_LIST, 20)));
    public static final ConfiguredFeature<?, ?> ORE_RUBY_SMALL = FeatureUtils.register("ore_ruby_small", Feature.ORE.configured(new OreConfiguration(ORE_RUBY_TARGET_LIST, 3, 0.5F)));
    public static final ConfiguredFeature<?, ?> ORE_RUBY_LARGE = FeatureUtils.register("ore_ruby_large", Feature.ORE.configured(new OreConfiguration(ORE_RUBY_TARGET_LIST, 9, 0.7F)));
    public static final ConfiguredFeature<?, ?> ORE_RUBY_BURIED = FeatureUtils.register("ore_ruby_buried", Feature.ORE.configured(new OreConfiguration(ORE_RUBY_TARGET_LIST, 6, 1.0F)));
    public static final ConfiguredFeature<?, ?> ORE_NETHER_RUBY = FeatureUtils.register("ore_nether_ruby", Feature.ORE.configured(new OreConfiguration(OreFeatures.NETHERRACK, ModBlocks.NETHER_RUBY_ORE.get().defaultBlockState(), 5)));
    public static final ConfiguredFeature<?, ?> ORE_SAPPHIRE_SMALL = FeatureUtils.register("ore_sapphire_small", Feature.ORE.configured(new OreConfiguration(ORE_SAPPHIRE_TARGET_LIST, 3, 0.5F)));
    public static final ConfiguredFeature<?, ?> ORE_SAPPHIRE_LARGE = FeatureUtils.register("ore_sapphire_large", Feature.ORE.configured(new OreConfiguration(ORE_SAPPHIRE_TARGET_LIST, 9, 0.7F)));
    public static final ConfiguredFeature<?, ?> ORE_SAPPHIRE_BURIED = FeatureUtils.register("ore_sapphire_buried", Feature.ORE.configured(new OreConfiguration(ORE_SAPPHIRE_TARGET_LIST, 6, 1.0F)));
    public static final ConfiguredFeature<?, ?> ORE_AMETHYST_SMALL = FeatureUtils.register("ore_amethyst_small", Feature.ORE.configured(new OreConfiguration(ORE_AMETHYST_TARGET_LIST, 2, 0.5F)));
    public static final ConfiguredFeature<?, ?> ORE_AMETHYST_LARGE = FeatureUtils.register("ore_amethyst_large", Feature.ORE.configured(new OreConfiguration(ORE_AMETHYST_TARGET_LIST, 6, 0.7F)));
    public static final ConfiguredFeature<?, ?> ORE_AMETHYST_BURIED = FeatureUtils.register("ore_amethyst_buried", Feature.ORE.configured(new OreConfiguration(ORE_AMETHYST_TARGET_LIST, 4, 1.0F)));
    public static final PlacedFeature ORE_ALUMINUM_PLACEMENT = PlacementUtils.register("ore_aluminum_placement", ORE_ALUMINUM_SMALL.placed(commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
    public static final PlacedFeature ORE_ALUMINUM_PLACEMENT_LARGE = PlacementUtils.register("ore_aluminum_placement_large", ORE_ALUMINUM_LARGE.placed(commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
    public static final PlacedFeature ORE_TIN_PLACEMENT = PlacementUtils.register("ore_tin_placement", ORE_TIN_SMALL.placed(commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
    public static final PlacedFeature ORE_TIN_PLACEMENT_LARGE = PlacementUtils.register("ore_tin_placement_large", ORE_TIN_LARGE.placed(commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
    public static final PlacedFeature ORE_RUBY_PLACEMENT = PlacementUtils.register("ore_ruby_placement", ORE_RUBY_SMALL.placed(commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final PlacedFeature ORE_RUBY_PLACEMENT_LARGE = PlacementUtils.register("ore_ruby_placement_large", ORE_RUBY_LARGE.placed(rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final PlacedFeature ORE_RUBY_PLACEMENT_BURIED = PlacementUtils.register("ore_ruby_placement_buried", ORE_RUBY_BURIED.placed(commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final PlacedFeature ORE_NETHER_RUBY_PLACEMENT = PlacementUtils.register("ore_nether_ruby_placement", ORE_NETHER_RUBY.placed(commonOrePlacement(5, PlacementUtils.RANGE_10_10)));
    public static final PlacedFeature ORE_SAPPHIRE_PLACEMENT = PlacementUtils.register("ore_sapphire_placement", ORE_SAPPHIRE_SMALL.placed(commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final PlacedFeature ORE_SAPPHIRE_PLACEMENT_LARGE = PlacementUtils.register("ore_sapphire_placement_large", ORE_SAPPHIRE_LARGE.placed(rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final PlacedFeature ORE_SAPPHIRE_PLACEMENT_BURIED = PlacementUtils.register("ore_sapphire_placement_buried", ORE_SAPPHIRE_BURIED.placed(commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final PlacedFeature ORE_AMETHYST_PLACEMENT = PlacementUtils.register("ore_amethyst_placement", ORE_AMETHYST_SMALL.placed(commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final PlacedFeature ORE_AMETHYST_PLACEMENT_LARGE = PlacementUtils.register("ore_amethyst_placement_large", ORE_AMETHYST_LARGE.placed(rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final PlacedFeature ORE_AMETHYST_PLACEMENT_BURIED = PlacementUtils.register("ore_amethyst_placement_buried", ORE_AMETHYST_BURIED.placed(commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    @Mod.EventBusSubscriber(modid = BestMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeBusSubscriber
    {
        @SubscribeEvent
        public static void biomeLoading(BiomeLoadingEvent event)
        {
            switch(event.getCategory())
            {
                case THEEND -> {}
                case NETHER -> {
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.ORE_NETHER_RUBY_PLACEMENT);
                }
                default -> {
                    if(event.getName().toString().contains(Biomes.DRIPSTONE_CAVES.location().toString()))
                    {
                        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.ORE_ALUMINUM_PLACEMENT_LARGE);
                        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.ORE_TIN_PLACEMENT_LARGE);
                    } else {
                        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.ORE_ALUMINUM_PLACEMENT);
                        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.ORE_TIN_PLACEMENT);
                    }
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.ORE_RUBY_PLACEMENT);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.ORE_RUBY_PLACEMENT_LARGE);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.ORE_RUBY_PLACEMENT_BURIED);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.ORE_SAPPHIRE_PLACEMENT);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.ORE_SAPPHIRE_PLACEMENT_LARGE);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.ORE_SAPPHIRE_PLACEMENT_BURIED);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.ORE_AMETHYST_PLACEMENT);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.ORE_AMETHYST_PLACEMENT_LARGE);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.ORE_AMETHYST_PLACEMENT_BURIED);
                }
            }
        }
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_)
    {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_)
    {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_)
    {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }
}
