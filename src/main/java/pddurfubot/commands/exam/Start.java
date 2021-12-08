package pddurfubot.commands.exam;

import pddurfubot.cache.UserDataCache;
import pddurfubot.commands.CommandInterface;
import pddurfubot.handlers.BotState;
import pddurfubot.handlers.CommandSwitch;

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
