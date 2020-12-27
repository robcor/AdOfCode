package org.corda.year2020.helper;


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

    public static String[] splitAt(String s, int where) {

        String first = s.substring( 0, where );
        String second = s.substring( where );

        String[] result = new String[2];
        result[0] = first;
        result[1] = second;

        return result;
    }

    public static int howManyDigitPrefix(String str) {

        if (!Character.isDigit( str.charAt( 0 ) )) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit( str.charAt( i ) )) {
                count++;
            } else {
                break;
            }
        }
        return count;

    }
}
