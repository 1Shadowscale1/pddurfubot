package pddurfubot.CommandTests;

import org.junit.jupiter.api.Test;
import pddurfubot.TestConfig;
import pddurfubot.handlers.BotState;
import pddurfubot.handlers.CommandSwitch;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutCommandTest {
    TestConfig testConfig = new TestConfig();
    @Test
    public void OutputTest()
    {
        testConfig.testMessage.setText("/about");
        assertEquals("Создатели: Владынцев Сергей, Данилов Илья",
                CommandSwitch.ProcessCommands(testConfig.testMessage)
                        .getText());
    }

    @Test
    public void StateTest()
    {
        testConfig.testMessage.setText("/about");
        CommandSwitch.ProcessCommands(testConfig.testMessage);
        assertEquals(BotState.ANSWER_ABOUT,
                CommandSwitch.userDataCache.getUsersCurrentBotState(testConfig.user.getId()));
    }
}
