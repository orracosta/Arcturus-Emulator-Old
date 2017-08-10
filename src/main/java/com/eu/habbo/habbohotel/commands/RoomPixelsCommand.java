package com.eu.habbo.habbohotel.commands;

import com.eu.habbo.Emulator;
import com.eu.habbo.habbohotel.gameclients.GameClient;
import com.eu.habbo.habbohotel.rooms.RoomChatMessage;
import com.eu.habbo.habbohotel.rooms.RoomChatMessageBubbles;
import com.eu.habbo.habbohotel.users.Habbo;
import com.eu.habbo.messages.outgoing.rooms.users.RoomUserWhisperComposer;
import gnu.trove.procedure.TObjectProcedure;

public class RoomPixelsCommand extends Command
{
    public RoomPixelsCommand()
    {
        super("cmd_roompixels", Emulator.getTexts().getValue("commands.keys.cmd_roompixels").split(";"));
    }

    @Override
    public boolean handle(GameClient gameClient, String[] params) throws Exception
    {
        if(params.length == 2)
        {
            int amount;

            try
            {
                amount = Integer.valueOf(params[1]);
            }
            catch (Exception e)
            {
                gameClient.sendResponse(new RoomUserWhisperComposer(new RoomChatMessage(Emulator.getTexts().getValue("commands.error.cmd_massduckets.invalid_amount"), gameClient.getHabbo(), gameClient.getHabbo(), RoomChatMessageBubbles.ALERT)));
                return true;
            }

            if(amount != 0)
            {
                final String message = Emulator.getTexts().getValue("commands.generic.cmd_duckets.received").replace("%amount%", amount + "");
                final int finalAmount = amount;
                for (Habbo habbo : gameClient.getHabbo().getHabboInfo().getCurrentRoom().getHabbos())
                {
                    habbo.givePixels(finalAmount);
                    habbo.getClient().sendResponse(new RoomUserWhisperComposer(new RoomChatMessage(message, habbo, habbo, RoomChatMessageBubbles.ALERT)));
                }
            }
            return true;
        }
        gameClient.sendResponse(new RoomUserWhisperComposer(new RoomChatMessage(Emulator.getTexts().getValue("commands.error.cmd_massduckets.invalid_amount"), gameClient.getHabbo(), gameClient.getHabbo(), RoomChatMessageBubbles.ALERT)));
        return true;
    }
}