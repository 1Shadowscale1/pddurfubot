package pddurfubot.exam;

public class ExamBuilder {
    private ExamQuestion[] ExamList = new ExamQuestion[5];
    private static Integer VariantsCount = 40;

    public static Integer getVariantsCount(){
        return VariantsCount;
    }

    public ExamQuestion[] getExamList(Integer variant) {
        for (int i = 0; i < 5; i++){
            ExamList[i] = new ExamQuestion(
                    "?????????????????????",
                    new String[]{"n","e","t",Integer.toString(i)},
                    Integer.toString(i));
        }
        return ExamList;
    }
}
