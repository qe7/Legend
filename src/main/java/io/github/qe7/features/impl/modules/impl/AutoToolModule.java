package io.github.qe7.features.impl.modules.impl;

import org.lwjgl.input.Keyboard;

import io.github.qe7.events.RenderScreenEvent;
import io.github.qe7.events.TickUpdateEvent;
import io.github.qe7.features.impl.modules.api.Module;
import io.github.qe7.features.impl.modules.api.enums.ModuleCategory;
import io.github.qe7.utils.ChatUtil;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.Subscribe;
import net.minecraft.client.Minecraft;

public class AutoToolModule extends Module{

	public AutoToolModule() {
		super("AutoTool", "Auto Tool real", ModuleCategory.MISC);
		this.setKeyBind(Keyboard.KEY_X);
	}

	@Subscribe  //SKIDDED FROM WSNDOW'S CLIENT BUDDY
    public final Listener<TickUpdateEvent> renderScreenEventListener = new Listener<>(TickUpdateEvent.class, event -> {
    		if(Minecraft.theMinecraft.breakingBlock != null) {
    			for(int i = 0;i < 9;i++) {
    				if(Minecraft.theMinecraft.thePlayer.inventory.mainInventory[i] != null && Minecraft.theMinecraft.thePlayer.inventory.mainInventory[i].canHarvestBlock(Minecraft.theMinecraft.breakingBlock)) {
    					Minecraft.theMinecraft.thePlayer.inventory.currentItem = i;
    					break;
    				}
    			}
    		}
    });
}
