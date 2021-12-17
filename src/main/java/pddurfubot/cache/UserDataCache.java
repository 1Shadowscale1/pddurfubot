package pddurfubot.cache;

import pddurfubot.exam.Examiner;
import pddurfubot.handlers.BotState;
import java.util.Map;
import java.util.HashMap;

public class UserDataCache {
    private static Map<Long, BotState> userBotStates = new HashMap<>();
    private static Map<Long, Examiner> userExamStates = new HashMap<>();


    public static void setUsersCurrentBotState(Long chatId, BotState botState) {
        userBotStates.put(chatId, botState);
    }

    public static BotState getUsersCurrentBotState(Long chatId) {
        BotState botState = userBotStates.get(chatId);
        if (botState == null) {
            botState = BotState.ANSWER_HELP;
        }
        return botState;
    }

    public static Examiner getUsersExaminer(Long chatId){
        Examiner examiner = userExamStates.get(chatId);
        if (examiner == null){
            examiner = new Examiner(1);
        }
        return examiner;
    }

    public static void setNewUserExaminer(Long chatId, Integer variant){
        userExamStates.put(chatId, new Examiner(variant));
    }
}
