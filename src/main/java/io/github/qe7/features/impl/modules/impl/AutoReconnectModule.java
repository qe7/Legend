package io.github.qe7.features.impl.modules.impl;

import org.lwjgl.input.Keyboard;

import io.github.qe7.events.RenderScreenEvent;
import io.github.qe7.events.packet.IncomingPacketEvent;
import io.github.qe7.features.impl.modules.api.Module;
import io.github.qe7.features.impl.modules.api.enums.ModuleCategory;
import io.github.qe7.utils.ChatUtil;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Packet255KickDisconnect;

public class AutoReconnectModule extends Module{

	public AutoReconnectModule() {
		super("AutoReconnect", "auto reconnect", ModuleCategory.MISC);
		this.setKeyBind(Keyboard.KEY_J);
	}
	
	@Subscribe
    public final Listener<IncomingPacketEvent> incomingPacketEventListener = new Listener<>(IncomingPacketEvent.class, event -> {
    	Minecraft mc = Minecraft.theMinecraft;
        if(event.getPacket() instanceof Packet255KickDisconnect) {
        	long start = System.currentTimeMillis();
        	while(System.currentTimeMillis() - start == 5000) {}
        	mc.needToReconnect = true;
        }
    });
}
