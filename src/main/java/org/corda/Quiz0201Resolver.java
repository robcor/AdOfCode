package org.corda;


import org.apache.commons.lang3.StringUtils;
import org.corda.model.DayTwoData;

import java.io.IOException;
import java.util.function.Function;
import java.util.function.Predicate;

public class Quiz0201Resolver extends Quiz02 implements QuizResolver {
    private QuizTemplateResolver quizTemplate;


    public Quiz0201Resolver(String fileName) {
        Predicate<DayTwoData> isOk = s -> checkPassword( s );
        Function<String, DayTwoData> parse = getStringDayTwoDataFunction();
        quizTemplate = new QuizTemplateResolver( fileName, isOk, parse );
    }

    @Override
    public long resolve() throws IOException {
        return quizTemplate.resolve();
    }

    public boolean checkPassword(DayTwoData data) {

        int count = StringUtils.countMatches( data.getPassword(), data.getLetter() );

        int minOccur = data.getFirstInt();
        int maxOccur = data.getSecondInt();
        return NumberHelper.isInRange( count, minOccur, maxOccur );

    }
}
