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

        UserDataCache.setUsersCurrentBotState(chatId,BotState.ANSWER_HELP);

        if (message.hasText()){
            SwitchExam.SwitchExamCommands(message);
            SwitchBasic.SwitchBasicCommands(message);
        }

        if (message.hasLocation()){
            UserDataCache.setUsersCurrentBotState(chatId,BotState.SEND_WEATHER);
        }

    }

    public static void ProcessCallback(CallbackQuery callbackQuery) throws IOException {
        Long chatId = callbackQuery.getMessage().getChatId();

        if (UserDataCache.getUsersCurrentBotState(chatId) == BotState.QUESTION_EXAM){
            UserDataCache.getUsersExaminer(chatId).setAnswer(callbackQuery.getData());
            if (UserDataCache.getUsersExaminer(chatId).getNextQuestion() == null){
                UserDataCache.setUsersCurrentBotState(chatId,BotState.END_EXAM);
            }
        }

        else if (UserDataCache.getUsersCurrentBotState(chatId) == BotState.START_EXAM){
            UserDataCache.setNewUserExaminer(chatId, Integer.parseInt(callbackQuery.getData()));
            UserDataCache.setUsersCurrentBotState(chatId,BotState.QUESTION_EXAM);
        }

        else if (UserDataCache.getUsersExaminer(chatId).isExamFinished()){
            UserDataCache.setUsersCurrentBotState(chatId,BotState.START_EXAM);
        }
        else {UserDataCache.setUsersCurrentBotState(chatId,BotState.QUESTION_EXAM);}
    }
}
