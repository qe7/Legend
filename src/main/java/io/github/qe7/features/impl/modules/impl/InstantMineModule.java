package io.github.qe7.features.impl.modules.impl;

import org.lwjgl.input.Keyboard;

import io.github.qe7.features.impl.modules.api.Module;
import io.github.qe7.features.impl.modules.api.enums.ModuleCategory;

public class InstantMineModule extends Module{

	public InstantMineModule() {
		super("Instant", "instantly mines blocks", ModuleCategory.MISC);
		this.setKeyBind(Keyboard.KEY_M);
	}

}
