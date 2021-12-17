package pddurfubot.exam;

import pddurfubot.db.DataBase;

import java.util.ArrayList;

public class ExamBuilder {
    private static final Long VariantsCount = DataBase.getVariantsCount();

    public static Long getVariantsCount(){
        return VariantsCount;
    }

    public ArrayList<ExamQuestion> getExamList(Integer variant) {
        return DataBase.getVariant(variant);
    }
}
