package io.github.qe7.features.impl.modules.impl;

import java.util.Map.Entry;

import org.lwjgl.input.Keyboard;

import io.github.qe7.Client;
import io.github.qe7.events.RenderScreenEvent;
import io.github.qe7.features.impl.modules.api.Module;
import io.github.qe7.features.impl.modules.api.enums.ModuleCategory;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraft.src.FontRenderer;

public class ArrayListModule extends Module{

	public ArrayListModule() {
		super("ArrayList", "Shows all hax", ModuleCategory.RENDER);
		this.setKeyBind(Keyboard.KEY_C);
	}

	@Subscribe
    public final Listener<RenderScreenEvent> renderScreenEventListener = new Listener<>(RenderScreenEvent.class, event -> {
        final FontRenderer fontRenderer = Minecraft.theMinecraft.fontRenderer;
        int y = 2;
        for(Entry<Class<? extends Module>, Module> cliff : Client.getInstance().getModuleManager().registry.entrySet()) {
        	if(cliff.getValue().isEnabled()) {
        		String str = cliff.getValue().getName() + ": " + Keyboard.getKeyName(cliff.getValue().getKeyBind());
            	fontRenderer.drawStringWithShadow(str, 2, y, -1);
            	y = y + 10;
        	}
        }
    });
}
