package pddurfubot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import pddurfubot.db.DataBase;

public class Main {


    public static void main(String[] args) throws TelegramApiException {
        DataBase.initialise();
        DataBase.openSession();
        Bot bot = new Bot();
        TelegramBotsApi botapi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            botapi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
