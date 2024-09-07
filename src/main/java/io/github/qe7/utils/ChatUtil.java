package io.github.qe7.utils;

import net.minecraft.client.Minecraft;

public final class ChatUtil {

    public static void addChatMessage(final String message) {
        Minecraft.theMinecraft.thePlayer.addChatMessage(message);
    }
}
