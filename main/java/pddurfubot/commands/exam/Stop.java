package pddurfubot.commands.exam;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import pddurfubot.cache.UserDataCache;
import pddurfubot.commands.CommandInterface;
import pddurfubot.commands.PhotoSender;
import pddurfubot.handlers.BotState;

import java.io.File;
import java.io.IOException;

public class Stop extends PhotoSender implements CommandInterface {

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
        return null;
    }

    @Override
    public SendPhoto getSpecialMessage(Message receivedMessage) throws IOException {
        Long chatId = receivedMessage.getChatId();
        int result = UserDataCache.getUsersExaminer(chatId).getExamResults();
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId.toString());
        sendPhoto.setCaption(result + " из 20");
        if(result < 20){
            sendPhoto.setPhoto(new InputFile(new File("src\\main\\resources\\examfailed.jpg")));
        }
        else {
            sendPhoto.setPhoto(new InputFile(new File("src\\main\\resources\\examend.jpg")));
        }

        return sendPhoto;
    }
}
