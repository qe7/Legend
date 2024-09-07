package io.github.qe7.events;

import net.minecraft.src.ScaledResolution;

public class RenderScreenEvent {

    private final ScaledResolution scaledResolution;

    public RenderScreenEvent(ScaledResolution scaledResolution) {
        this.scaledResolution = scaledResolution;
    }

    public ScaledResolution getScaledResolution() {
        return scaledResolution;
    }
}
