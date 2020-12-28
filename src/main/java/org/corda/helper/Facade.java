package org.corda.helper;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

    public static List<Long> longFromFile(String fileName) throws IOException {
        List<String> stringList = FileHelper.readAllLines( fileName );

        List<Long> longList = NumberHelper.stringListToLongList( stringList );

        return longList;
    }
}
