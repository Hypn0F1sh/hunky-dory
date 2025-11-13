package com.fish.hunkydory.block;

import com.fish.hunkydory.hunkydory;
import com.fish.hunkydory.item.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(hunkydory.MODID);

    public static final DeferredBlock<Block> STRATUS = registerBlock("stratus",
            properties -> new Block(properties),BlockBehaviour.Properties.of()
                    .strength(6f).requiresCorrectToolForDrops().sound(SoundType.TUFF));

    public static final DeferredBlock<Block> SMOOTH_STRATUS = registerBlock("smooth_stratus",
            properties -> new Block(properties),BlockBehaviour.Properties.of()
                    .strength(6f).requiresCorrectToolForDrops().sound(SoundType.TUFF));

    public static final DeferredBlock<Block> STRATUS_BRICKS = registerBlock("stratus_bricks",
            properties -> new Block(properties),BlockBehaviour.Properties.of()
                    .strength(6f).requiresCorrectToolForDrops().sound(SoundType.TUFF));

    public static final DeferredBlock<Block> POLISHED_STRATUS = registerBlock("polished_stratus",
            properties -> new Block(properties),BlockBehaviour.Properties.of()
                    .strength(6f).requiresCorrectToolForDrops().sound(SoundType.TUFF));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends T> blockFactory, BlockBehaviour.Properties blockProperties) {
        DeferredBlock<T> block = BLOCKS.registerBlock(name, blockFactory, blockProperties);
        registerBlockItem(name, block);
        return block;
    }

    private static <B extends Block> void registerBlockItem(String name, DeferredBlock<B> block) {
        ModItems.ITEMS.registerSimpleBlockItem(name, block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
