package com.fish.hunkydory.item;

import com.fish.hunkydory.hunkydory;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(hunkydory.MODID);

    public static final DeferredItem<Item> OSMIUM_CRYSTAL = ITEMS.registerItem("osmium_crystal",
            Item::new, new Item.Properties());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
