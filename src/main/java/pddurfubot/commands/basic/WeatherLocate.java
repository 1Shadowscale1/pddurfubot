package pddurfubot.commands.basic;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import pddurfubot.commands.CommandInterface;
import pddurfubot.handlers.BotState;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static pddurfubot.weatherAPI.Weather.ApiRequest;

public class WeatherLocate implements CommandInterface {

    @Override
    public String getDescription() {
        return "Запуск тестирования пользователя";
    }

    @Override
    public String getName() {
        return "/" + this.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public String exec(String[] args) { return "Отправьте геолокацию"; }

    @Override
    public SendMessage getMessage(Message receivedMessage) throws MalformedURLException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(receivedMessage.getChatId().toString());
        /*sendMessage.setText(BotState.ASK_WEATHER.command.exec(new String[]{}));*/
        sendMessage.setText(ApiRequest(60.99, 30.9));
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setSelective(false);
        keyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton("Отправить свою геолокацию", false, true, null);
        row.add(button);
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);

        sendMessage.setReplyMarkup(keyboardMarkup);
        return sendMessage;
    }
}
