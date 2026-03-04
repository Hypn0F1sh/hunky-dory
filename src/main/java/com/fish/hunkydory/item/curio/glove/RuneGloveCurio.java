package com.fish.hunkydory.item.curio.glove;

import com.fish.hunkydory.attribute.ModAttributes;
import com.fish.hunkydory.hunkydory;
import com.fish.hunkydory.item.curio.HunkydoryCurio;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CurioAttributeModifiers;

public class RuneGloveCurio extends HunkydoryCurio {

    public static final ResourceLocation RUNE_GLOVE_RUNES = hunkydory.hunkydoryPath("rune_glove_runes");
    public static final ResourceLocation HAS_RUNE_GLOVE = hunkydory.hunkydoryPath("has_rune_glove");

    public RuneGloveCurio(Properties properties) {
        super(properties);
    }

    @Override
    public void addAttributeModifiers(CurioAttributeModifiers.Builder builder, ItemStack stack) {
        builder.addModifier(ModAttributes.RUNE_GLOVE, new AttributeModifier(HAS_RUNE_GLOVE, 1, AttributeModifier.Operation.ADD_VALUE));
        builder.addSlotModifier("rune", new AttributeModifier(RUNE_GLOVE_RUNES, 4, AttributeModifier.Operation.ADD_VALUE));
    }
}
