package pddurfubot.handlers;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class CommandBuild {
    public static SendMessage BuildOutputMessage(BotState botState, Message message, Long userId) {
        return (
                SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text(botState.command.exec(message.getText().split(" "), userId))
                .build());
    }
}
