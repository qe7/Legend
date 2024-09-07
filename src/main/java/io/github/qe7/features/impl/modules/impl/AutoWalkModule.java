package io.github.qe7.features.impl.modules.impl;

import org.lwjgl.input.Keyboard;

import io.github.qe7.features.impl.modules.api.Module;
import io.github.qe7.features.impl.modules.api.enums.ModuleCategory;

public class AutoWalkModule extends Module {

	public AutoWalkModule() {
		super("AutoWalk", "Walk in afk!", ModuleCategory.MOVEMENT);
		this.setKeyBind(Keyboard.KEY_K);
	}
}
