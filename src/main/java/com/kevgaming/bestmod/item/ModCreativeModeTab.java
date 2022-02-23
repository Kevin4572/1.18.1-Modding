package com.kevgaming.bestmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab
{
    public static final CreativeModeTab BEST_TAB = new CreativeModeTab("besttab")
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(ModItems.ALUMINUM_INGOT.get());
        }
    };
}
