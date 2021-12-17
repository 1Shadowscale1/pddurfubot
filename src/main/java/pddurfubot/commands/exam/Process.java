package pddurfubot.commands.exam;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import pddurfubot.cache.UserDataCache;
import pddurfubot.commands.CommandInterface;
import pddurfubot.commands.PhotoSender;
import pddurfubot.exam.ExamQuestion;
import pddurfubot.exam.MarkupBuilder;
import pddurfubot.handlers.BotState;

import java.io.File;
import java.io.IOException;

public class Process extends PhotoSender implements CommandInterface {

    @Override
    public String getDescription() {
        return "выдает вопрос экзамена и обрабатывает ответ, вызывает следующий или заканчивает экзамен";
    }

    @Override
    public String getName() {
        return "/" + this.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public String exec(String[] args) {
        return "";
    }

    @Override
    public SendMessage getMessage(Message receivedMessage) {
        return null;
    }

    @Override
    public SendPhoto getSpecialMessage(Message receivedMessage) throws IOException {
        SendPhoto sendPhoto = new SendPhoto();
        Long chatId = receivedMessage.getChatId();
        ExamQuestion examQuestion = UserDataCache.getUsersExaminer(chatId).getNextQuestion();

        sendPhoto.setChatId(chatId.toString());
        sendPhoto.setCaption(examQuestion.getQuestionNumber()+". "+examQuestion.getQuestionText());

        File file = UserDataCache.getUsersExaminer(chatId).getNextQuestion().getImageFile();
        sendPhoto.setPhoto(new InputFile(file,examQuestion.getId().toString()));

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(MarkupBuilder.getQuestionMarkup(UserDataCache
                .getUsersExaminer(chatId)
                .getNextQuestion()));
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);

        return sendPhoto;
    }

}
