package pddurfubot.CommandTests;

import org.junit.jupiter.api.Test;
import pddurfubot.TestConfig;
import pddurfubot.cache.UserDataCache;
import pddurfubot.commands.basic.Help;
import pddurfubot.handlers.BotState;
import pddurfubot.handlers.CommandSwitch;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelpCommandTest {
    TestConfig testConfig = new TestConfig();
    @Test
    public void OutputTest()
    {
        testConfig.testMessage.setText("/help");
        assertEquals(new Help().exec(new String[]{},1L),
                CommandSwitch.ProcessCommands(testConfig.testMessage)
                        .getText());
    }

    @Test
    public void StateTest()
    {
        testConfig.testMessage.setText("/help");
        CommandSwitch.ProcessCommands(testConfig.testMessage);
        assertEquals(BotState.ANSWER_HELP,
                UserDataCache.getUsersCurrentBotState(testConfig.user.getId()));
    }
}
