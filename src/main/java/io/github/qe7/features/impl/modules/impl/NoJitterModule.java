package io.github.qe7.features.impl.modules.impl;

import org.lwjgl.input.Keyboard;

import io.github.qe7.features.impl.modules.api.Module;
import io.github.qe7.features.impl.modules.api.enums.ModuleCategory;
import io.github.qe7.utils.ChatUtil;

public class NoJitterModule extends Module{

	public NoJitterModule() {
		super("No Jitter", "REAL!!!!",  ModuleCategory.RENDER);
		this.setKeyBind(Keyboard.KEY_Z);
	}
}
