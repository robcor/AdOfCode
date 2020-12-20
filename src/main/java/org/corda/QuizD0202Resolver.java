package org.corda;


import org.corda.model.DayTwoData;

public class QuizD0202Resolver extends QuizD02 {
    private QuizTemplateResolver quizTemplate;


    public QuizD0202Resolver(String fileName) {
        super( fileName );
    }

    /*
    policy actually describes two positions in the password, where 1 means the first character, 2 means the second
    character, and so on. (Be careful; Toboggan Corporate Policies have no concept of "index zero"!)
    Exactly one of these positions must contain the given letter
     */
    @Override
    public boolean checkValue(DayTwoData data) {
        String first = String.valueOf( data.getPassword().charAt( data.getFirstInt() - 1 ) );
        String second = String.valueOf( data.getPassword().charAt( data.getSecondInt() - 1 ) );

        String letter = data.getLetter();
        return (letter.equals( first ) && !letter.equals( second )) || (!letter.equals( first ) && letter.equals( second ));
    }


}
