package com.fish.hunkydory.effect;

import com.fish.hunkydory.hunkydory;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, hunkydory.MODID);

    public static final Holder<MobEffect> BAD_FEELING_EFFECT = MOB_EFFECTS.register("bad_feeling",
            () -> new BadFeelingEffect(MobEffectCategory.HARMFUL, 0x441f63)
                    .addAttributeModifier(Attributes.BLOCK_BREAK_SPEED,
                            ResourceLocation.fromNamespaceAndPath(hunkydory.MODID, "bad_feeling"), -0.05f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(Attributes.BLOCK_INTERACTION_RANGE,
                            ResourceLocation.fromNamespaceAndPath(hunkydory.MODID, "bad_feeling"), -0.05f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
