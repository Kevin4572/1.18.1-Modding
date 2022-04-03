package com.kevgaming.bestmod.world.gen;

import com.kevgaming.bestmod.world.feature.ModOrePlacement;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ModOreGeneration
{
    public static void generateOres(final BiomeLoadingEvent event)
    {
        switch(event.getCategory())
        {
            case THEEND -> {}
            case NETHER -> event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacement.ORE_NETHER_RUBY_PLACEMENT);
            default -> {
                if(event.getName().toString().contains(Biomes.DRIPSTONE_CAVES.location().toString()))
                {
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacement.ORE_ALUMINUM_PLACEMENT_LARGE);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacement.ORE_TIN_PLACEMENT_LARGE);
                } else {
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacement.ORE_ALUMINUM_PLACEMENT);
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacement.ORE_TIN_PLACEMENT);
                }
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacement.ORE_RUBY_PLACEMENT);
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacement.ORE_RUBY_PLACEMENT_LARGE);
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacement.ORE_RUBY_PLACEMENT_BURIED);
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacement.ORE_SAPPHIRE_PLACEMENT);
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacement.ORE_SAPPHIRE_PLACEMENT_LARGE);
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacement.ORE_SAPPHIRE_PLACEMENT_BURIED);
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacement.ORE_AMETHYST_PLACEMENT);
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacement.ORE_AMETHYST_PLACEMENT_LARGE);
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModOrePlacement.ORE_AMETHYST_PLACEMENT_BURIED);
            }
        }
    }
}
