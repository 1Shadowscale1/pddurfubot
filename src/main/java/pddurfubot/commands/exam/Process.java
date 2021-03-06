package pddurfubot.commands.exam;

import pddurfubot.cache.UserDataCache;
import pddurfubot.commands.CommandInterface;

public class Process implements CommandInterface {

    @Override
    public String getDescription() {
        return "выдает вопрос экзамена и обрабатывает ответ, вызывает следующий или заканчивает экзамен";
    }

    @Override
    public String getName() {
        return "/" + this.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public String exec(String[] args, Long userId) {
        int answer;
        try {
            answer = Integer.parseInt(args[1]);
        } catch (NumberFormatException|ArrayIndexOutOfBoundsException e) {
            return "Напишите вариант ответа в виде числа";
        }
        if (answer > 4 | answer < 1) {
            return "Неверный ввод параметра";
        }
        if (answer == 4)
            return "Верный ответ";
        else {
            return "Неправильный ответ";
        }
    }
}
