package com.fish.hunkydory;

import com.fish.hunkydory.attribute.ModAttributes;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;

@Mod(hunkydory.MODID)
@EventBusSubscriber
public class EventHandler {

    @SubscribeEvent // on the mod event bus
    public static void modifyDefaultAttributes(EntityAttributeModificationEvent event) {
        event.add(
                EntityType.PLAYER,
                ModAttributes.HAS_ARM
        );
    }
}
