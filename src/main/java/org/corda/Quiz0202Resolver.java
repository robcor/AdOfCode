package org.corda;


import org.corda.model.DayTwoData;

public class Quiz0202Resolver extends Quiz<DayTwoData> {
    private QuizTemplateResolver quizTemplate;


    public Quiz0202Resolver(String fileName) {
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

    @Override
    public DayTwoData parseInput(String input) {
        // EXAMPLE
        // "4-10 m: mmmjmmmmmmmm"
        String[] mainParts = input.split( " " );
        // 0: 4-10
        String[] intPair = mainParts[0].split( "-" );
        int firstInt = Integer.parseInt( intPair[0] );
        int secondInt = Integer.parseInt( intPair[1] );
        // 1: m:
        String letter = String.valueOf( mainParts[1].charAt( 0 ) );
        // 2: mmmjmmmmmmmm
        String password = mainParts[2];


        return new DayTwoData( firstInt, secondInt, letter, password );
    }

}
