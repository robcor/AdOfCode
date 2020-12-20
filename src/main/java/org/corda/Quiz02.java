package org.corda;

import org.corda.model.DayTwoData;

import java.util.function.Function;

public class Quiz02 {
    public Function<String, DayTwoData> getStringDayTwoDataFunction() {
        return s -> {
                // EXAMPLE
                // "4-10 m: mmmjmmmmmmmm"
                String[] mainParts = s.split( " " );
                // 0: 4-10
                String[] intPair = mainParts[0].split( "-" );
                int firstInt = Integer.parseInt( intPair[0] );
                int secondInt = Integer.parseInt( intPair[1] );
                // 1: m:
                String letter = String.valueOf( mainParts[1].charAt( 0 ) );
                // 2: mmmjmmmmmmmm
                String password = mainParts[2];


                return new DayTwoData( firstInt, secondInt, letter, password );
            };
    }
}
