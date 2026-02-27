package com.fish.hunkydory;


import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class ModKeys {

    public static KeyMapping.Category HUNKYDORY_CATEGORY = new KeyMapping.Category(hunkydory.hunkydoryPath("category"));

    public static final KeyMapping USE_RUNES = new KeyMapping(
        "key.hunkydory.use_runes",
        KeyConflictContext.IN_GAME,
        InputConstants.Type.KEYSYM,
        GLFW.GLFW_KEY_R,
        HUNKYDORY_CATEGORY
    );

    public static void register(RegisterKeyMappingsEvent event) {
        event.registerCategory(HUNKYDORY_CATEGORY);
        event.register(USE_RUNES);
    }
}
