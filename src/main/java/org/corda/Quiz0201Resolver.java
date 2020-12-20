package org.corda;


import org.apache.commons.lang3.StringUtils;
import org.corda.model.DayTwoData;

public class Quiz0201Resolver extends Quiz<DayTwoData> implements QuizResolver {

    public Quiz0201Resolver(String fileName) {
        super( fileName );
    }

    @Override
    public boolean checkValue(DayTwoData data) {
        int count = StringUtils.countMatches( data.getPassword(), data.getLetter() );

        int minOccur = data.getFirstInt();
        int maxOccur = data.getSecondInt();
        return NumberHelper.isInRange( count, minOccur, maxOccur );
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
