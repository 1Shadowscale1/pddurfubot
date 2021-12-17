package pddurfubot.handlers;

import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import pddurfubot.cache.UserDataCache;

import java.io.IOException;

public class CommandSwitch {

    public static void ProcessCommands (Message message) {
        Long chatId = message.getChatId();
        BotState botState = UserDataCache.getUsersCurrentBotState(chatId);

        if (UserDataCache.getUsersCurrentBotState(chatId) == BotState.END_EXAM){
            UserDataCache.setUsersCurrentBotState(chatId,BotState.ANSWER_HELP);
        }

        if (botState == BotState.START_EXAM | botState == BotState.QUESTION_EXAM)
            SwitchExam.SwitchExamCommands(message);
        else
            SwitchBasic.SwitchBasicCommands(message);
    }

    public static void ProcessCallback(CallbackQuery callbackQuery) throws IOException {
        Long chatId = callbackQuery.getMessage().getChatId();

        if (UserDataCache.getUsersCurrentBotState(chatId) == BotState.QUESTION_EXAM){
            UserDataCache.getUsersExaminer(chatId).setAnswer(callbackQuery.getData());
            if (UserDataCache.getUsersExaminer(chatId).getNextQuestion() == null){
                UserDataCache.setUsersCurrentBotState(chatId,BotState.END_EXAM);
            }
        }

        if (UserDataCache.getUsersCurrentBotState(chatId) == BotState.START_EXAM){
            UserDataCache.setNewUserExaminer(chatId, Integer.parseInt(callbackQuery.getData()));
            UserDataCache.setUsersCurrentBotState(chatId,BotState.QUESTION_EXAM);
        }
    }
}
