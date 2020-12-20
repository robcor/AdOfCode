package org.corda;


import org.corda.model.DayTwoData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Facade {

    private Facade() {
        throw new IllegalStateException( "Utility class" );
    }

    public static int[] sortedIntFromFile(String fileName) throws IOException {
        List<String> stringList = FileHelper.readAllLines( fileName );

        int[] intArray = NumberHelper.stringListToIntArray( stringList );

        Arrays.sort( intArray );

        return intArray;
    }

    public static List<DayTwoData> loadDayTwoStructList(String fileName) throws IOException {

        Function<String, DayTwoData> parse = s -> {
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

        List<String> stringList = FileHelper.readAllLines( fileName );

        List<DayTwoData> result = stringList.stream()
            .map( s -> parse.apply( s ) )
            .collect( Collectors.toList() );

        return result;
    }


}
