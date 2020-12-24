package org.corda.helper;


import org.corda.helper.FileHelper;
import org.corda.helper.NumberHelper;

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
}
