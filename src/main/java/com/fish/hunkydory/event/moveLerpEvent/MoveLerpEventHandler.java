package com.fish.hunkydory.event.moveLerpEvent;

import com.fish.hunkydory.hunkydory;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod(hunkydory.MODID)
@EventBusSubscriber
public class MoveLerpEventHandler {

    public MoveLerpEventHandler() {
        NeoForge.EVENT_BUS.register(MoveLerpEventHandler.class);
    }

    public static final Map<UUID, LerpMovementTask> ACTIVE_LERP = new HashMap<>();

    public static boolean overlay = false;

    @SubscribeEvent
    public static void onPlayerLerpMoveEvent(PlayerLerpMoveEvent event) {

        Player player = event.getEntity();

        LerpMovementTask task = new LerpMovementTask(
                event.getStart(),
                event.getEnd(),
                event.getDuration()
        );

        ACTIVE_LERP.put(player.getUUID(), task);
    }

    @SubscribeEvent
    public static void onPlayerTickEvent(PlayerTickEvent.Post event) {

        Player player = event.getEntity();

        LerpMovementTask task = ACTIVE_LERP.get(player.getUUID());
        if (task == null) return;

        overlay = MovePlayerLerp.Move(player, task.start, task.end, task.duration, task.elapsed);

        if (Math.abs(task.duration - task.elapsed) <= 0.5) {
            ACTIVE_LERP.remove(player.getUUID());
        }

        if (task.duration - task.elapsed <= 20) {
            task.elapsed += (float) ((task.duration - task.elapsed)*0.05);
        } else task.elapsed++;
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        event.setCanceled(overlay);
    }

    @SubscribeEvent
    public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        event.setCanceled(overlay);
    }

    @SubscribeEvent
    public static void onAttack(AttackEntityEvent event) {
        event.setCanceled(overlay);
    }

    @SubscribeEvent
    public static void renderOverlay(RenderGuiEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();

        if (!overlay) return;
    }
}
