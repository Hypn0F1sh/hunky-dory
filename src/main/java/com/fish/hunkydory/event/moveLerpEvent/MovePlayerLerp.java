package com.fish.hunkydory.event.moveLerpEvent;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class MovePlayerLerp {

    public static boolean Move(Player player, Vec3 start, Vec3 end, int duration, float elapsed) {
        player.noPhysics = true;
        player.setInvulnerable(false);
        Vec3 eye = player.getEyePosition();
        boolean overlay = false;
        float fraction = elapsed / (float) duration;
        Vec3 difference = end.subtract(start);
        Vec3 position = start.add(difference.scale(fraction));
        player.setPos(position.x, position.y, position.z);
        player.setDeltaMovement(0,0,0);
        player.setPose(Pose.STANDING);
        if (!player.level().isEmptyBlock(BlockPos.containing(eye))&&player.level().getBlockState(BlockPos.containing(eye)).blocksMotion()) {
            overlay = true;
            player.setInvulnerable(true);
        }
        if (elapsed < 40) player.setInvulnerable(true);
        if (Math.abs(duration - elapsed) <= 0.5) {
            player.noPhysics = false;
            player.setOnGround(true);
            player.setDeltaMovement(0,0,0);
        }
        return overlay;
    }
}
