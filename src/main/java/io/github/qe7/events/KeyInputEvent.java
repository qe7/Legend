package io.github.qe7.events;

public class KeyInputEvent {

    private final int keyCode;

    public KeyInputEvent(int keyCode) {
        this.keyCode = keyCode;
    }

    public int getKeyCode() {
        return keyCode;
    }
}
