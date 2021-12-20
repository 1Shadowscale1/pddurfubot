package pddurfubot.exam;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FormHtmlStats {
    public static File FormHtml(String chatId,String date, int variant, int result,
                                List<AnsweredExamQuestion> answeredQuestions) throws IOException {
        File htmlTemplateFile = new File("src/main/resources/exam-stats.html");
        String htmlString = FileUtils.readFileToString(htmlTemplateFile);

        String head = "Дата: " + date;
        String subHead = "Вариант: " + variant;
        String examResult = "Результат " + result + " " + "из " + answeredQuestions.size() + ".";
        htmlString = htmlString.replace("$head", head);
        htmlString = htmlString.replace("$subhead", subHead);

        for (AnsweredExamQuestion question : answeredQuestions) {

            StringBuilder pic = new StringBuilder(
                    "<div style=\"border: 4px double black; padding: 10px; margin: 20px;\">" +
                    "<p><img src=\"data:image/jpg;base64, " +
                    imageToTxt(question.getImageFile().getPath()) +
                    "\" alt=\"pddQuestionImage\" width=\"550\" height=\"250\"></p>"
            );
            for (String answer : question.answers) {
                pic.append("<p");
                if (question.correctAnswer.equals(String.valueOf(answer.charAt(0))))
                    pic.append(" style=\"color:#86dc3d\"");
                else if (question.getUserAnswer().equals(String.valueOf(answer.charAt(0))))
                    pic.append(" style=\"color:#ff0000\"");
                pic.append(">").append(answer).append("</p>");
            }
            pic.append("</div>");
            int index = htmlString.indexOf("</body>");
            htmlString = new StringBuilder(htmlString).insert(index, pic).toString();
        }

        htmlString = new StringBuilder(htmlString).insert(htmlString.indexOf("</body>"),
                "<p style=\"font-size: 2em\">" + examResult + "</p>").toString();

        File newHtmlFile = new File("src/main/resources/"+chatId+".html");
        FileUtils.writeStringToFile(newHtmlFile, htmlString);
        return newHtmlFile;
    }

    private static String imageToTxt(String path) throws IOException{
        File file = new File(path);
        byte[] bytes = Files.readAllBytes(file.toPath());
        return new String(Base64.encodeBase64(bytes), "UTF-8");
    }
}
