package by.epam.task2.controller;

import by.epam.task2.model.Component;
import by.epam.task2.util.WordsReplacer;
import by.epam.task2.util.WordsWithGivenLengthSearcher;
import by.epam.task2.util.parser.ParagraphParser;
import by.epam.task2.util.parser.Parser;
import by.epam.task2.util.parser.SentenceParser;
import by.epam.task2.util.parser.WordParser;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class StringAnalyzerTest {
    private static final Logger logger = Logger.getLogger(StringAnalyzerTest.class.getName());
    private static final String PATH = "C:\\Users\\-\\IdeaProjects\\StartProjects\\src\\by\\epam\\task2\\data\\Text.txt";
    private static final String ERROR_MSG = "Failed to read the text";

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            FileReader fr = new FileReader(new File(PATH));
            int c;
            while ((c = fr.read()) != -1) {
                stringBuilder.append((char) c);
            }
        } catch (IOException e) {
            logger.error(ERROR_MSG);
        }


        String text = stringBuilder.toString();

        WordsReplacer wr = new WordsReplacer();
        logger.info(wr.replaceWords(text));
        ;

        WordsWithGivenLengthSearcher wwgl = new WordsWithGivenLengthSearcher();
        logger.info(wwgl.findWordsWithGivenLength(2, text));

        Parser parser = new ParagraphParser(new SentenceParser(new WordParser()));
        Component component = parser.parse(text);
        logger.info(component.toString());
    }

}