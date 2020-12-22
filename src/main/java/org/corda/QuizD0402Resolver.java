package org.corda;


import org.apache.commons.lang3.StringUtils;
import org.corda.model.Day04Data;
import static org.corda.helper.NumberHelper.isInRange;
import static org.corda.helper.StringHelper.isNull;

public class QuizD0402Resolver extends QuizD04 {

    public static final String CM = "cm";
    public static final String INCH = "in";

    public QuizD0402Resolver(String fileName) {
        super( fileName );
    }

    @Override
    public boolean checkValue(Day04Data data) {

        if (isNull( data )) return false;

        if (isValidByr( data.getByr() ) &&
            isValidEcl( data.getEcl() ) &&
            isValidEyr( data.getEyr() ) &&
            isValidHcl( data.getHcl() ) &&
            isValidHgt( data.getHgt() ) &&
            isValidIyr( data.getIyr() ) &&
            isValidPid( data.getPid() )
        ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidByr(String byr) {

        if (isNull( byr )) return false;

        int value = Integer.parseInt( byr );

        return isInRange( value, 1920, 2002 );
    }

    public boolean isValidEcl(String ecl) {

        if (isNull( ecl )) return false;
        return false;
    }




    //hgt (Height) - a number followed by either cm or in:
    //If cm, the number must be at least 150 and at most 193.
    //If in, the number must be at least 59 and at most 76.
    public boolean isValidHgt(String hgt) {

        if (isNull( hgt )) return false;

        int howManyDigit = howManyDigitPrefix( hgt );

        if (howManyDigit == 0) return false;

        String[] splitted = splitAt( hgt, howManyDigit );

        int value = Integer.parseInt( splitted[0] );
        String lenType = splitted[1];
        if (isCm( lenType )) {
            return isInRange( value, 150, 193 );
        } else if (isInch( lenType )) {
            return isInRange( value, 59, 76 );
        } else {
            return false;
        }

    }






    //iyr (Issue Year) - four digits; at least 2010 and at most 2020.
    public boolean isValidIyr(String iyr) {

        if (isNull( iyr )) return false;
        int value = Integer.parseInt( iyr );

        return isInRange( value, 2010, 2020 );
    }

    //eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
    public boolean isValidEyr(String eyr) {

        if (isNull( eyr )) return false;
        int value = Integer.parseInt( eyr );

        return isInRange( value, 2020, 2030 );
    }

    //hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
    public boolean isValidHcl(String hcl) {

        if (isNull( hcl )) return false;

        if('#' != hcl.charAt( 0 )) return false;
        String color = splitAt( hcl, 1 )[1];

        if (color.length() != 6) return false;

        if (!StringUtils.isAlphanumeric( color )) return false;

        return true;
    }

    public boolean isValidPid(String pid) {

        if (isNull( pid )) return false;
        return false;
    }

    // private

    private boolean isCm(String anObject) {
        return CM.equals( anObject );
    }

    private boolean isInch(String anObject) {
        return INCH.equals( anObject );
    }

    private String[] splitAt(String s, int where) {

        String first = s.substring( 0, where );
        String second = s.substring( where );

        String[] result = new String[2];
        result[0] = first;
        result[1] = second;


        return result;

    }

    private int howManyDigitPrefix(String str) {

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
