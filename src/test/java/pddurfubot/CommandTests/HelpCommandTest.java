package pddurfubot.CommandTests;

import org.junit.jupiter.api.Test;
import pddurfubot.TestConfig;
import pddurfubot.cache.UserDataCache;
import pddurfubot.handlers.BotState;
import pddurfubot.handlers.CommandSwitch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class HelpCommandTest {
    TestConfig testConfig = new TestConfig();

    @Test
    public void StateTest()
    {
        testConfig.testMessage.setText("/help");
        CommandSwitch.ProcessCommands(testConfig.testMessage);
        assertEquals(BotState.ANSWER_HELP,
                UserDataCache.getUsersCurrentBotState(testConfig.user.getId()));
    }
}
