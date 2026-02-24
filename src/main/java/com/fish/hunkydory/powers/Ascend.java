package com.fish.hunkydory.powers;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class Ascend {

    public static final int maxCeilingDistance = 8;
    public static final int maxTerrainDistance = 200;

    public void activate(Level world, LivingEntity user) {

    }

    public boolean preview(Level world, LivingEntity user) {
        return true;
    }
}
