package pddurfubot.cache;

import pddurfubot.handlers.BotState;

public interface DataCacheInterface {
    void setUsersCurrentBotState(int userId, BotState botState);

    BotState getUsersCurrentBotState(int userId);
}
