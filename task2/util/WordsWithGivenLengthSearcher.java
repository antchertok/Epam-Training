package by.epam.task2.util;

import by.epam.task2.controller.StringAnalyzerTest;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsWithGivenLengthSearcher {
    private static final Logger logger = Logger.getLogger(StringAnalyzerTest.class.getName());
    private static final ResourceBundle bundle = ResourceBundle.getBundle("regex", Locale.ENGLISH);

    /**
     * Searches words in text with given length without duplication
     *
     * @param length given length for words
     * @param text   text for searching words
     * @return string, containing words with given length
     */
    public String findWordsWithGivenLength(int length, String text) {
        logger.debug("Length of words to search: " + length);
        Matcher sentence = Pattern.compile(bundle.getString("interrogativeSentence")).matcher(text);
        Pattern pattern = Pattern.compile(bundle.getString("firstHalf") + length + bundle.getString("secondHalf"));
        Set<String> result = new HashSet<>();

        while (sentence.find()) {
            Matcher word = pattern.matcher(sentence.group());

            while (word.find()) {
                result.add(word.group().trim());
            }
        }

        return result.toString();

    }
}
