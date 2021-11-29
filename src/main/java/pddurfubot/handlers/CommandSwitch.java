package pddurfubot.handlers;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import pddurfubot.cache.UserDataCache;

public class CommandSwitch {
    public static UserDataCache userDataCache = new UserDataCache();
    public static SendMessage ProcessCommands (Message message) {
        Long userId = message.getFrom().getId();
        BotState botState = userDataCache.getUsersCurrentBotState(userId);

        if (botState == BotState.START_EXAM | botState == BotState.QUESTION_EXAM)
            botState = SwitchExam.SwitchExamCommands(botState, message);
        else
            botState = SwitchBasic.SwitchBasicCommands(botState, message);

        userDataCache.setUsersCurrentBotState(userId, botState);
        return CommandBuild.BuildOutputMessage(botState, message, userId);
    }
}
