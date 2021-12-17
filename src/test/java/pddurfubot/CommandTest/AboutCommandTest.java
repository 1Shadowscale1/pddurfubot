package pddurfubot.CommandTest;

import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import pddurfubot.TestConfig;
import pddurfubot.commands.basic.About;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutCommandTest {
    TestConfig testConfig = new TestConfig();

    @Test
    public void AboutTest()
    {
        testConfig.testMessage.setText("/about");
        About about = new About();
        SendMessage answer = about.getMessage(testConfig.testMessage);
        assertEquals("Создатели: Владынцев Сергей, Данилов Илья",
                answer.getText());
    }
}
