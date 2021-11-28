package pddurfubot;

import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import pddurfubot.commands.basic.About;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class BotTest {
    @Test
    public void formMessageTest()
    {
        Chat chat = new Chat();
        chat.setId(1L);
        Message myMessage = new Message();
        myMessage.setText("/about");
        myMessage.setChat(chat);
        Update update = new Update();
        update.setMessage(myMessage);

        HashMap<String, About> botCommands = new HashMap<>();
        About about = new About();
        botCommands.put(about.getName(), about);

        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText(botCommands.get(update.getMessage().getText()).exec(null, 0));

        SendMessage expected = new SendMessage();
        expected.setText(about.exec(null, 0));
        expected.setChatId(chat.getId().toString());

        assertEquals(expected, message);
    }
}
