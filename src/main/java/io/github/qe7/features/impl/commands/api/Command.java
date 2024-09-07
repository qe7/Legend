package io.github.qe7.features.impl.commands.api;

import io.github.qe7.features.api.Feature;

import java.util.ArrayList;
import java.util.List;

public abstract class Command extends Feature {

    private final List<String> aliases = new ArrayList<>();

    public Command(final String name, final String description) {
        super(name, description);
    }

    public List<String> getAliases() {
        return aliases;
    }

    public abstract void execute(final String[] args);
}
