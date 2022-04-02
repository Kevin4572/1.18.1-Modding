package com.kevgaming.bestmod.mixins;

import com.kevgaming.bestmod.inventory.ExtendedInventory;
import com.kevgaming.bestmod.inventory.container.ExtendedContainer;
import com.mojang.authlib.GameProfile;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerEntityMixin
{
    @Shadow
    @Final
    @Mutable
    private Inventory inventory;

    @Shadow
    @Final
    @Mutable
    public InventoryMenu inventoryMenu;

    @Inject(method = "<init>", at = @At(value = "TAIL"))
    private void constructorTail(Level world, BlockPos pos, float spawnAngle, GameProfile profile, CallbackInfo ci)
    {
        Player player = (Player)(Object)this;
        this.inventory = new ExtendedInventory(player);
        this.inventoryMenu = new ExtendedContainer(this.inventory, !world.isClientSide, player);
        player.containerMenu = this.inventoryMenu;
    }
}
