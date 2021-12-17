package pddurfubot.commands.basic;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import pddurfubot.commands.CommandInterface;
import pddurfubot.handlers.BotState;

import java.util.List;

public class Wrong implements CommandInterface {

    @Override
    public String getDescription() {
        return "Если пользователь ввел неверную команду";
    }

    @Override
    public String getName() {
        return "/" + this.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public String exec(String[] args) { return "Неверная команда"; }

    @Override
    public SendMessage getMessage(Message receivedMessage) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(receivedMessage.getChatId().toString());
        sendMessage.setText(BotState.ANSWER_ABOUT.command.exec(new String[]{}));
        return sendMessage;
    }
}