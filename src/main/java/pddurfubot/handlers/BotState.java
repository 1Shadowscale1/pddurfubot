package pddurfubot.handlers;

import pddurfubot.commands.CommandInterface;
import pddurfubot.commands.basic.*;
import pddurfubot.commands.exam.Process;
import pddurfubot.commands.exam.SendTestStat;
import pddurfubot.commands.exam.Start;
import pddurfubot.commands.exam.Stop;

/** возможные состояния бота
 */

public enum BotState {
    SEND_TEST_STAT(new SendTestStat()),
    ANSWER_START(new StartConv()),
    ANSWER_HELP(new Help()),
    ANSWER_ABOUT(new About()),
    START_EXAM(new Start()),
    QUESTION_EXAM(new Process()),
    END_EXAM(new Stop()),
    SEND_WEATHER(new SendWeather());

    public final CommandInterface command;

    BotState(CommandInterface command){
        this.command = command;
    }
}
