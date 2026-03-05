package com.fish.hunkydory.event.moveLerpEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

public class PlayerLerpMoveEvent extends PlayerEvent {

    public static Vec3 startPos;
    public static Vec3 endPos;
    public static int moveDuration;

    public PlayerLerpMoveEvent(Player player, Vec3 start, Vec3 end, int duration) {
        super(player);
        startPos = start;
        endPos = end;
        moveDuration = duration;
    }

    public static Vec3 getStart() {
        return startPos;
    }

    public static Vec3 getEnd() {
        return endPos;
    }

    public static int getDuration() {
        return moveDuration;
    }
}
