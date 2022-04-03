package com.kevgaming.bestmod.world;

import com.kevgaming.bestmod.BestMod;
import com.kevgaming.bestmod.world.gen.ModOreGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BestMod.MOD_ID)
public class ModWorldEvents
{
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event)
    {
        ModOreGeneration.generateOres(event);
    }
}
