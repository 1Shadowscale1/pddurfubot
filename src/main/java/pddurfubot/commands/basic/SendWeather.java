package pddurfubot.commands.basic;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import pddurfubot.commands.CommandInterface;
import pddurfubot.weatherAPI.Weather;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class SendWeather implements CommandInterface {
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
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(receivedMessage.getChatId().toString());
        Location location = receivedMessage.getLocation();
        sendMessage.setText(Weather.ApiRequest(location.getLatitude(), location.getLongitude()));

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setSelective(false);

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
