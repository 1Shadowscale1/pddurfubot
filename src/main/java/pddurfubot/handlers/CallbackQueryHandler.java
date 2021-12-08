package pddurfubot.handlers;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import pddurfubot.cache.UserDataCache;

public class CallbackQueryHandler {
    public static SendMessage ProcessCallback(CallbackQuery callbackQuery){
        Long chatId = callbackQuery.getMessage().getChatId();

        if (UserDataCache.getUsersCurrentBotState(chatId) == BotState.QUESTION_EXAM){
            UserDataCache.getUsersExaminer(chatId).setAnswer(callbackQuery.getData());
        }

        if (UserDataCache.getUsersCurrentBotState(chatId) == BotState.START_EXAM){
            UserDataCache.setNewUserExaminer(chatId, Integer.parseInt(callbackQuery.getData()));
            UserDataCache.setUsersCurrentBotState(chatId,BotState.QUESTION_EXAM);
        }
        
        return MessageBuild.BuildOutputMessage(UserDataCache.getUsersCurrentBotState(chatId),
                callbackQuery.getMessage(),
                chatId);
    }
}
