package pddurfubot.commands;

import java.util.List;

public interface CommandInterface {

    String getDescription();

    String getName();

    String exec(String[] args, Long chatId);
}