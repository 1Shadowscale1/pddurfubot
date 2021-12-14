package pddurfubot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.IOException;

public abstract class PhotoSender {
    public SendPhoto getSpecialMessage(Message receivedMessage) throws IOException {
        return null;
    }
}
