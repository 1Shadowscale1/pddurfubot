package pddurfubot.handlers;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import pddurfubot.cache.UserDataCache;

public class CommandSwitch {
    public static SendMessage ProcessCommands (Message message) {
        UserDataCache userDataCache = new UserDataCache();
        int userId = Math.toIntExact(message.getFrom().getId());
        BotState botState = userDataCache.getUsersCurrentBotState(userId);

        if (botState == BotState.START_EXAM | botState == BotState.QUESTION_EXAM)
            botState = SwitchExam.SwitchExamCommands(botState, message);
        else
            botState = SwitchBasic.SwitchBasicCommands(botState, message);

        userDataCache.setUsersCurrentBotState(userId, botState);
        return CommandBuild.BuildOutputMessage(botState, message, userId);
    }
}
