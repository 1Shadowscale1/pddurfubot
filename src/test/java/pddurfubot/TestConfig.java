package pddurfubot;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

final public class TestConfig {
    public User user = new User();
    public Chat chat = new Chat();
    public Message testMessage = new Message();
    public TestConfig(){
        user.setId(1L);
        chat.setId(1L);
        testMessage.setChat(chat);
        testMessage.setFrom(user);
    }
}
