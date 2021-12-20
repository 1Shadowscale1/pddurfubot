package pddurfubot.exam;

import org.apache.commons.io.FileUtils;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FormHtmlStats {
    public static File FormHtml(String date, int variant, int result,
                                List<AnsweredExamQuestion> answeredQuestions) throws IOException {
        File htmlTemplateFile = new File("src\\main\\resources\\exam-stats.html");
        String htmlString = FileUtils.readFileToString(htmlTemplateFile);

        String head = "Дата: " + date;
        String subHead = "Вариант: " + variant;
        String examResult = "Результат " + result + "из 20.";
        htmlString = htmlString.replace("$head", head);
        htmlString = htmlString.replace("$subhead", subHead);
        htmlString = htmlString.replace("$result", examResult);
        File newHtmlFile = new File("src\\main\\resources\\exam-stats-new.html");
        FileUtils.writeStringToFile(newHtmlFile, htmlString);
        return newHtmlFile;
    }
}
