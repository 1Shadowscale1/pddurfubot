package pddurfubot.exam;

import javax.persistence.*;
import java.io.*;
import java.util.List;

@Entity
@Table(name = "variant1")
public class ExamQuestion {

    @Id
    @Column
    private Integer id;

    @Lob
    @Column(name = "question_image")
    private byte[] questionImage;

    @ElementCollection
    @Column
    private List<String> answers;

    @Column(name = "correct_answer")
    private String correctAnswer;

    @Column(name = "question_text")
    private String questionText;

    public ExamQuestion(){}

    public ExamQuestion(Integer id,byte[] questionImage, List<String> answers, String correctAnswer, String questionText){
        this.id = id;
        this.questionImage = questionImage;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.questionText = questionText;
    }


    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public byte[] getQuestionImage() {
        return questionImage;
    }

    public void setQuestionImage(byte[] questionImage) {
        this.questionImage = questionImage;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public File getImageFile() throws IOException {
        File file = new File("src\\main\\resources\\images\\"+id+".jpg");
        if (!file.exists()){
            OutputStream os = new FileOutputStream(file);
            os.write(questionImage);
            os.close();
        }
        return file;
    }

}

