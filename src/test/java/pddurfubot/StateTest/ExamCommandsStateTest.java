package pddurfubot.StateTest;

import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.objects.Location;
import pddurfubot.TestConfig;
import pddurfubot.cache.UserDataCache;
import pddurfubot.handlers.BotState;
import pddurfubot.handlers.CommandSwitch;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExamCommandsStateTest {


    @Test
    public void IdTest(){
        TestConfig testConfig = new TestConfig();
        assertEquals(testConfig.testMessage.getChatId()
                ,testConfig.testCallbackQuery.getMessage().getChatId());
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

    @Test
    public void QuestionAfterExamStartCallback() throws IOException {
        TestConfig testConfig = new TestConfig();
        testConfig.testCallbackQuery.setData("0");
        CommandSwitch.ProcessCallback(testConfig.testCallbackQuery);
        assertEquals(BotState.QUESTION_EXAM,
                UserDataCache.getUsersCurrentBotState(testConfig.testCallbackQuery.getMessage().getChatId()));
    }
}
