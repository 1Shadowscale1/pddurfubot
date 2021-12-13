package pddurfubot.commands.basic;

import pddurfubot.commands.CommandInterface;

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
    public String exec(String[] args, Long chatId) {
        return "Создатели: Владынцев Сергей, Данилов Илья";
    }
}