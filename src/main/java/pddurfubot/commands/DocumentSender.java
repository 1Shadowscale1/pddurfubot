package pddurfubot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.IOException;

public abstract class DocumentSender {
    public SendDocument getSpecialMessage(Message receivedMessage) throws IOException {
        return null;
    }
}
