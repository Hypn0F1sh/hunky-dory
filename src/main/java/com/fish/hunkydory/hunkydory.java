package com.fish.hunkydory;

import com.fish.hunkydory.attribute.ModAttributes;
import com.fish.hunkydory.block.ModBlocks;
import com.fish.hunkydory.effect.ModEffects;
import com.fish.hunkydory.item.ModItems;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@SuppressWarnings("removal")
@Mod(hunkydory.MODID)
public class hunkydory {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "hunkydory";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public hunkydory(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (hunkydory) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEffects.register(modEventBus);

        ModAttributes.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.OSMIUM_CRYSTAL);
            event.accept(ModItems.RAW_OSMIUM);
            event.accept(ModItems.DRIED_POPPY);
            event.accept(ModItems.DRIED_EYEBLOSSOM);
            event.accept(ModItems.ACTIVE_DRIED_EYEBLOSSOM);
            event.accept(ModItems.PALE_EYE);
            event.accept(ModItems.FLORAL_ICHOR_POPPY);
            event.accept(ModItems.FLORAL_ICHOR_EYEBLOSSOM_CLOSED);
            event.accept(ModItems.FLORAL_ICHOR_EYEBLOSSOM_OPEN);
            event.accept(ModItems.FLORAL_RESIN_POPPY);
            event.accept(ModItems.FLORAL_RESIN_EYEBLOSSOM_CLOSED);
            event.accept(ModItems.FLORAL_RESIN_EYEBLOSSOM_OPEN);
        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.STRATUS);
            event.accept(ModBlocks.SMOOTH_STRATUS);
            event.accept(ModBlocks.OSMIUM_ORE);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.SMOOTH_STRATUS);
            event.accept(ModBlocks.POLISHED_STRATUS);
            event.accept(ModBlocks.STRATUS_BRICKS);
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.LIGHTCASTER);
            event.accept(ModItems.RUNE_GLOVE);
        }

        if(event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(ModBlocks.OSMIUM_FORK);
        }

        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.FLORAL_ICHOR_POPPY);
            event.accept(ModItems.FLORAL_ICHOR_EYEBLOSSOM_CLOSED);
            event.accept(ModItems.FLORAL_ICHOR_EYEBLOSSOM_OPEN);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    public static ResourceLocation hunkydoryPath(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
