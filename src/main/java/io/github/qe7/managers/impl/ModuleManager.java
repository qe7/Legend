package io.github.qe7.managers.impl;

import io.github.qe7.Client;
import io.github.qe7.events.KeyInputEvent;
import io.github.qe7.features.impl.modules.api.Module;
import io.github.qe7.features.impl.modules.impl.TestModule;
import io.github.qe7.managers.api.Manager;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.Subscribe;
import me.zero.alpine.listener.Subscriber;

import java.util.ArrayList;
import java.util.List;

public final class ModuleManager extends Manager<Class<? extends Module>, Module> implements Subscriber {

    private final List<Module> moduleList = new ArrayList<>();

    public ModuleManager() {

    }

    public void initialize() {
        this.moduleList.add(new TestModule());

        for (Module module : this.moduleList) {
            this.register(module);
        }

        Client.getEventBus().subscribe(this);
    }

    public void register(final Module module) {
        this.registry.put(module.getClass(), module);
    }

    @Subscribe
    public final Listener<KeyInputEvent> keyInputEventListener = new Listener<>(event -> {
        for (Module module : this.registry.values()) {
            if (module.getKeyBind() == event.getKeyCode()) {
                module.toggle(!module.isEnabled());
            }
        }
    });
}
