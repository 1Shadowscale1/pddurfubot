package pddurfubot.commands.weather;

import pddurfubot.commands.CommandInterface;

public class StartLocate implements CommandInterface {

    @Override
    public String getDescription() {
        return "Запуск тестирования пользователя";
    }

    @Override
    public String getName() {
        return "/" + this.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public String exec(String[] args, Long chatId) { return "Отправьте геолокацию"; }
}

