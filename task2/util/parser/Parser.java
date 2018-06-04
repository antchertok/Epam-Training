package by.epam.task2.util.parser;

import by.epam.task2.controller.StringAnalyzerTest;
import by.epam.task2.model.Component;
import org.apache.log4j.Logger;

/**
 * Subclasses is to parse given text into some pieces specified by those subclasses names
 */
public abstract class Parser {
    private static final Logger logger = Logger.getLogger(StringAnalyzerTest.class.getName());
    private Parser nextParser;

    public Parser(Parser nextParser) {
        this.nextParser = nextParser;
    }

    /**
     * Set next parser to further splitting text
     *
     * @param nextParser parser to be set
     */
    public void setNext(Parser nextParser) {
        logger.debug("New parser is set");
        this.nextParser = nextParser;
    }

    public Parser getNextParser() {
        return nextParser;
    }

    /**
     * This method splits the text and put it parts into implementations of {@link Component}
     *
     * @param text text to parse
     * @return assembled implementation of Component
     */
    public abstract Component parse(String text);
}
