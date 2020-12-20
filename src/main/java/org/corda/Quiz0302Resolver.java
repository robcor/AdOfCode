package org.corda;


import org.corda.model.DayThreeData;

import java.util.function.Function;
import java.util.function.Predicate;

public class Quiz0302Resolver extends Quiz<DayThreeData> {

    public Quiz0302Resolver(String fileName) {
        Predicate<DayThreeData> isOk = s -> checkValue( s );
        Function<String, DayThreeData> parse = s -> parseInput( s );
        quizTemplate = new QuizTemplateResolver<DayThreeData>( fileName, isOk, parse );
    }


    @Override
    protected boolean checkValue(DayThreeData data) {
        return false;
    }

    @Override
    protected DayThreeData parseInput(String input) {
        return new DayThreeData(input);
    }
}
