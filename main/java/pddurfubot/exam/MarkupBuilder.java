package pddurfubot.exam;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class MarkupBuilder {
    public static ArrayList getQuestionMarkup(ExamQuestion examQuestion) {
        List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
        for (int i = 0; i < examQuestion.getAnswers().size(); i++){
            List<InlineKeyboardButton> inlineKeyboardButtonList = new ArrayList<>();
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            inlineKeyboardButton.setText(examQuestion.getAnswers().get(i));

            if (examQuestion.getAnswers().get(i).equals(examQuestion.getCorrectAnswer())){
                inlineKeyboardButton.setCallbackData("right");
            }
            else {
                inlineKeyboardButton.setCallbackData("wrong");
            }
            inlineKeyboardButtonList.add(inlineKeyboardButton);
            inlineButtons.add(inlineKeyboardButtonList);
        }
        return (ArrayList) inlineButtons;
    }

    public static ArrayList getExamMarkup(){
        List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList = new ArrayList<>();
        for (int i = 1; i <= ExamBuilder.getVariantsCount(); i++){

            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            inlineKeyboardButton.setText(Integer.toString(i));
            inlineKeyboardButton.setCallbackData(Integer.toString(i));

            inlineKeyboardButtonList.add(inlineKeyboardButton);

            if (i % 5 == 0){
                inlineButtons.add(inlineKeyboardButtonList);
                inlineKeyboardButtonList = new ArrayList<>();
            }
        }
        inlineButtons.add(inlineKeyboardButtonList);

        return (ArrayList) inlineButtons;
    }
}
