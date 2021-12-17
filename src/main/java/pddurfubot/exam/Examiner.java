package pddurfubot.exam;

import java.util.ArrayList;

public class Examiner {

    private final ArrayList<ExamQuestion> examList;
    private Integer questionPointer = 0;
    private Integer examResults = 0;
    private String wrongAnswers = "";
    private boolean examFinished = true;

    public Examiner(Integer variant){
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

        if (answer.equals("right")){
            examResults++;
        }
        else {
            ExamQuestion examQuestion = examList.get(questionPointer);
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
}
