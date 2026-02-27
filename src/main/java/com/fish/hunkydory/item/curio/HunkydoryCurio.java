package com.fish.hunkydory.item.curio;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.CurioAttributeModifiers;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.awt.*;

public class HunkydoryCurio extends Item implements ICurioItem {

    public HunkydoryCurio(Item.Properties properties) {
        super(properties);
    }

    public void addAttributeModifiers(CurioAttributeModifiers.Builder builder, ItemStack stack) {
    }

    @Override
    public CurioAttributeModifiers getDefaultCurioAttributeModifiers(ItemStack stack) {
        CurioAttributeModifiers.Builder builder = CurioAttributeModifiers.builder();
        addAttributeModifiers(builder, stack);
        return builder.build();
    }

}
