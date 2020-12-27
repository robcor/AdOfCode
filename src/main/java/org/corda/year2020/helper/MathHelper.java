package org.corda.year2020.helper;

import org.corda.year2020.model.FlightPosition;

public class MathHelper {
    private MathHelper() {
        throw new IllegalStateException( "Utility class" );
    }

    public static FlightPosition flightCodeToPosition(String inputCode) {

        //BFFFBBFRRR: row 70, column 7, seat ID 567.
        String rowStr = inputCode.substring( 0, 7 );
        String columnStr = inputCode.substring( 7 );
        int rowPosition = toPosition( rowStr, 'F', 'B', 127 );
        int colPosition = toPosition( columnStr, 'L', 'R', 7 );

        int id = rowPosition*8 + colPosition;


        return new FlightPosition( rowPosition, colPosition, id );
    }

    public static int toPosition(final String code, final char lowCode, final char highCode, final int maxValue) {
        int lowPosition = 0;
        int highPosition = maxValue;
        for (int i = 0; i < code.length(); i++) {
            char charAt = code.charAt( i );
            boolean isLow = isLow( charAt, lowCode );
            int middlePosition = calculateMiddlePosition( lowPosition, highPosition, isLow );

            if (isLow) {
                highPosition = middlePosition;
            } else {
                lowPosition = middlePosition;
            }
        }

        // WARN highPosition and  lowPosition should be equals
        return lowPosition;
    }

    public static int calculateMiddlePosition(int lowPosition, int highPosition, boolean isLow) {

        int lowValue = calculateMiddlePositionLow( lowPosition, highPosition );
        if (!isLow) return lowValue + 1;

        return lowValue;
    }

    public static int calculateMiddlePositionLow(int lowPosition, int highPosition) {
        return Math.floorDiv( lowPosition + highPosition, 2 );
    }

    public static boolean isLow(final char charAt, final char lowChar) {
        return charAt == lowChar;
    }

}
