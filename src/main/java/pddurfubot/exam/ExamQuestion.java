package pddurfubot.exam;

import javax.persistence.*;
import java.io.*;
import java.nio.file.Files;
import java.util.List;

@Entity
@Table(name = "exam_questions")
public class ExamQuestion {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(name = "question_number")
    protected Integer questionNumber;

    @Column(name = "exam_variant")
    protected Integer examVariant;

    @Column(name="question_image")
    protected byte[] questionImage;

    @ElementCollection
    @Column
    protected List<String> answers;

    @Column(name = "correct_answer")
    protected String correctAnswer;

    @Column(name = "question_text")
    protected String questionText;

    public ExamQuestion(){}

    public ExamQuestion(Integer examVariant,
                        Integer questionNumber,
                        byte[] questionImage,
                        String questionText,
                        List<String> answers,
                        String correctAnswer)
    {
        this.examVariant = examVariant;
        this.questionNumber = questionNumber;
        this.questionImage = questionImage;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.questionText = questionText;
    }


    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Integer getExamVariant() {return examVariant;}
    public void setExamVariant(Integer examVariant) {this.examVariant = examVariant;}

    public Integer getQuestionNumber() {return questionNumber;}
    public void setQuestionNumber(Integer questionNumber) {this.questionNumber = questionNumber;}

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
        File file = new File("src\\main\\resources\\images\\"+examVariant+"_"+questionNumber+".jpg");
        if (!file.exists()){
            OutputStream os = new FileOutputStream(file);
            os.write(questionImage);
            os.close();
        }
        return file;
    }

    public static byte[] ConvertImg(String path) throws IOException {
        File fi = new File(path);
        return Files.readAllBytes(fi.toPath());
    }

}

