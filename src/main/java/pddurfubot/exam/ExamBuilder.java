package pddurfubot.exam;

import pddurfubot.db.DataBase;

public class ExamBuilder {
    private static Integer VariantsCount = DataBase.getVariantsCount();

    public static Integer getVariantsCount(){
        return VariantsCount;
    }

    public ExamQuestion[] getExamList(Integer variant) {
        return DataBase.getVariant(variant);
    }
}
