package com.fish.hunkydory.item.curio;

import com.fish.hunkydory.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class HunkydoryCurio extends Item implements ICurioItem {

    public HunkydoryCurio() {
        super(new Item.Properties().stacksTo(1).durability(0));
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        // ticking logic here
    }
}
