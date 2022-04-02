package com.kevgaming.bestmod.addons.mermaidtail.client;

import com.kevgaming.bestmod.addons.mermaidtail.MermaidTail;
import com.kevgaming.bestmod.addons.mermaidtail.tail.MermaidTailLayer;
import com.kevgaming.bestmod.addons.mermaidtail.tail.ModelInstances;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class ClientHandler
{
    public static final ModelInstances MODELS = new ModelInstances();

    public static void setup()
    {
        MermaidTail.instance().getRegisteredMermaidTail().forEach(mermaidtail -> MermaidTailLayer.registerModel(MermaidTail.ID, mermaidtail.getModelSupplier()));
    }

    public static ModelInstances getModelInstances()
    {
        return MODELS;
    }

    public static void onRegisterLayers(EntityRenderersEvent.AddLayers event)
    {
        addTailLayer(event.getSkin("default"));
        addTailLayer(event.getSkin("slim"));
    }

    private static void addTailLayer(LivingEntityRenderer<?, ?> renderer)
    {
        if(renderer instanceof PlayerRenderer playerRenderer) playerRenderer.addLayer(new MermaidTailLayer<>(playerRenderer));
    }
}
