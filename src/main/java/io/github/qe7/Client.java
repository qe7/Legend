package io.github.qe7;

import io.github.qe7.managers.impl.CommandManager;
import io.github.qe7.managers.impl.ModuleManager;
import me.zero.alpine.bus.EventBus;
import me.zero.alpine.bus.EventManager;
import net.minecraft.client.Minecraft;

public final class Client {

    private static final Client instance = new Client();

    private static final EventBus eventBus = EventManager.builder().setName("Client").build();

    private final String name, prefix;

    private final ModuleManager moduleManager = new ModuleManager();
    private final CommandManager commandManager = new CommandManager();

    private Client() {
        this.name = "Shliff"; // REAL
        this.prefix = ".";
    }

    public void start() {
        System.out.println("Starting " + name + "...");

        this.moduleManager.initialize();
        this.commandManager.initialize();

        Minecraft.theMinecraft.session.username = "Shliff"; // REAL
    }

    public static Client getInstance() {
        return instance;
    }

    public static EventBus getEventBus() {
        return eventBus;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }
}
