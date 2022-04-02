package com.kevgaming.bestmod.addons.mermaidtail.tail;

import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModelInstances
{
    private MermaidTailModel mermaidTailModel;

    @SubscribeEvent
    public void onLoadModels(EntityRenderersEvent.AddLayers event)
    {
        EntityModelSet models = event.getEntityModels();
        this.mermaidTailModel = new MermaidTailModel(models.bakeLayer(MermaidTailLayerDefinitions.MERMAID_TAIL));
    }

    public MermaidTailModel getMermaidTailModel()
    {
        return mermaidTailModel;
    }
}
