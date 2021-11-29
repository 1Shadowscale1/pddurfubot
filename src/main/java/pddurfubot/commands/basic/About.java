package pddurfubot.commands.basic;

import pddurfubot.commands.CommandInterface;
import java.util.List;

public class About implements CommandInterface {

    @Override
    public String getDescription() {
        return "Возвращает имена создателей бота";
    }

    @Override
    public String getName() {
        return "/" + this.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public String exec(String[] args, Long userId) {
        return "Создатели: Владынцев Сергей, Данилов Илья";
    }
}