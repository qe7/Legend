package io.github.qe7.features.impl.modules.impl;

import org.lwjgl.input.Keyboard;

import io.github.qe7.features.impl.modules.api.Module;
import io.github.qe7.features.impl.modules.api.enums.ModuleCategory;

public class TileEntityDupeModule extends Module{

	public TileEntityDupeModule() {
		super("TileEntityDupe", "you can make understacked items via dis thing", ModuleCategory.MISC);
		this.setKeyBind(Keyboard.KEY_N);
	}

}
