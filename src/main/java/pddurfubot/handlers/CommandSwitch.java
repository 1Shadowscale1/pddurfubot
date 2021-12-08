package pddurfubot.handlers;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import pddurfubot.cache.UserDataCache;

public class CommandSwitch {

    public static SendMessage ProcessCommands (Message message) {
        Long chatId = message.getChatId();
        BotState botState = UserDataCache.getUsersCurrentBotState(chatId);

        if (botState == BotState.START_EXAM | botState == BotState.QUESTION_EXAM)
            botState = SwitchExam.SwitchExamCommands(message);
        else
            botState = SwitchBasic.SwitchBasicCommands(message);

        UserDataCache.setUsersCurrentBotState(chatId, botState);
        return MessageBuild.BuildOutputMessage(botState, message, chatId);
    }
}
