package org.corda;


import org.apache.commons.lang3.StringUtils;
import org.corda.model.DayTwoData;

import java.io.IOException;
import java.util.function.Function;
import java.util.function.Predicate;

public class Quiz0202Resolver extends Quiz02 implements QuizResolver  {
    private QuizTemplateResolver quizTemplate;


    public Quiz0202Resolver(String fileName) {
        Predicate<DayTwoData> isOk = s -> checkPassword( s );
        Function<String, DayTwoData> parse = getStringDayTwoDataFunction();
        quizTemplate = new QuizTemplateResolver( fileName, isOk, parse );
    }

    @Override
    public long resolve() throws IOException {
        return quizTemplate.resolve();
    }



    /*
    policy actually describes two positions in the password, where 1 means the first character, 2 means the second
    character, and so on. (Be careful; Toboggan Corporate Policies have no concept of "index zero"!)
    Exactly one of these positions must contain the given letter
     */
    public boolean checkPassword(DayTwoData data) {

        String first = String.valueOf( data.getPassword().charAt( data.getFirstInt() - 1 ) );
        String second = String.valueOf( data.getPassword().charAt( data.getSecondInt() - 1 ) );

        String letter = data.getLetter();
        return (letter.equals( first ) && !letter.equals( second )) || (!letter.equals( first ) && letter.equals( second ));

    }
}
