package pddurfubot.commands;

import java.util.List;

public interface CommandInterface {

    public String getDescription();

    public String getName();

    public String exec(String[] args, Long userId);
}