package pddurfubot.StateTest;

import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.objects.Location;
import pddurfubot.TestConfig;
import pddurfubot.cache.UserDataCache;
import pddurfubot.handlers.BotState;
import pddurfubot.handlers.CommandSwitch;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationStateTest {

    @Test
    public void LocationMessageStateTest()
    {
        TestConfig testConfig = new TestConfig();
        testConfig.testMessage.setLocation(new Location());
        CommandSwitch.ProcessCommands(testConfig.testMessage);
        assertEquals(BotState.SEND_WEATHER,
                UserDataCache.getUsersCurrentBotState(testConfig.testMessage.getChatId()));
    }
}
