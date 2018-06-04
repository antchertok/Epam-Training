package by.epam.task2.util.parser;

import by.epam.task2.model.Component;
import by.epam.task2.model.Composite;
import by.epam.task2.model.Leaf;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends Parser {

    public WordParser(Parser nextParser) {
        super(nextParser);
    }

    public WordParser() {
        super(null);
    }

    @Override
    public Component parse(String text) {
        ResourceBundle bundle = ResourceBundle.getBundle("regex", Locale.ENGLISH);
        Matcher matcher = Pattern.compile(bundle.getString("word")).matcher(text);
        Parser nextParser = getNextParser();
        Composite branches = new Composite();

        if (nextParser != null) {
            while (matcher.find()) {
                branches.add(nextParser.parse(matcher.group()));
            }
        } else {
            while (matcher.find()) {
                branches.add(new Leaf(matcher.group()));
            }
        }
        return branches;
    }
}
