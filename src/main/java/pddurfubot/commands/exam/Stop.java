package pddurfubot.commands.exam;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import pddurfubot.cache.UserDataCache;
import pddurfubot.commands.CommandInterface;
import pddurfubot.commands.PhotoSender;
import pddurfubot.exam.Examiner;
import pddurfubot.handlers.BotState;

import java.io.File;
import java.io.IOException;

public class Stop implements CommandInterface {

    @Override
    public String getDescription() {
        return "Принудительная остановка тестирования пользователя";
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
        Long chatId = receivedMessage.getChatId();
        Examiner examiner = UserDataCache.getUsersExaminer(chatId);
        int result = examiner.getExamResults();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());

        String messageText = "";
        if(result < examiner.getQuestionAmount()){
            messageText += "Тест не пройден\n";
        }
        else {
           messageText += "Тест пройден\n";
        }
        messageText += result + " из "+examiner.getQuestionAmount()+"\n";
        messageText += examiner.getWrongAnswers();
        messageText += "/getstats";
        sendMessage.setText(messageText);
        return sendMessage;
    }

    public SendPhoto getSpecialMessage(Message receivedMessage) throws IOException {
        Long chatId = receivedMessage.getChatId();
        Examiner examiner = UserDataCache.getUsersExaminer(chatId);
        int result = examiner.getExamResults();
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId.toString());
        sendPhoto.setCaption(result + " из "+examiner.getQuestionAmount()+"\n"+"Правильные ответы"+"\n");
        if(result < examiner.getQuestionAmount()){
            sendPhoto.setPhoto(new InputFile(new File("src\\main\\resources\\examfailed.jpg")));
        }
        else {
            sendPhoto.setPhoto(new InputFile(new File("src\\main\\resources\\examend.jpg")));
        }

        return sendPhoto;
    }
}
