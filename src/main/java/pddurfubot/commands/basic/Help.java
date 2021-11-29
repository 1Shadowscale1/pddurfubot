package pddurfubot.commands.basic;

import pddurfubot.commands.CommandInterface;
import java.util.List;

public class Help implements CommandInterface {

    @Override
    public String getDescription() {
        return "Возвращает справку по боту";
    }

    @Override
    public String getName() {
        return "/" + this.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public String exec(String[] args, Long userId) {

        return "Возможно вы ввели неправильную команду\n" +
                "/help - возвращает это сообщение\n" +
                "/about - возвращает информацию о разработчиках бота\n" +
                "/examStart + число - начинает тест ПДД на заданное количество вопросов (от 1 до 20)\n" +
                "/examStop - принудительно завершает тест ПДД, начатый пользователем";
    }
}