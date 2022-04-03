package com.kevgaming.bestmod.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModOrePlacement
{
    public static final Holder<PlacedFeature> ORE_ALUMINUM_PLACEMENT = PlacementUtils.register("ore_aluminum_placement", ModConfiguredFeatures.ORE_ALUMINUM_SMALL, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
    public static final Holder<PlacedFeature> ORE_ALUMINUM_PLACEMENT_LARGE = PlacementUtils.register("ore_aluminum_placement_large", ModConfiguredFeatures.ORE_ALUMINUM_LARGE, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
    public static final Holder<PlacedFeature> ORE_TIN_PLACEMENT = PlacementUtils.register("ore_tin_placement", ModConfiguredFeatures.ORE_TIN_SMALL, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
    public static final Holder<PlacedFeature> ORE_TIN_PLACEMENT_LARGE = PlacementUtils.register("ore_tin_placement_large", ModConfiguredFeatures.ORE_TIN_LARGE, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
    public static final Holder<PlacedFeature> ORE_RUBY_PLACEMENT = PlacementUtils.register("ore_ruby_placement", ModConfiguredFeatures.ORE_RUBY_SMALL, commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> ORE_RUBY_PLACEMENT_LARGE = PlacementUtils.register("ore_ruby_placement_large", ModConfiguredFeatures.ORE_RUBY_LARGE, rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> ORE_RUBY_PLACEMENT_BURIED = PlacementUtils.register("ore_ruby_placement_buried", ModConfiguredFeatures.ORE_RUBY_BURIED, commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> ORE_NETHER_RUBY_PLACEMENT = PlacementUtils.register("ore_nether_ruby_placement", ModConfiguredFeatures.ORE_NETHER_RUBY, commonOrePlacement(5, PlacementUtils.RANGE_10_10));
    public static final Holder<PlacedFeature> ORE_SAPPHIRE_PLACEMENT = PlacementUtils.register("ore_sapphire_placement", ModConfiguredFeatures.ORE_SAPPHIRE_SMALL, commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> ORE_SAPPHIRE_PLACEMENT_LARGE = PlacementUtils.register("ore_sapphire_placement_large", ModConfiguredFeatures.ORE_SAPPHIRE_LARGE, rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> ORE_SAPPHIRE_PLACEMENT_BURIED = PlacementUtils.register("ore_sapphire_placement_buried", ModConfiguredFeatures.ORE_SAPPHIRE_BURIED, commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> ORE_AMETHYST_PLACEMENT = PlacementUtils.register("ore_amethyst_placement", ModConfiguredFeatures.ORE_AMETHYST_SMALL, commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> ORE_AMETHYST_PLACEMENT_LARGE = PlacementUtils.register("ore_amethyst_placement_large", ModConfiguredFeatures.ORE_AMETHYST_LARGE, rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> ORE_AMETHYST_PLACEMENT_BURIED = PlacementUtils.register("ore_amethyst_placement_buried", ModConfiguredFeatures.ORE_AMETHYST_BURIED, commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

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
