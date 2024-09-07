package io.github.qe7.events.packet;

import me.zero.alpine.event.CancellableEvent;
import net.minecraft.src.Packet;

public class OutgoingPacketEvent extends CancellableEvent {

    private final Packet packet;

    public OutgoingPacketEvent(Packet packet) {
        this.packet = packet;
    }

    public Packet getPacket() {
        return packet;
    }
}
