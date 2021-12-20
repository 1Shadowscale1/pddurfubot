package pddurfubot.commands.exam;

import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import pddurfubot.cache.UserDataCache;
import pddurfubot.commands.CommandInterface;
import pddurfubot.commands.DocumentSender;
import pddurfubot.exam.Examiner;
import pddurfubot.exam.FormHtmlStats;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

public class SendTestStat extends DocumentSender implements CommandInterface {

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String exec(String[] args) {
        return null;
    }

    @Override
    public SendMessage getMessage(Message receivedMessage) throws MalformedURLException {
        return null;
    }

    @Override
    public SendDocument getSpecialMessage(Message receivedMessage) throws IOException {
        Examiner userExaminer = UserDataCache.getUsersExaminer(receivedMessage.getChatId());
        Integer variant = userExaminer.getAnsweredExamQuestions().get(0).getExamVariant();
        Date date = new Date((long) receivedMessage.getDate()*1000);

        SendDocument sendDocument = new SendDocument();
        sendDocument.setChatId(receivedMessage.getChatId().toString());
        sendDocument.setDocument(new InputFile(FormHtmlStats.FormHtml(
                receivedMessage.getChatId().toString(),
                date.toString(),
                variant,
                userExaminer.getExamResults(),
                userExaminer.getAnsweredExamQuestions())));
        return sendDocument;
    }
}
