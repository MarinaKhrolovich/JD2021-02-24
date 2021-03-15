package by.it.runcov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            text.setCharAt(start + 3, '#');
            if (end - start > 6) {
                text.setCharAt(start + 6, '#');
            }
        }
        System.out.println(text);
    }
}
