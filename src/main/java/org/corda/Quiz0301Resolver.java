package org.corda;


import org.corda.model.DayThreeData;

import java.util.function.Function;
import java.util.function.Predicate;

public class Quiz0301Resolver extends Quiz<DayThreeData> {
    private QuizTemplateResolver quizTemplate;


    public Quiz0301Resolver(String fileName) {
        Predicate<DayThreeData> isOk = s -> checkValue( s );
        Function<String, DayThreeData> parse = s -> parseInput( s );
        quizTemplate = new QuizTemplateResolver( fileName, isOk, parse );
    }

    @Override
    protected boolean checkValue(DayThreeData data) {
        return false;
    }

    @Override
    protected DayThreeData parseInput(String input) {
        return null;
    }
}
