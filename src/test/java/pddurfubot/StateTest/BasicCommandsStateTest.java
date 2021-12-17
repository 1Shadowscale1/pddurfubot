package pddurfubot.StateTest;

import org.junit.jupiter.api.Test;
import pddurfubot.TestConfig;
import pddurfubot.cache.UserDataCache;
import pddurfubot.handlers.BotState;
import pddurfubot.handlers.CommandSwitch;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCommandsStateTest {
    TestConfig testConfig = new TestConfig();

    @Test
    public void idEqualTest(){
        assertEquals(testConfig.chat.getId(),testConfig.testMessage.getChatId());
    }

    @Test
    public void helpMessageStateTest()
    {
        testConfig.testMessage.setText("/help");
        CommandSwitch.ProcessCommands(testConfig.testMessage);
        assertEquals(BotState.ANSWER_HELP,
                UserDataCache.getUsersCurrentBotState(testConfig.testMessage.getChatId()));
    }

    @Test
    public void aboutMessageStateTest()
    {
        testConfig.testMessage.setText("/about");
        CommandSwitch.ProcessCommands(testConfig.testMessage);
        assertEquals(BotState.ANSWER_ABOUT,
                UserDataCache.getUsersCurrentBotState(testConfig.testMessage.getChatId()));
    }

    @Test
    public void RandomMessageStateTest()
    {
        testConfig.testMessage.setText("random text");
        CommandSwitch.ProcessCommands(testConfig.testMessage);
        assertEquals(BotState.ANSWER_HELP,
                UserDataCache.getUsersCurrentBotState(testConfig.testMessage.getChatId()));
    }
}
