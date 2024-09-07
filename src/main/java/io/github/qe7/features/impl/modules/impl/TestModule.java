package io.github.qe7.features.impl.modules.impl;

import io.github.qe7.events.RenderScreenEvent;
import io.github.qe7.events.TickUpdateEvent;
import io.github.qe7.features.impl.modules.api.Module;
import io.github.qe7.features.impl.modules.api.enums.ModuleCategory;
import io.github.qe7.utils.ChatUtil;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraft.src.FontRenderer;
import org.lwjgl.input.Keyboard;

public class TestModule extends Module {

    public TestModule() {
        super("Test", "A test module", ModuleCategory.MISC);

        this.setKeyBind(Keyboard.KEY_F);
    }

    @Override
    public void onEnable() {
        super.onEnable();

        ChatUtil.addChatMessage("Test module enabled!");
    }

    @Override
    public void onDisable() {
        super.onDisable();

        ChatUtil.addChatMessage("Test module disabled!");
    }

    @Subscribe
    public final Listener<TickUpdateEvent> tickUpdateEventListener = new Listener<>(event -> {
        ChatUtil.addChatMessage("Test module ticked!");
    });

    @Subscribe
    public final Listener<RenderScreenEvent> renderScreenEventListener = new Listener<>(event -> {
        final FontRenderer fontRenderer = Minecraft.theMinecraft.fontRenderer;

        fontRenderer.drawStringWithShadow("Fuck you", 2, 2, -1);
    });
}
