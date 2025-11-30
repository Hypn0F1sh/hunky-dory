package com.fish.hunkydory.functions;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import com.fish.hunkydory.functions.BackFunctions;

public class UtilFunctions {

    public static boolean entityLookingAtPlayer(Entity entity, Player player) {
        Vec3 entityLook = entity.getLookAngle().normalize();

        Vec3 eyePosEntity = entity.getEyePosition();
        Vec3 eyePosPlayer = player.getEyePosition();

        Vec3 toPlayer = eyePosPlayer.subtract(eyePosEntity).normalize();

        double dot = entityLook.dot(toPlayer);

        return dot > 0.5 && BackFunctions.simpleLineOfSight(entity, player);
    }

    public static boolean PlayerOnScreen(LocalPlayer viewer, Entity target, Frustum frustum) {
        AABB box = target.getBoundingBox();

        AABB expanded = box.inflate(0.1);

        return frustum.isVisible(expanded);
    }
}
