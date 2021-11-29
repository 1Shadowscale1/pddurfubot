package pddurfubot.commands.exam;

import pddurfubot.cache.UserDataCache;
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
    public String exec(String[] args, Long userId) {
        UserDataCache userDataCache = new UserDataCache();
        int count;
        try {
            count = Integer.parseInt(args[1]);
        } catch (NumberFormatException|ArrayIndexOutOfBoundsException e) {
            return "Напишите число вопросов в корректном виде";
        }
        if (count > 20 | count < 1) {
            userDataCache.setUsersCurrentBotState(userId, null);
            return "Неверный ввод параметра";
        }
        return "Пишите ответ как \"answer + номер варианта\"\n\n" + "Начинаем экзамен...";
    }
}
