package com.kevgaming.bestmod.addons.mermaidtail.tail;

import com.kevgaming.bestmod.addons.mermaidtail.MermaidTail;
import com.kevgaming.bestmod.addons.mermaidtail.client.ClientHandler;
import com.kevgaming.bestmod.item.custom.NecklaceItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MermaidTailLayer<T extends Player, M extends PlayerModel<T>> extends RenderLayer<T, M>
{
    private static final Map<String, Supplier<MermaidTailModel>> MERMAID_TAIL = new HashMap<>();
    private static final Supplier<MermaidTailModel> DEFAULT_SUPPLIER = () -> ClientHandler.getModelInstances().getMermaidTailModel();

    public MermaidTailLayer(RenderLayerParent<T, M> renderer)
    {
        super(renderer);
    }

    @Override
    public void render(PoseStack stack, MultiBufferSource buffer, int packedLight, T player, float limbSwing, float limbSwingAmount, float partial, float age, float yaw, float pitch)
    {
        stack.pushPose();
        ItemStack necklace = MermaidTail.getNecklace(player);
        if(!necklace.isEmpty() && !player.isInvisible() && player.isInWater())
        {
            Color color = new Color(((NecklaceItem)necklace.getItem()).getColor(necklace));
            String modelName = necklace.getOrCreateTag().getString("MermaidTailModel");
            MermaidTailModel model = MERMAID_TAIL.getOrDefault(modelName, DEFAULT_SUPPLIER).get();
            if(model == null) return;
            model.setAngles(getParentModel());
            model.setupAnim(player, limbSwing, limbSwingAmount, age, yaw, pitch);
            VertexConsumer builder = ItemRenderer.getArmorFoilBuffer(buffer, RenderType.armorCutoutNoCull(model.getTextureLocation()), false, necklace.hasFoil());
            model.renderToBuffer(stack, builder, packedLight, OverlayTexture.NO_OVERLAY, color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, 1.0f);
        }
        stack.popPose();
    }

    public synchronized static void registerModel(ResourceLocation id, Supplier<MermaidTailModel> model)
    {
        MERMAID_TAIL.putIfAbsent(id.toString(), model);
    }
}
