package by.epam.task2.util.parser;

import by.epam.task2.model.Component;
import by.epam.task2.model.Composite;
import by.epam.task2.model.Leaf;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends Parser {

    public ParagraphParser(Parser nextParser) {
        super(nextParser);
    }

    public ParagraphParser() {
        super(null);
    }

    @Override
    public Component parse(String text) {
        ResourceBundle bundle = ResourceBundle.getBundle("regex", Locale.ENGLISH);
        Matcher paragraph = Pattern.compile(bundle.getString("paragraph")).matcher(text);
        ArrayList<Component> branches = new ArrayList<>();

        while (paragraph.find()) {
            Parser nextParser = getNextParser();

            if (paragraph.group().contains("{")) {
                StringBuilder sb = new StringBuilder(paragraph.group());
                int bracketCounter = 1;

                while ((bracketCounter != 0) && paragraph.find()) {

                    if (paragraph.group().contains("{")) {
                        bracketCounter++;
                    }
                    if (paragraph.group().contains("}")) {
                        bracketCounter--;
                    }
                    sb.append(paragraph.group());
                }
                branches.add(new Leaf(sb.toString()));
            } else if (nextParser != null) {
                branches.add(nextParser.parse(paragraph.group()));
            } else {
                branches.add(new Leaf(paragraph.group()));
            }
        }
        return new Composite(branches);
    }
}
