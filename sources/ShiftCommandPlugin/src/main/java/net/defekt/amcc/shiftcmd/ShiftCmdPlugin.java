package net.defekt.amcc.shiftcmd;

import java.io.IOException;

import net.defekt.mc.chatclient.api.AMCPlugin;
import net.defekt.mc.chatclient.protocol.data.ChatMessages;
import net.defekt.mc.chatclient.protocol.packets.general.clientbound.play.ServerChatMessagePacket.Position;

public class ShiftCmdPlugin extends AMCPlugin {

    private static final String PREFIX = "&#007bfbS&#1c6df8h&#3860f4i&#5452f1f&#7044edt&#8d37eaC&#a929e6m&#c51be3d &#e10edf>&#fd00dc> ";

    @Override
    public void onLoaded() {
        registerCommand("sneak", (cmd, args, client) -> {
            try {
                client.toggleSneaking();
                boolean sneak = client.isSneaking();
                client.receiveMessage(ChatMessages.translateColorCodes('&',
                        PREFIX + (sneak ? "&aNow sneaking!" : "&cStopped sneaking")), Position.CHAT);
            } catch (IOException e) {
                client.receiveMessage(
                        ChatMessages.translateColorCodes('&',
                                PREFIX + "&cThere was an exception while toggline sneaking: " + e.toString()),
                        Position.CHAT);
            }

        });
    }

}
