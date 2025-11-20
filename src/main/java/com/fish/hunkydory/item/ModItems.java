package com.fish.hunkydory.item;

import com.fish.hunkydory.hunkydory;
import com.fish.hunkydory.item.custom.ModFoodProperties;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(hunkydory.MODID);

    public static final DeferredItem<Item> OSMIUM_CRYSTAL = ITEMS.registerItem("osmium_crystal",
            Item::new, new Item.Properties());

    public static final DeferredItem<Item> RAW_OSMIUM = ITEMS.registerItem("raw_osmium",
            Item::new, new Item.Properties());

    public static final DeferredItem<Item> LIGHTCASTER = ITEMS.registerItem("lightcaster",
            Item::new, new Item.Properties());

    public static final DeferredItem<Item> DRIED_POPPY = ITEMS.registerItem("dried_poppy",
            Item::new, new Item.Properties());

    public static final DeferredItem<Item> FLORAL_ICHOR = ITEMS.register("floral_ichor", () -> new Item(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(hunkydory.MODID, "floral_ichor")))
            .food(ModFoodProperties.FLORAL_ICHOR)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .component(
                    DataComponents.CONSUMABLE,
                    Consumable.builder()
                            .consumeSeconds(2f)
                            .animation(ItemUseAnimation.DRINK)
                            .sound(SoundEvents.HONEY_DRINK)
                            .hasConsumeParticles(false)
                            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 6000, 0), 1.0f))
                            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.UNLUCK, 6000, 10), .25f))
                            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.BLINDNESS, 6000, 0), .10f))
                            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HUNGER, 6000, 10), .25f))
                            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SLOWNESS, 6000, 10), .10f))
                            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 6000, 10), 1.0f))
                            .build())
    ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
