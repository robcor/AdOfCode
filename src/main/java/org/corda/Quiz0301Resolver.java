package org.corda;


import org.apache.commons.lang3.StringUtils;
import org.corda.model.DayTwoData;

import java.io.IOException;
import java.util.function.Function;
import java.util.function.Predicate;

public class Quiz0301Resolver implements QuizResolver {
    private QuizTemplateResolver quizTemplate;


    public Quiz0301Resolver(String fileName) {
        Predicate<DayTwoData> isOk = s -> true;
        Function<String, DayTwoData> parse = s -> null;
        quizTemplate = new QuizTemplateResolver( fileName, isOk, parse );
    }

    @Override
    public long resolve() throws IOException {
        return quizTemplate.resolve();
    }
    
}
