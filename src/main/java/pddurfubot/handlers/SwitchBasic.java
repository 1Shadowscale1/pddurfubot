package pddurfubot.handlers;

import org.telegram.telegrambots.meta.api.objects.Message;
import pddurfubot.cache.UserDataCache;

public class SwitchBasic {
    public static void SwitchBasicCommands(Message message) {
        String[] msgText = message.getText().split(" ");
        String inputCmd = msgText[0];
        Long chatId = message.getChatId();

        BotState botState;
        switch (inputCmd) {
            case "/help":
                botState = BotState.ANSWER_HELP;
                break;
            case "/about":
                botState = BotState.ANSWER_ABOUT;
                break;
            case "/examStart":
                botState = BotState.START_EXAM;
                break;
            default:
                botState = BotState.ANSWER_HELP;
                break;
        }
        UserDataCache.setUsersCurrentBotState(chatId,botState);
    }
}
