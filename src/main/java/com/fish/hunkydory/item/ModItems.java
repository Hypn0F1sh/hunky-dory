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

    public static final DeferredItem<Item> DRIED_EYEBLOSSOM = ITEMS.registerItem("dried_eyeblossom",
            Item::new, new Item.Properties());

    public static final DeferredItem<Item> ACTIVE_DRIED_EYEBLOSSOM = ITEMS.registerItem("active_dried_eyeblossom",
            Item::new, new Item.Properties());

    public static final DeferredItem<Item> PALE_EYE = ITEMS.registerItem("pale_eye",
            Item::new, new Item.Properties());


    public static final DeferredItem<Item> FLORAL_ICHOR_POPPY = ITEMS.register("floral_ichor_poppy", () -> new Item(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(hunkydory.MODID, "floral_ichor_poppy")))
            .food(ModFoodProperties.FLORAL_ICHOR_POPPY)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .stacksTo(16)
            .component(
                    DataComponents.CONSUMABLE,
                    Consumable.builder()
                            .consumeSeconds(1f)
                            .animation(ItemUseAnimation.DRINK)
                            .sound(SoundEvents.HONEY_DRINK)
                            .hasConsumeParticles(false)
                            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HASTE, 1200, 5), .75f))
                            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MINING_FATIGUE, 1200, 5), .25f))
                            .build())
    ));

    public static final DeferredItem<Item> FLORAL_ICHOR_EYEBLOSSOM_CLOSED = ITEMS.register("floral_ichor_eyeblossom_closed", () -> new Item(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(hunkydory.MODID, "floral_ichor_eyeblossom_closed")))
            .food(ModFoodProperties.FLORAL_ICHOR_EYEBLOSSOM_CLOSED)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .stacksTo(16)
            .component(
                    DataComponents.CONSUMABLE,
                    Consumable.builder()
                            .consumeSeconds(1f)
                            .animation(ItemUseAnimation.DRINK)
                            .sound(SoundEvents.HONEY_DRINK)
                            .hasConsumeParticles(false)
                            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 1200, 5), .75f))
                            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.POISON, 1200, 5), .25f))
                            .build())
    ));

    public static final DeferredItem<Item> FLORAL_ICHOR_EYEBLOSSOM_OPEN = ITEMS.register("floral_ichor_eyeblossom_open", () -> new Item(new Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(hunkydory.MODID, "floral_ichor_eyeblossom_open")))
            .food(ModFoodProperties.FLORAL_ICHOR_EYEBLOSSOM_OPEN)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .stacksTo(16)
            .component(
                    DataComponents.CONSUMABLE,
                    Consumable.builder()
                            .consumeSeconds(1f)
                            .animation(ItemUseAnimation.DRINK)
                            .sound(SoundEvents.HONEY_DRINK)
                            .hasConsumeParticles(false)
                            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.INSTANT_HEALTH, 1, 5), 1f))
                            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1, 5), .125f))
                            .build())
    ));

    public static final DeferredItem<Item> FLORAL_RESIN_POPPY = ITEMS.registerItem("floral_resin_poppy",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> FLORAL_RESIN_EYEBLOSSOM_CLOSED = ITEMS.registerItem("floral_resin_eyeblossom_closed",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> FLORAL_RESIN_EYEBLOSSOM_OPEN = ITEMS.registerItem("floral_resin_eyeblossom_open",
            Item::new, new Item.Properties());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
