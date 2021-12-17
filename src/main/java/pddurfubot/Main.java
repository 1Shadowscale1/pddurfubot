package pddurfubot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import pddurfubot.db.DataBase;
import pddurfubot.exam.Examiner;

import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws TelegramApiException, URISyntaxException {
        DataBase.initialise();
        DataBase.openSession();
        new Examiner(1);
        Bot bot = new Bot();
        TelegramBotsApi botapi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            botapi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
