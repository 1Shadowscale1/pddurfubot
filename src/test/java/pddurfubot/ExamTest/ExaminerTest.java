package pddurfubot.ExamTest;

import org.junit.jupiter.api.Test;
import pddurfubot.exam.Examiner;

import static org.junit.jupiter.api.Assertions.*;

public class ExaminerTest {

    @Test
    public void NewExaminerInitTest(){
        Examiner examiner = new Examiner(0);
        assertTrue(examiner.isExamFinished());
        assertEquals("",examiner.getWrongAnswers());
    }

    @Test
    public void QuestionsOutTest(){
        Examiner examiner = new Examiner(0);
        assertNull(examiner.getNextQuestion());
        assertTrue(examiner.isExamFinished());
    }
}
