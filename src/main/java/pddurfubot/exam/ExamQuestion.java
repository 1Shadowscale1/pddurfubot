package pddurfubot.exam;

import java.io.File;

public class ExamQuestion {
    private final String Question;
    private final String[] Answers;
    private final String CorrectAnswer;

    public ExamQuestion(String  question,String[] answers, String correctAnswer){
        Question = question;
        Answers = answers;
        CorrectAnswer = correctAnswer;
    }

    public String getQuestion(){ return Question; }

    public String[] getAnswers(){
        return Answers;
    }

    public String getCorrectAnswer(){
        return CorrectAnswer;
    }

}
