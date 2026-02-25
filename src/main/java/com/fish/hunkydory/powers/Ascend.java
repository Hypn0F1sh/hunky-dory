package com.fish.hunkydory.powers;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;


public class Ascend {

    public static final int maxCeilingDistance = 8;
    public static final int maxTerrainDistance = 512;
    public static final Block[] invalidBlocks = {Blocks.BEDROCK};

    public void activate(Level world, LivingEntity user) {
        if (preview(world, user)) {
            doAscend(checkValid(world, user), user);
        }
    }

    public boolean preview(Level world, LivingEntity user) {
        boolean result = false;
        if (checkValid(world, user)[0] == 1) {
            result = true;
        }
        return result;
    }

    public int[] checkValid(Level world, LivingEntity user) {
        int[] result = new int[4];
        BlockPos pos = user.getOnPos();
        int roofHeight = 0;
        for (int y = 0; y < maxCeilingDistance; y++) {
            if (!world.isEmptyBlock(pos.above(y))) {
                roofHeight = y;
                break;
            }
        }
        int topHeight = 0;
        if (roofHeight != 0) {
            for (int i = 1; i < maxTerrainDistance; i++) {
                for (Block block: invalidBlocks) {
                    if (world.getBlockState(pos.above(roofHeight + i)).getBlock() == block) {
                        break;
                    }
                }
                if (world.isEmptyBlock(pos.above(roofHeight + i))) {
                    topHeight = i;
                    result[0] = 1;
                    break;
                }
            }
        }
        result[1] = roofHeight;
        result[2] = topHeight;
        return result;
    }

    public void doAscend(int[] data, LivingEntity user) {
        BlockPos userPos = user.getOnPos();
        user.teleportTo(userPos.getX(), userPos.above(data[1]+data[2]).getY(), userPos.getZ());
    }
}
