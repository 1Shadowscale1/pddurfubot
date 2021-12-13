package pddurfubot.handlers;

import pddurfubot.commands.CommandInterface;
import pddurfubot.commands.basic.About;
import pddurfubot.commands.basic.Help;
import pddurfubot.commands.basic.Wrong;
import pddurfubot.commands.exam.Process;
import pddurfubot.commands.exam.Start;
import pddurfubot.commands.exam.Stop;
import pddurfubot.commands.weather.StartLocate;

/** возможные состояния бота
 */

public enum BotState {
    ANSWER_HELP(new Help()),
    ANSWER_ABOUT(new About()),
    START_EXAM(new Start()),
    QUESTION_EXAM(new Process()),
    END_EXAM(new Stop()),
    ASK_WEATHER(new StartLocate()),
    ANSWER_WRONG(new Wrong());

    public final CommandInterface command;

    BotState(CommandInterface command){
        this.command = command;
    }
}
