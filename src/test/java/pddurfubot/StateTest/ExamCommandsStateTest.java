package pddurfubot.StateTest;

import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.objects.Location;
import pddurfubot.TestConfig;
import pddurfubot.cache.UserDataCache;
import pddurfubot.handlers.BotState;
import pddurfubot.handlers.CommandSwitch;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExamCommandsStateTest {

    @Test
    public void LocationMessageStateTest()
    {
        TestConfig testConfig = new TestConfig();
        testConfig.testMessage.setLocation(new Location());
        CommandSwitch.ProcessCommands(testConfig.testMessage);
        assertEquals(BotState.SEND_WEATHER,
                UserDataCache.getUsersCurrentBotState(testConfig.testMessage.getChatId()));
    }

    @Test
    public void ExamStartMessageTest(){
        TestConfig testConfig = new TestConfig();
        testConfig.testMessage.setText("/examstart");
        CommandSwitch.ProcessCommands(testConfig.testMessage);
        assertEquals(BotState.START_EXAM,
                UserDataCache.getUsersCurrentBotState(testConfig.testMessage.getChatId()));
    }

    @Test
    public void ExamStopMessageTest(){
        TestConfig testConfig = new TestConfig();
        testConfig.testMessage.setText("/examstop");
        CommandSwitch.ProcessCommands(testConfig.testMessage);
        assertEquals(BotState.END_EXAM,
                UserDataCache.getUsersCurrentBotState(testConfig.testMessage.getChatId()));
    }
}
