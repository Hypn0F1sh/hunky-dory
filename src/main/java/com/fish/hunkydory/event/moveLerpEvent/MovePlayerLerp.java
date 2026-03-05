package com.fish.hunkydory.event.moveLerpEvent;

import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class MovePlayerLerp {

    public static void Move(Player player, Vec3 start, Vec3 end, int duration, int elapsed) {
        player.noPhysics = true;
        float fraction = elapsed / (float) duration;
        Vec3 difference = end.subtract(start);
        Vec3 position = start.add(difference.scale(fraction));
        player.setPos(position.x, position.y, position.z);
        player.setDeltaMovement(0,0,0);
        player.setPose(Pose.STANDING);
        if (elapsed >= duration) {
            player.noPhysics = false;
            player.setOnGround(true);
            player.setDeltaMovement(0,0,0);
        }
    }
}
