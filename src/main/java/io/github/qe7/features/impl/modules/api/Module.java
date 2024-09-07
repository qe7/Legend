package io.github.qe7.features.impl.modules.api;

import io.github.qe7.Client;
import io.github.qe7.features.impl.commands.api.Command;
import io.github.qe7.features.impl.modules.api.enums.ModuleCategory;
import me.zero.alpine.listener.Subscriber;

public abstract class Module extends Command implements Subscriber {

    private final ModuleCategory moduleCategory;

    private int keyBind;

    private boolean enabled;

    public Module(final String name, final String description, final ModuleCategory moduleCategory) {
        super(name, description);

        this.moduleCategory = moduleCategory;
    }

    public ModuleCategory getModuleCategory() {
        return moduleCategory;
    }

    public int getKeyBind() {
        return keyBind;
    }

    public void setKeyBind(int keyBind) {
        this.keyBind = keyBind;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void toggle(final boolean state) {
        this.enabled = state;

        if (state) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void onEnable() {
        Client.getEventBus().subscribe(this);
    }

    public void onDisable() {
        Client.getEventBus().unsubscribe(this);
    }

    @Override
    public void execute(String[] args) {
        this.toggle(!this.enabled);
    }
}
