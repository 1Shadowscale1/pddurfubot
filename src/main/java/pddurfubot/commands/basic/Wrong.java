package pddurfubot.commands.basic;

import pddurfubot.commands.CommandInterface;
import java.util.List;

public class Wrong implements CommandInterface {

    @Override
    public String getDescription() {
        return "Если пользователь ввел неверную команду";
    }

    @Override
    public String getName() {
        return "/" + this.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public String exec(String[] args, int userId) { return "Неверная команда"; }
}