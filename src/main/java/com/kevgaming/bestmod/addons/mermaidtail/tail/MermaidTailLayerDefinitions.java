package com.kevgaming.bestmod.addons.mermaidtail.tail;

import com.kevgaming.bestmod.BestMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BestMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MermaidTailLayerDefinitions
{
    public static final ModelLayerLocation MERMAID_TAIL = register("mermaid_tail");

    private static ModelLayerLocation register(String name)
    {
        return new ModelLayerLocation(new ResourceLocation(BestMod.MOD_ID, name), "main");
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(MERMAID_TAIL, MermaidTailModel::createLayer);
    }
}
