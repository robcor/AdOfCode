package org.corda.year2020.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberHelper {


    private NumberHelper() {
        throw new IllegalStateException( "Utility class" );
    }

    public static List<Integer> stringListToInteger(List<String> stringList) {
        List<Integer> intList = new ArrayList<>();
        stringList.stream().forEach( s -> intList.add( Integer.parseInt( s ) ) );

        return intList;
    }

    public static int[] stringListToIntArray(List<String> stringList) {
        int[] intArray = stringList.stream().mapToInt( s -> Integer.parseInt( s ) ).toArray();

        return intArray;
    }

    public static List<Long> stringListToLongList(List<String> stringList) {
        List<Long> longList = stringList.stream()
            .map( s -> Long.parseLong( s ) )
            .collect( Collectors.toList() );

        return longList;
    }

    public static boolean isInRange(int value, int minValue, int maxValue) {
        return value >= minValue && value <= maxValue;
    }
}
