package pddurfubot.handlers;

import org.telegram.telegrambots.meta.api.objects.Message;
import pddurfubot.cache.UserDataCache;

import java.util.Locale;

public class SwitchBasic {
    public static void SwitchBasicCommands(Message message) {
        String[] msgText = message.getText().split(" ");
        String inputCmd = msgText[0];
        Long chatId = message.getChatId();

        BotState botState;
        switch (inputCmd.toLowerCase()) {
            case "/about":
                botState = BotState.ANSWER_ABOUT;
                break;
            case "/examstart":
                botState = BotState.START_EXAM;
                break;
            case "/askWeather":
                botState = BotState.ASK_WEATHER;
                break;
            case "/help":
            default:
                botState = BotState.ANSWER_HELP;
                break;
        }
        UserDataCache.setUsersCurrentBotState(chatId,botState);
    }
}
