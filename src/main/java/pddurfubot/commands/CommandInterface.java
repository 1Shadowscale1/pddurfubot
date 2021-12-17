package pddurfubot.commands;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.ForwardMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.net.MalformedURLException;
import java.util.List;

public interface CommandInterface {

    String getDescription();

    String getName();

    String exec(String[] args);

    SendMessage getMessage(Message receivedMessage) throws MalformedURLException;
}