package io.github.qe7.features.impl.modules.impl;

import org.lwjgl.input.Keyboard;

import io.github.qe7.events.TickUpdateEvent;
import io.github.qe7.events.packet.IncomingPacketEvent;
import io.github.qe7.features.impl.modules.api.Module;
import io.github.qe7.features.impl.modules.api.enums.ModuleCategory;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.Subscribe;
import net.minecraft.client.Minecraft;

public class NoFallModule extends Module {

	public NoFallModule() {
		super("NoFall", "removes fall damage", ModuleCategory.MOVEMENT);
		this.setKeyBind(Keyboard.KEY_G);
	}

	@Subscribe  //SKIDDED FROM WSNDOW'S CLIENT BUDDY
    public final Listener<TickUpdateEvent> eventListener = new Listener<>(TickUpdateEvent.class, event -> {
    		if(Minecraft.theMinecraft.thePlayer != null) {
    			Minecraft.theMinecraft.thePlayer.fallDistance = 0.0f;
    		}
    });
}
