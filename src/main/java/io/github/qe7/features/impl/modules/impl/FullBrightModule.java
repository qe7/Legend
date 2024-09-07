package io.github.qe7.features.impl.modules.impl;

import org.lwjgl.input.Keyboard;

import io.github.qe7.features.impl.modules.api.Module;
import io.github.qe7.features.impl.modules.api.enums.ModuleCategory;
import net.minecraft.client.Minecraft;

public class FullBrightModule extends Module{

	public FullBrightModule() {
		super("FullBright", "uhhm idk", ModuleCategory.RENDER);
		this.setKeyBind(Keyboard.KEY_B);
	}

	@Override
	public void onEnable() {
		super.onEnable();
		Minecraft.theMinecraft.renderGlobal.loadRenderers();
    }

	@Override
    public void onDisable() {
    	super.onDisable();
    	Minecraft.theMinecraft.renderGlobal.loadRenderers();
    }
}
