package pddurfubot.commands.basic;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import pddurfubot.commands.CommandInterface;
import pddurfubot.handlers.BotState;

import java.util.List;

public class Help implements CommandInterface {

    @Override
    public String getDescription() {
        return "Возвращает справку по боту";
    }

    @Override
    public String getName() {
        return "/" + this.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public String exec(String[] args) {

        return  "/help - возвращает это сообщение\n" +
                "/about - возвращает информацию о разработчиках бота\n" +
                "/examstart - начинает тест ПДД \n" +
                "/examstop - принудительно завершает тест ПДД, начатый пользователем";
    }

    @Override
    public SendMessage getMessage(Message receivedMessage) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(receivedMessage.getChatId().toString());
        sendMessage.setText(BotState.ANSWER_HELP.command.exec(new String[]{}));
        return sendMessage;
    }
}