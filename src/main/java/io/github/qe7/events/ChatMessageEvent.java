package io.github.qe7.events;

import me.zero.alpine.event.CancellableEvent;

public class ChatMessageEvent extends CancellableEvent {

    private final String message;

    public ChatMessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
