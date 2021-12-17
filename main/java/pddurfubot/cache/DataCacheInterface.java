package pddurfubot.cache;

import pddurfubot.handlers.BotState;

public interface DataCacheInterface {
    void setUsersCurrentBotState(Long userId, BotState botState);

    BotState getUsersCurrentBotState(Long userId);
}
