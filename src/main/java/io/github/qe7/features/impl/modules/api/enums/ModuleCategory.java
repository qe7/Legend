package io.github.qe7.features.impl.modules.api.enums;

public enum ModuleCategory {
    COMBAT("Combat"),
    MOVEMENT("Movement"),
    MISC("Misc"),
    RENDER("Render");

    private final String name;

    ModuleCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
