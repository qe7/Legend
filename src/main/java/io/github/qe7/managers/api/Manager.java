package io.github.qe7.managers.api;

import java.util.HashMap;

public abstract class Manager<T, V> {

    public final HashMap<T, V> registry = new HashMap<>();
}
