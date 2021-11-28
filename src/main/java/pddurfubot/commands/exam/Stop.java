package pddurfubot.commands.exam;

import pddurfubot.commands.CommandInterface;

public class Stop implements CommandInterface {

    @Override
    public String getDescription() {
        return "Принудительная остановка тестирования пользователя";
    }

    @Override
    public String getName() {
        return "/" + this.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public String exec(String[] args, int userId) {
        return "Завершаем экзамен...";
    }
}
