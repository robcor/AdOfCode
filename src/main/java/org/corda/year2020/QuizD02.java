package org.corda.year2020;

import org.corda.helper.FileHelper;
import org.corda.model.Day02Data;

public abstract class QuizD02 extends Quiz<Day02Data, Object> {

    protected QuizD02(String fileName) {
        super( fileName , null, s -> FileHelper.readAllLines( s ) );
    }

    @Override
    public Day02Data parseInput(String input) {
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


        return new Day02Data( firstInt, secondInt, letter, password );
    }
}
