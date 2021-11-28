package pddurfubot.cache;

import pddurfubot.handlers.BotState;
import java.util.Map;
import java.util.HashMap;

public class UserDataCache implements DataCacheInterface {
    private Map<Integer, BotState> userBotStates = new HashMap<>();

    @Override
    public void setUsersCurrentBotState(int userId, BotState botState) {
        userBotStates.put(userId, botState);
    }

    @Override
    public BotState getUsersCurrentBotState(int userId) {
        BotState botState = userBotStates.get(userId);
        if (botState == null) {
            botState = BotState.ANSWER_HELP;
        }

        return botState;
    }
}
