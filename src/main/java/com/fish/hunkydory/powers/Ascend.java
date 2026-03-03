package com.fish.hunkydory.powers;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class Ascend {

    public static final int maxCeilingDistance = 6;
    public static final int maxTerrainDistance = 512;
    public static final Block[] invalidBlocks = {Blocks.BEDROCK};

    public static void activate(Level world, LivingEntity user) {
        if (preview(world, user)) {
            doAscend(checkValid(world, user), user);
        }
    }

    public static boolean preview(Level world, LivingEntity user) {
        boolean result = false;
        if (checkValid(world, user)[0] == 1) {
            result = true;
        }
        return result;
    }

    public static int[] checkValid(Level world, LivingEntity user) {
        int[] result = new int[4];
        if (user.isInLiquid() || ! user.isSupportedBy(user.getOnPos())) {return result;}
        BlockPos pos = user.getOnPos().above(1);
        int roofHeight = 0;
        for (int y = 0; y < maxCeilingDistance; y++) {
            if (!world.isEmptyBlock(pos.above(y))) {
                roofHeight = y;
                System.out.println("valid roof");
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
                    if (world.isEmptyBlock(pos.above(roofHeight+topHeight+1))) {
                        result[0] = 1;
                        System.out.println("valid terrain");
                    }
                    break;
                }
            }
        }
        result[1] = roofHeight;
        result[2] = topHeight;
        return result;
    }

    public static void doAscend(int[] data, LivingEntity user) {
        BlockPos userPos = user.getOnPos();
        System.out.println(Integer.toString(userPos.getX()) + " " + Integer.toString(userPos.above(data[1]+data[2]).getY()) + " " + Integer.toString(userPos.getZ()));
        //user.teleportTo(userPos.getX(), userPos.above(data[1]+data[2]).getY(), userPos.getZ());
        user.setPos(userPos.getX()+0.5, userPos.above(data[1]+data[2]).getY()+1, userPos.getZ()+0.5);
    }
}
