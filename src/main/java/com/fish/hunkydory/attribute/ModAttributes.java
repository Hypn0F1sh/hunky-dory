package com.fish.hunkydory.attribute;

import com.fish.hunkydory.hunkydory;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.BooleanAttribute;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(
            BuiltInRegistries.ATTRIBUTE, hunkydory.MODID);

    public static final Holder<Attribute> HAS_ARM = ATTRIBUTES.register("has_arm", () -> new BooleanAttribute(
            "attributes.yourmodid.has_arm",
            false));

    public static void register(IEventBus eventBus) {ATTRIBUTES.register(eventBus);
    }
}
