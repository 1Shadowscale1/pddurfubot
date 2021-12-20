package pddurfubot.handlers;

import org.telegram.telegrambots.meta.api.objects.Message;
import pddurfubot.cache.UserDataCache;

public class SwitchBasic {
    public static void SwitchBasicCommands(Message message) {
        String[] msgText = message.getText().split(" ");
        String inputCmd = msgText[0];
        Long chatId = message.getChatId();

        BotState botState;
        switch (inputCmd.toLowerCase()) {
            case "/start":
                botState = BotState.ANSWER_START;
                break;
            case "/about":
                botState = BotState.ANSWER_ABOUT;
                break;
            case "/examstart":
                botState = BotState.START_EXAM;
                break;
            case "/help":
                botState = BotState.ANSWER_HELP;
                break;
            default:
                botState = UserDataCache.getUsersCurrentBotState(chatId);
                break;
        }
        UserDataCache.setUsersCurrentBotState(chatId,botState);
    }
}
