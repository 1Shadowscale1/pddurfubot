package pddurfubot.cache;

import pddurfubot.exam.Examiner;
import pddurfubot.handlers.BotState;
import java.util.Map;
import java.util.HashMap;

public class UserDataCache {
    private static Map<Long, BotState> userBotStates = new HashMap<>();
    private static Map<Long, Examiner> userExamStates = new HashMap<>();


    public static void setUsersCurrentBotState(Long userId, BotState botState) {
        userBotStates.put(userId, botState);
    }

    public static BotState getUsersCurrentBotState(Long userId) {
        BotState botState = userBotStates.get(userId);
        if (botState == null) {
            botState = BotState.ANSWER_HELP;
        }
        return botState;
    }

    public static Examiner getUsersExaminer(Long userId){
        Examiner examiner = userExamStates.get(userId);
        if (examiner == null){
            examiner = new Examiner(1);
        }
        return examiner;
    }

    public static void setNewUserExaminer(Long userId, Integer variant){
        userExamStates.put(userId, new Examiner(variant));
    }
}
