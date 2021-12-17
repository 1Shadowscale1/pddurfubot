package pddurfubot.cache;

import org.hibernate.hql.internal.ast.tree.IdentNode;
import pddurfubot.exam.Examiner;
import pddurfubot.handlers.BotState;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class UserDataCache {
    private static Map<Long, BotState> userBotStates = new HashMap<>();
    private static Map<Long, Examiner> userExamStates = new HashMap<>();
    private static Map<Long, HashSet<Integer>> userUsedMessages = new HashMap<Long, HashSet<Integer>>();

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

    public static HashSet<Integer> getUserUsedMessages(Long chatId) {
        if (userUsedMessages.get(chatId) == null){
            userUsedMessages.put(chatId,new HashSet<>());
        }
        return userUsedMessages.get(chatId);
    }

    public static void setUserUsedMessage(Long chatId, Integer messageId){
        userUsedMessages.get(chatId).add(messageId);
    }
}
