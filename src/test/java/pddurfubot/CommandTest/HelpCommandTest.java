package pddurfubot.CommandTest;

import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import pddurfubot.TestConfig;
import pddurfubot.commands.basic.Help;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelpCommandTest {
    TestConfig testConfig = new TestConfig();

    @Test
    public void HelpTest()
    {
        testConfig.testMessage.setText("/help");
        Help help = new Help();
        SendMessage answer = help.getMessage(testConfig.testMessage);
        assertEquals("/help - возвращает это сообщение\n" +
                        "/about - возвращает информацию о разработчиках бота\n" +
                        "/examstart - начинает тест ПДД \n" +
                        "/examstop - принудительно завершает тест ПДД, начатый пользователем",
                answer.getText());
    }
}
