package pddurfubot.ExamTest;

import org.junit.jupiter.api.Test;
import pddurfubot.exam.AnsweredExamQuestion;
import pddurfubot.exam.ExamQuestion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnsweredExQuestTest {

    public ExamQuestion examQuestion = new ExamQuestion(
            1,
            1,
            ExamQuestion.ConvertImg("src\\main\\resources\\examend.jpg"),
            "questionText",
            new ArrayList<String>(List.of(
                    "1. answer",
                    "2. answer",
                    "3. answer")),
            "2. answer"
    );

    public AnsweredExQuestTest() throws IOException {
    }

    @Test
    public void initTest(){
        String receivedFromCallbackData = "q2";

        AnsweredExamQuestion answeredExamQuestion = new AnsweredExamQuestion(examQuestion,
                receivedFromCallbackData.substring(1));

        assertEquals("2",answeredExamQuestion.getUserAnswer());

    }

    @Test
    public void correctAnswerTest(){
        String receivedFromCallbackData = "q2";

        AnsweredExamQuestion answeredExamQuestion = new AnsweredExamQuestion(examQuestion,
                receivedFromCallbackData.substring(1));

        assertEquals("2",answeredExamQuestion.getCorrectAnswer());
    }

    @Test
    public void answersListTest(){
        String receivedFromCallbackData = "q2";
        AnsweredExamQuestion answeredExamQuestion = new AnsweredExamQuestion(examQuestion,
                receivedFromCallbackData.substring(1));

        assertEquals(examQuestion.getAnswers().get(0)
                ,answeredExamQuestion.getAnswers().get(0));

        assertEquals(examQuestion.getAnswers().get(1)
                ,answeredExamQuestion.getAnswers().get(1));

        assertEquals(examQuestion.getAnswers().get(2)
                ,answeredExamQuestion.getAnswers().get(2));
    }



}
