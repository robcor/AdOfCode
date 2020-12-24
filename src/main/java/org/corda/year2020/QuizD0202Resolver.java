package org.corda.year2020;


import org.corda.helper.StringHelper;
import org.corda.model.Day02Data;

public class QuizD0202Resolver extends QuizD02 {
    private QuizCounterTemplateResolver quizTemplate;


    public QuizD0202Resolver(String fileName) {
        super( fileName);
    }

    /*
    policy actually describes two positions in the password, where 1 means the first character, 2 means the second
    character, and so on. (Be careful; Toboggan Corporate Policies have no concept of "index zero"!)
    Exactly one of these positions must contain the given letter
     */
    @Override
    public boolean checkValue(Day02Data data) {
        int firstPosition = data.getFirstInt();
        String first = StringHelper.getLetterAt( data.getPassword(), firstPosition );
        int secondPosition = data.getSecondInt();
        String second = StringHelper.getLetterAt( data.getPassword(), secondPosition );

        String letter = data.getLetter();
        return (letter.equals( first ) && !letter.equals( second )) || (!letter.equals( first ) && letter.equals( second ));
    }

}
