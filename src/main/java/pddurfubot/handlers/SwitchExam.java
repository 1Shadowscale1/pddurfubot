package pddurfubot.handlers;

import org.telegram.telegrambots.meta.api.objects.Message;
import pddurfubot.cache.UserDataCache;

public class SwitchExam {
    public static BotState SwitchExamCommands(BotState botState, Message message) {
        String inputCmd = message.getText().split(" ")[0];
        UserDataCache userDataCache = new UserDataCache();
        Long userId = message.getFrom().getId();

        switch(inputCmd) {
            case "answer":
                botState = BotState.QUESTION_EXAM;
                break;
            case "/examStop":
                botState = BotState.END_EXAM;
                break;
            default:
                botState = userDataCache.getUsersCurrentBotState(userId);
                break;
        }
        return botState;
    }
}
