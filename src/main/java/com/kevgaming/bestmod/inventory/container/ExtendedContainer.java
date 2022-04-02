package com.kevgaming.bestmod.inventory.container;

import com.kevgaming.bestmod.addons.mermaidtail.MermaidTailEvents;
import com.kevgaming.bestmod.item.custom.NecklaceItem;
import com.mojang.datafixers.util.Pair;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class ExtendedContainer extends InventoryMenu
{
    public ExtendedContainer(Inventory playerInventory, boolean localWorld, Player playerIn)
    {
        super(playerInventory, localWorld, playerIn);
        this.addSlot(new Slot(playerInventory, 41, 77, 44)
        {
            public Pair<ResourceLocation, ResourceLocation> getNoItemIcon()
            {
                return Pair.of(InventoryMenu.BLOCK_ATLAS, MermaidTailEvents.EMPTY_NECKLACE_SLOT);
            }

            public boolean mayPlace(ItemStack stack)
            {
                return stack.getItem() instanceof NecklaceItem;
            }

            public boolean mayPickup(Player pPlayer)
            {
                CompoundTag tag = this.getItem().getTag();
                return tag == null || tag.getList("Items", Tag.TAG_COMPOUND).isEmpty();
            }
        });
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if(slot != null && slot.hasItem())
        {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            EquipmentSlot equipmentslot = Mob.getEquipmentSlotForItem(itemstack);
            if(index != 46 && itemstack.getItem() instanceof NecklaceItem)
            {
                if(!this.slots.get(46).hasItem()) if(!this.moveItemStackTo(itemstack1, 46, 47, false)) return ItemStack.EMPTY;
            } else if(index == 0) {
                if(!this.moveItemStackTo(itemstack1, 9, 45, true)) return ItemStack.EMPTY;
                slot.onQuickCraft(itemstack1, itemstack);
            } else if(index >= 1 && index < 5) {
                if(!this.moveItemStackTo(itemstack1, 9, 45, false)) return ItemStack.EMPTY;
            } else if(index >= 5 && index < 9) {
                if(!this.moveItemStackTo(itemstack1, 9, 45, false)) return ItemStack.EMPTY;
            } else if(equipmentslot.getType() == EquipmentSlot.Type.ARMOR && !this.slots.get(8 - equipmentslot.getIndex()).hasItem()) {
                int i = 8 - equipmentslot.getIndex();
                if(!this.moveItemStackTo(itemstack1, i, i + 1, false)) return ItemStack.EMPTY;
            } else if(equipmentslot == EquipmentSlot.OFFHAND && !this.slots.get(45).hasItem()) {
                if(!this.moveItemStackTo(itemstack1, 45, 46, false)) return ItemStack.EMPTY;
            } else if (index >= 9 && index < 36) {
                if(!this.moveItemStackTo(itemstack1, 36, 45, false)) return ItemStack.EMPTY;
            } else if(index >= 36 && index < 45) {
                if(!this.moveItemStackTo(itemstack1, 9, 36, false)) return ItemStack.EMPTY;
            } else if(!this.moveItemStackTo(itemstack1, 9, 45, false)) {
                return ItemStack.EMPTY;
            }
            if(itemstack1.isEmpty()) slot.set(ItemStack.EMPTY);
            else slot.setChanged();
            if(itemstack1.getCount() == itemstack.getCount()) return ItemStack.EMPTY;
            slot.onTake(playerIn, itemstack1);
            if(index == 0) playerIn.drop(itemstack1, false);
        }
        return itemstack;
    }
}
