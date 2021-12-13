package pddurfubot.handlers;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import pddurfubot.cache.UserDataCache;
import pddurfubot.exam.MarkupBuilder;
import pddurfubot.weatherAPI.LocationKeyboard;

public class MessageBuild {
    public static SendMessage BuildOutputMessage(BotState botState, Message message, Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(botState.command.exec(message.getText().split(" ") , chatId));

        if (UserDataCache.getUsersCurrentBotState(chatId) == BotState.QUESTION_EXAM){
            InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
            inlineKeyboardMarkup
                    .setKeyboard(MarkupBuilder.getQuestionMarkup(
                            UserDataCache.getUsersExaminer(chatId).getNextQuestion()));
            sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        }

        if (UserDataCache.getUsersCurrentBotState(chatId) == BotState.START_EXAM){
            InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
            inlineKeyboardMarkup.setKeyboard(MarkupBuilder.getExamMarkup());
            sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        }

        if (UserDataCache.getUsersCurrentBotState(chatId) == BotState.ASK_WEATHER){
            sendMessage.setReplyMarkup(LocationKeyboard.Build());
        }
        return sendMessage;
    }
}
