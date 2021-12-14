package pddurfubot.handlers;

import org.telegram.telegrambots.meta.api.objects.Message;
import pddurfubot.cache.UserDataCache;

public class SwitchExam {
    public static void SwitchExamCommands(Message message) {
        BotState botState;
        String inputCmd = message.getText().split(" ")[0];
        Long chatId = message.getChatId();

        switch(inputCmd) {
            case "/examStop":
                botState = BotState.END_EXAM;
                break;
            default:
                botState = UserDataCache.getUsersCurrentBotState(chatId);
                break;
        }
        UserDataCache.setUsersCurrentBotState(chatId,botState);
    }
}
