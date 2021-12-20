package pddurfubot.exam;

import java.util.ArrayList;

public class Examiner {

    private final ArrayList<ExamQuestion> examList;
    private Integer questionPointer = 0;
    private Integer examResults = 0;
    private String wrongAnswers = "";
    private boolean examFinished = true;
    private ArrayList<AnsweredExamQuestion> answeredExamQuestions = new ArrayList<>();

    public Examiner(Integer variant){
        if (variant == 0)
            examList = new ArrayList<>();
        else
            examList = ExamBuilder.getExamList(variant);
    }

    public ExamQuestion getNextQuestion(){
        try {
            examFinished = false;
            return examList.get(questionPointer);
        }
        catch (IndexOutOfBoundsException e){
            examFinished = true;
            return null;
        }
    }

    public void setExamFinished(boolean examFinished){
        this.examFinished = examFinished;
    }

    public boolean isExamFinished() {
        return examFinished;
    }

    public void setAnswer(String answer){
        String formatAnswer = answer.substring(1);
        ExamQuestion examQuestion = examList.get(questionPointer);
        if (formatAnswer.equals(String.valueOf(examQuestion.getCorrectAnswer().charAt(0)))){
            examResults++;
        }
        else {
            wrongAnswers = wrongAnswers + examQuestion.getQuestionNumber()+". "+examQuestion.getCorrectAnswer()+"\n";
        }
        questionPointer++;
    }

    public String getWrongAnswers() {return wrongAnswers;}

    public Integer getQuestionAmount(){
        return examList.size();
    }

    public int getExamResults(){
        return examResults;
    }

    public ArrayList<AnsweredExamQuestion> getAnsweredExamQuestions() {
        return answeredExamQuestions;
    }
}
