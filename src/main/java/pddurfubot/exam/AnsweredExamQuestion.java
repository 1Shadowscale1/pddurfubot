package pddurfubot.exam;

public class AnsweredExamQuestion extends ExamQuestion{

    private String userAnswer;

    public AnsweredExamQuestion(ExamQuestion examQuestion, String userAnswer){
        this.questionNumber = examQuestion.questionNumber;
        this.examVariant = examQuestion.examVariant;
        this.questionImage = examQuestion.questionImage;
        this.questionText = examQuestion.questionText;
        this.answers = examQuestion.answers;
        this.correctAnswer = String.valueOf(examQuestion.correctAnswer.charAt(0));
        this.userAnswer = userAnswer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}
