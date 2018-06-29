package by.epam.task1.util.parser;

import by.epam.task1.model.Derivative;

public class Director {
    private DerivativeParser derivativeParser;

    public Director(DerivativeParser derivativeParser){
        this.derivativeParser = derivativeParser;
    }

    public void setDerivativeParser(DerivativeParser derivativeParser){
        this.derivativeParser = derivativeParser;
    }

    public Derivative parse(String path){
        return derivativeParser.parse(path);
    }
}
