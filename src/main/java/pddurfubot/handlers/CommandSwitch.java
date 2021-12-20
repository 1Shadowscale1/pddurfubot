package pddurfubot.handlers;

import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import pddurfubot.cache.UserDataCache;
import pddurfubot.exam.AnsweredExamQuestion;
import pddurfubot.exam.Examiner;

import java.io.IOException;

public class CommandSwitch {

    public static void ProcessCommands (Message message) {
        Long chatId = message.getChatId();

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
        Message message = callbackQuery.getMessage();
        Long chatId = message.getChatId();
        String data = callbackQuery.getData();
        if (String.valueOf(data.charAt(0)).equals("q")){
            UserDataCache.setUsersCurrentBotState(chatId,BotState.QUESTION_EXAM);
            Examiner userExaminer = UserDataCache.getUsersExaminer(chatId);

            userExaminer.getAnsweredExamQuestions()
                    .add(new AnsweredExamQuestion(userExaminer.getNextQuestion(),data.substring(1)));

            userExaminer.setAnswer(callbackQuery.getData());
            if (UserDataCache.getUsersExaminer(chatId).getNextQuestion() == null){
                UserDataCache.setUsersCurrentBotState(chatId,BotState.END_EXAM);
            }
        }
        else if (data.equals("result")){
            UserDataCache.setUsersCurrentBotState(chatId,BotState.SEND_TEST_STAT);
        }
        else{
            UserDataCache.setNewUserExaminer(chatId, Integer.parseInt(callbackQuery.getData()));
            UserDataCache.setUsersCurrentBotState(chatId,BotState.QUESTION_EXAM);
        }

        UserDataCache.setUserUsedMessage(chatId,message.getMessageId());
    }
}
