package com.kevgaming.bestmod.sound;

import com.kevgaming.bestmod.BestMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds
{
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BestMod.MOD_ID);

    public static final RegistryObject<SoundEvent> IF_I_HAD_A_CHICKEN = registerSoundEvent("if_i_had_a_chicken");
    public static final RegistryObject<SoundEvent> FLUFFING_A_DUCK = registerSoundEvent("fluffing_a_duck");
    public static final RegistryObject<SoundEvent> SNEAKY_SNITCH = registerSoundEvent("sneaky_snitch");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name)
    {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(BestMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus)
    {
        SOUND_EVENTS.register(eventBus);
    }
}
