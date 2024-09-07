package io.github.qe7.managers.impl;

import io.github.qe7.Client;
import io.github.qe7.events.ChatMessageEvent;
import io.github.qe7.features.impl.commands.api.Command;
import io.github.qe7.features.impl.commands.impl.TestCommand;
import io.github.qe7.managers.api.Manager;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.listener.Subscribe;
import me.zero.alpine.listener.Subscriber;

import java.util.ArrayList;
import java.util.List;

public final class CommandManager extends Manager<Class<? extends Command>, Command> implements Subscriber {

    private final List<Command> commandList = new ArrayList<>();

    public CommandManager() {

    }

    public void initialize() {
        this.commandList.add(new TestCommand());

        Client.getInstance().getModuleManager().registry.values().forEach(this::register);

        for (Command command : this.commandList) {
            this.register(command);
        }

        Client.getEventBus().subscribe(this);
    }

    public void register(final Command command) {
        this.registry.put(command.getClass(), command);
    }

    @Subscribe
    public final Listener<ChatMessageEvent> chatMessageEventListener = new Listener<>(event -> {
        final String message = event.getMessage();
        if (message.startsWith(Client.getInstance().getPrefix())) {
            final String[] args = message.substring(Client.getInstance().getPrefix().length()).split(" ");

            Command command = null;

            for (Command c : this.registry.values()) {
                if (c.getName().equalsIgnoreCase(args[0])) {
                    command = c;
                    break;
                }
            }

            if (command != null) {
                command.execute(args);
            }

            event.setCancelled(true);
        }
    });
}
