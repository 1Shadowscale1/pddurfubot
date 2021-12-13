package pddurfubot.commands.exam;

import pddurfubot.cache.UserDataCache;
import pddurfubot.commands.CommandInterface;
import pddurfubot.handlers.BotState;

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
    public String exec(String[] args, Long chatId) {
        try {
            return UserDataCache
                    .getUsersExaminer(chatId)
                    .getNextQuestion()
                    .getQuestion();
        }
        catch (NullPointerException e){
            int result = UserDataCache
                    .getUsersExaminer(chatId)
                    .getExamResults();
            UserDataCache.setUsersCurrentBotState(chatId, BotState.ANSWER_HELP);
            return Integer.toString(result);
        }

    }
}
