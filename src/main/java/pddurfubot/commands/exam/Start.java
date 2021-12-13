package pddurfubot.commands.exam;

import pddurfubot.commands.CommandInterface;

public class Start implements CommandInterface {

    @Override
    public String getDescription() {
        return "Запуск тестирования пользователя";
    }

    @Override
    public String getName() {
        return "/" + this.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public String exec(String[] args, Long chatId) {
        return "Выберите вариант";
    }
}
