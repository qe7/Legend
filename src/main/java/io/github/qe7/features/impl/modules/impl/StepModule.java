package io.github.qe7.features.impl.modules.impl;

import org.lwjgl.input.Keyboard;

import io.github.qe7.features.impl.modules.api.Module;
import io.github.qe7.features.impl.modules.api.enums.ModuleCategory;

public class StepModule extends Module{

	public StepModule() {
		super("Step", "YOU KNOW", ModuleCategory.MOVEMENT);
		this.setKeyBind(Keyboard.KEY_Y);
	}

	
}
