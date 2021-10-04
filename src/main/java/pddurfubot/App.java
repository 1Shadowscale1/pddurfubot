package pddurfubot;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.meta.generics.Webhook;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class App extends TelegramLongPollingBot{
    public static void main(String[] args) throws TelegramApiException {
		TelegramBotsApi botapi = new TelegramBotsApi(DefaultBotSession.class);
		try {
			botapi.registerBot(null);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void clearWebhook() throws TelegramApiRequestException {
		super.clearWebhook();
	}

	@Override
	public String getBotUsername() {
		return "USER";
                //возвращаем юзера
	}

	@Override
	public void onUpdateReceived(Update e) {
		Message msg = e.getMessage(); // Это нам понадобится
		String txt = msg.getText();
		if (txt.equals("/start")) {
			sendMsg(msg, "Hello, world! This is simple bot!"); 
		}
	}

	@Override
	public String getBotToken() {
		return "YOUR_BOT_TOKEN";
                //Токен бота
	}

	private static void sendMsg(Message msg, String text) {
		Message l = null; 
		SendMessage s = new SendMessage();
		s.setText(text);
		sendMsg(l, "123");
	}
}
