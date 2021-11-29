package pddurfubot.handlers;

import org.telegram.telegrambots.meta.api.objects.Message;
import pddurfubot.cache.UserDataCache;

public class SwitchBasic {
    public static BotState SwitchBasicCommands(BotState botState, Message message) {
        String[] msgText = message.getText().split(" ");
        String inputCmd = msgText[0];
        UserDataCache userDataCache = new UserDataCache();
        Long userId = message.getFrom().getId();

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
                botState = userDataCache.getUsersCurrentBotState(userId);
                break;
        }

        return botState;
    }
}
