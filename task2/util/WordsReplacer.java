package by.epam.task2.util;

import by.epam.task2.controller.StringAnalyzerTest;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsReplacer {
    private static final ResourceBundle bundle = ResourceBundle.getBundle("regex", Locale.ENGLISH);

    /**
     * Replaces the first and last word in each sentence, except for the code
     *
     * @param text text for searching words
     * @return altered text
     */
    public String replaceWords(String text) {
        Matcher sentence = Pattern.compile(bundle.getString("cleanSentences")).matcher(text);
        Pattern pattern = Pattern.compile(bundle.getString("sideWords"));
        StringBuilder result = new StringBuilder();
        String[] sideWords = new String[2];

        while (sentence.find()) {

            if (sentence.group().contains("{")) {
                StringBuilder code = new StringBuilder(sentence.group());
                int bracketCounter = 1;

                while ((bracketCounter != 0) && sentence.find()) {
                    if (sentence.group().contains("{")) {
                        bracketCounter++;
                    }
                    if (sentence.group().contains("}")) {
                        bracketCounter--;
                    }
                    code.append(sentence.group());
                }
                result.append(code);
            } else {
                Matcher word = pattern.matcher(sentence.group());
                int i = 0;

                while (word.find()) {
                    sideWords[i++] = word.group();
                }

                sideWords[1] = sideWords[1].replace(sideWords[1].substring(sideWords[1].length() - 1), "");
                result.append(sentence.group().replace(sideWords[1], sideWords[0])
                        .replaceFirst(bundle.getString("sideWords"), sideWords[1]));
                result.append(" ");
            }
        }

        return result.toString();
    }

}
