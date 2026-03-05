package com.fish.hunkydory.event.moveLerpEvent;

import com.fish.hunkydory.hunkydory;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
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

        MovePlayerLerp.Move(player, task.start, task.end, task.duration, task.elapsed);

        if (task.elapsed >= task.duration) {
            ACTIVE_LERP.remove(player.getUUID());
        }

        task.elapsed++;
    }
}
