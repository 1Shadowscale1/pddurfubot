package pddurfubot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import pddurfubot.cache.UserDataCache;
import pddurfubot.commands.PhotoSender;
import pddurfubot.handlers.BotState;
import pddurfubot.handlers.CommandSwitch;

import java.io.IOException;

public class Bot extends TelegramLongPollingBot{

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            Message message = update.getMessage();
            try {
				CommandSwitch.ProcessCommands(message);
				BotState botState = UserDataCache.getUsersCurrentBotState(message.getChatId());
				if (botState.command instanceof PhotoSender){
					execute(((PhotoSender) botState.command).getSpecialMessage(message));
				}
				else {
                execute(botState.command.getMessage(message));
				}

            } catch (TelegramApiException | IOException e) {
                e.printStackTrace();
            }
        }
		if (update.hasCallbackQuery()){
			CallbackQuery callbackQuery = update.getCallbackQuery();
			Message message = callbackQuery.getMessage();
			if (!UserDataCache.getUserUsedMessages(message.getChatId()).contains(message.getMessageId())){
				try {
					CommandSwitch.ProcessCallback(callbackQuery);
					BotState botState = UserDataCache.getUsersCurrentBotState(message.getChatId());
					if (botState.command instanceof PhotoSender){
						execute(((PhotoSender) botState.command).getSpecialMessage(message));
					}
					else {
						execute(botState.command.getMessage(message));
					}
				} catch (TelegramApiException | IOException e) {
					e.printStackTrace();
				}
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
		return System.getenv("BOT_TOKEN");
                //Токен бота
	}
}
