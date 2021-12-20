package pddurfubot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import java.net.MalformedURLException;

public interface CommandInterface {

    String getDescription();

    String getName();

    String exec(String[] args);

    SendMessage getMessage(Message receivedMessage) throws MalformedURLException;
}