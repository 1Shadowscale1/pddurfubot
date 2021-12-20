package pddurfubot.exam;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FormHtmlStats {
    public static File FormHtml(String date, int variant, int result,
                                List<AnsweredExamQuestion> answeredQuestions) throws IOException {
        File htmlTemplateFile = new File("src/main/resources/exam-stats.html");
        String htmlString = FileUtils.readFileToString(htmlTemplateFile);

        String head = "Дата: " + date;
        String subHead = "Вариант: " + variant;
        String examResult = "Результат " + result + " " + "из" + answeredQuestions.size() + ".";
        htmlString = htmlString.replace("$head", head);
        htmlString = htmlString.replace("$subhead", subHead);
        htmlString = htmlString.replace("$result", examResult);

        int i;
        for (i = 0; i < answeredQuestions.size(); i++) {
            AnsweredExamQuestion answer = answeredQuestions.get(i);
            StringBuilder pic = new StringBuilder("<p><img src=\"data:image/jpg;base64, " +
                    imageToTxt(answer.getImageFile().getPath()) +
                    "\" alt=\"pddQuestionImage\" width=\"300\" height=\"200\"></p>");
            int j;
            for (j = 0; j < answer.answers.size(); j++){
                List<String> answers = answer.getAnswers();
                pic.append("<p");
                if (answer.correctAnswer.equals(String.valueOf(answers.get(j).charAt(0))))
                    pic.append(" style=\"color:#86dc3d\"");
                else if (answer.getUserAnswer().equals(String.valueOf(answers.get(j).charAt(0))))
                    pic.append(" style=\"color:#ff0000\"");
                pic.append(">").append(answers.get(j)).append("</p>");
            }
            int index = htmlString.indexOf("</body>");
            htmlString = new StringBuilder(htmlString).insert(index, pic).toString();
        }

        htmlString = new StringBuilder(htmlString).insert(htmlString.indexOf("</body>"),
                "<p>" + examResult + "</p>").toString();

        File newHtmlFile = new File("src/main/resources/exam-stats-new.html");
        FileUtils.writeStringToFile(newHtmlFile, htmlString);
        return newHtmlFile;
    }

    private static String imageToTxt(String path) throws IOException{
        File file = new File(path);
        byte[] bytes = Files.readAllBytes(file.toPath());
        return new String(Base64.encodeBase64(bytes), "UTF-8");
    }
}
