package pddurfubot.exam;

import pddurfubot.db.DataBase;

import java.util.ArrayList;

public final class ExamBuilder {
    private static final Long VariantsCount = DataBase.getVariantsCount();

    private static final ArrayList<ArrayList<ExamQuestion>> allVariants = DataBase.getAllVariants();

    public static Long getVariantsCount(){
        return VariantsCount;
    }

    public static ArrayList<ExamQuestion> getExamList(Integer variant) {
        return allVariants.get(variant-1);
    }

}
