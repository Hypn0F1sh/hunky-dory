package com.fish.hunkydory.functions;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.joml.Matrix4f;

public class BackFunctions {

    public static boolean simpleLineOfSight(Entity viewer, Entity target) {
        Level level = viewer.level();

        Vec3 start = viewer.getEyePosition();
        Vec3 end = target.getEyePosition();

        ClipContext context = new ClipContext(
                start,
                end,
                ClipContext.Block.COLLIDER,  // solid blocks
                ClipContext.Fluid.NONE,
                viewer
        );

        BlockHitResult result = level.clip(context);

        // If the ray returns a hit BEFORE reaching the target, LOS is blocked
        if (result.getType() == HitResult.Type.BLOCK) {
            double blockDist = result.getLocation().distanceTo(start);
            double targetDist = end.distanceTo(start);
            return blockDist >= targetDist;
        }

        return true; // no block hit
    }

    public static Vec3[] getAabbVertices(AABB box) {
        return new Vec3[]{
                new Vec3(box.minX, box.minY, box.minZ),
                new Vec3(box.minX, box.minY, box.maxZ),
                new Vec3(box.minX, box.maxY, box.minZ),
                new Vec3(box.minX, box.maxY, box.maxZ),

                new Vec3(box.maxX, box.minY, box.minZ),
                new Vec3(box.maxX, box.minY, box.maxZ),
                new Vec3(box.maxX, box.maxY, box.minZ),
                new Vec3(box.maxX, box.maxY, box.maxZ)
        };
    }

    @SubscribeEvent
    public void onRenderLevel(RenderLevelStageEvent event) {
        PoseStack poseStack = event.getPoseStack();
        Camera camera = Minecraft.getInstance().gameRenderer.getMainCamera();
        float partial = Minecraft.getInstance().getFrameTimeNs();
        Matrix4f projection = Minecraft.getInstance().gameRenderer.getProjectionMatrix(partial);
        Frustum frustum = new Frustum(
                poseStack.last().pose(),
                projection
        );

        frustum.prepare(camera.getPosition().x, camera.getPosition().y, camera.getPosition().z);
    }
}