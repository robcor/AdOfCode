package org.corda;

import org.corda.model.DayTwoData;

import java.util.function.Function;

public abstract class QuizD02 extends Quiz<DayTwoData> {

    public QuizD02(String fileName) {
        super( fileName );
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
