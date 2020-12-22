package org.corda.helper;


public class StringHelper {

    private StringHelper() {
        throw new IllegalStateException( "Utility class" );
    }

    // WARN first letter position is 1 not 0
    public static String getLetterAt(String value, int position) {
        return String.valueOf( value.charAt( position - 1 ) );
    }

    public static String getLetterAtStandard(String value, int position) {
        return String.valueOf( value.charAt( position ) );
    }

    public static boolean isNull(Object value) {
        if (value == null) {
            return true;
        }
        return false;
    }
}
