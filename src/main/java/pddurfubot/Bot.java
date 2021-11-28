package pddurfubot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import pddurfubot.handlers.CommandSwitch;

public class Bot extends TelegramLongPollingBot{

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            Message message = update.getMessage();
            try {
                execute(CommandSwitch.ProcessCommands(message));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

	@Override
	public void clearWebhook() throws TelegramApiRequestException {
		super.clearWebhook();
	}

	@Override
	public String getBotUsername() {
		return "@PapaPrivetBot";
                //возвращаем юзера
	}

	@Override
	public String getBotToken() {
		return "2090479806:AAF0tgtYIEm-4KI8bt7EOB4ELOKGoaGfNxQ";
                //Токен бота
	}
}
