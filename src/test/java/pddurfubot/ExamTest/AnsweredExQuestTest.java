package pddurfubot.ExamTest;

import org.junit.jupiter.api.Test;
import pddurfubot.exam.AnsweredExamQuestion;
import pddurfubot.exam.ExamQuestion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnsweredExQuestTest {
    @Test
    public void initTest() throws IOException {

        ExamQuestion examQuestion = new ExamQuestion(
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

        String receivedFromCallbackData = "q2";

        AnsweredExamQuestion answeredExamQuestion = new AnsweredExamQuestion(examQuestion,
                receivedFromCallbackData.substring(1));

        assertEquals("2",answeredExamQuestion.getUserAnswer());

    }
}
