package com.kevgaming.bestmod.item;

import com.kevgaming.bestmod.BestMod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BestMod.MOD_ID);

    //Ingots/Gems
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));

    //Raw
    public static final RegistryObject<Item> RAW_ALUMINUM = ITEMS.register("raw_aluminum", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));

    //Tools
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(ModTiers.COPPER, 0, -2.4F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(ModTiers.COPPER, -2, -2.8F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(ModTiers.COPPER, -3, -3.0F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(ModTiers.COPPER, 4, -3.2F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register("copper_hoe", () -> new HoeItem(ModTiers.COPPER, -2, -2.0F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));

    public static final RegistryObject<Item> ALUMINUM_SWORD = ITEMS.register("aluminum_sword", () -> new SwordItem(ModTiers.ALUMINUM, 0, -2.4F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> ALUMINUM_PICKAXE = ITEMS.register("aluminum_pickaxe", () -> new PickaxeItem(ModTiers.ALUMINUM, -2, -2.8F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> ALUMINUM_SHOVEL = ITEMS.register("aluminum_shovel", () -> new ShovelItem(ModTiers.ALUMINUM, -3, -3.0F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> ALUMINUM_AXE = ITEMS.register("aluminum_axe", () -> new AxeItem(ModTiers.ALUMINUM, 4, -3.2F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> ALUMINUM_HOE = ITEMS.register("aluminum_hoe", () -> new HoeItem(ModTiers.ALUMINUM, -2, -2.0F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));

    public static final RegistryObject<Item> TIN_SWORD = ITEMS.register("tin_sword", () -> new SwordItem(ModTiers.TIN, 0, -2.4F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> TIN_PICKAXE = ITEMS.register("tin_pickaxe", () -> new PickaxeItem(ModTiers.TIN, -2, -2.8F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> TIN_SHOVEL = ITEMS.register("tin_shovel", () -> new ShovelItem(ModTiers.TIN, -3, -3.0F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> TIN_AXE = ITEMS.register("tin_axe", () -> new AxeItem(ModTiers.TIN, 4, -3.2F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> TIN_HOE = ITEMS.register("tin_hoe", () -> new HoeItem(ModTiers.TIN, -2, -2.0F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));

    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword", () -> new SwordItem(ModTiers.RUBY, 0, -2.2F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new PickaxeItem(ModTiers.RUBY, -2, -2.6F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () -> new ShovelItem(ModTiers.RUBY, -3, -2.8F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe", () -> new AxeItem(ModTiers.RUBY, 5, -2.8F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new HoeItem(ModTiers.RUBY, -7, 0.0F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));

    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", () -> new SwordItem(ModTiers.SAPPHIRE, 0, -2.2F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", () -> new PickaxeItem(ModTiers.SAPPHIRE, -2, -2.6F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", () -> new ShovelItem(ModTiers.SAPPHIRE, -3, -2.8F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", () -> new AxeItem(ModTiers.SAPPHIRE, 5, -2.8F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", () -> new HoeItem(ModTiers.SAPPHIRE, -7, 0.0F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));

    public static final RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword", () -> new SwordItem(ModTiers.AMETHYST, 0, -2.0F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe", () -> new PickaxeItem(ModTiers.AMETHYST, -2, -2.4F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel", () -> new ShovelItem(ModTiers.AMETHYST, -3, -2.6F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> AMETHYST_AXE = ITEMS.register("amethyst_axe", () -> new AxeItem(ModTiers.AMETHYST, 6, -2.6F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> AMETHYST_HOE = ITEMS.register("amethyst_hoe", () -> new HoeItem(ModTiers.AMETHYST, -8, 0.0F, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));

    //Armor
    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet", () -> new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate", () -> new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings", () -> new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots", () -> new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));

    public static final RegistryObject<Item> ALUMINUM_HELMET = ITEMS.register("aluminum_helmet", () -> new ArmorItem(ModArmorMaterials.ALUMINUM, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> ALUMINUM_CHESTPLATE = ITEMS.register("aluminum_chestplate", () -> new ArmorItem(ModArmorMaterials.ALUMINUM, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> ALUMINUM_LEGGINGS = ITEMS.register("aluminum_leggings", () -> new ArmorItem(ModArmorMaterials.ALUMINUM, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> ALUMINUM_BOOTS = ITEMS.register("aluminum_boots", () -> new ArmorItem(ModArmorMaterials.ALUMINUM, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));

    public static final RegistryObject<Item> TIN_HELMET = ITEMS.register("tin_helmet", () -> new ArmorItem(ModArmorMaterials.TIN, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> TIN_CHESTPLATE = ITEMS.register("tin_chestplate", () -> new ArmorItem(ModArmorMaterials.TIN, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> TIN_LEGGINGS = ITEMS.register("tin_leggings", () -> new ArmorItem(ModArmorMaterials.TIN, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> TIN_BOOTS = ITEMS.register("tin_boots", () -> new ArmorItem(ModArmorMaterials.TIN, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));

    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet", () -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots", () -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));

    public static final RegistryObject<Item> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", () -> new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));

    public static final RegistryObject<Item> AMETHYST_HELMET = ITEMS.register("amethyst_helmet", () -> new ArmorItem(ModArmorMaterials.AMETHYST, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate", () -> new ArmorItem(ModArmorMaterials.AMETHYST, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings", () -> new ArmorItem(ModArmorMaterials.AMETHYST, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));
    public static final RegistryObject<Item> AMETHYST_BOOTS = ITEMS.register("amethyst_boots", () -> new ArmorItem(ModArmorMaterials.AMETHYST, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.BEST_TAB)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
