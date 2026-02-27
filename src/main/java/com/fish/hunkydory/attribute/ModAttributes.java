package com.fish.hunkydory.attribute;

import com.fish.hunkydory.hunkydory;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(
            BuiltInRegistries.ATTRIBUTE, hunkydory.MODID);

    public static final Holder<Attribute> RUNE_GLOVE = ATTRIBUTES.register("has_arm", () -> new RangedAttribute(
            "attributes.yourmodid.has_arm",
            0,
            0,
            2));

    public static void register(IEventBus eventBus) {ATTRIBUTES.register(eventBus);
    }
}
