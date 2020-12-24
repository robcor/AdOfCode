package org.corda.helper;

import org.corda.model.FlightPosition;

public class MathHelper {
    private MathHelper() {
        throw new IllegalStateException( "Utility class" );
    }

    public static FlightPosition flightCodeToPosition(String inputCode) {

        //BFFFBBFRRR: row 70, column 7, seat ID 567.
        String rowStr = inputCode.substring( 0, 7 );
        String columnStr = inputCode.substring( 7 );


        return new FlightPosition(70, 7, 567);
    }
}
