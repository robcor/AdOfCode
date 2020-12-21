package org.corda.model;


import java.util.Map;

/*
byr (Birth Year)
iyr (Issue Year)
eyr (Expiration Year)
hgt (Height)
hcl (Hair Color)
ecl (Eye Color)
pid (Passport ID)
cid (Country ID)
*/
public class Day04Data extends Numerable {

    public static final String BYR = "byr";
    public static final String IYR = "iyr";
    public static final String EYR = "eyr";
    public static final String HGT = "hgt";
    public static final String HCL = "hcl";
    public static final String ECL = "ecl";
    public static final String PID = "pid";
    public static final String CID = "cid";



    private Map<String, String> innerValue;

    public Day04Data(Map<String, String> valueMap) {
        innerValue = valueMap;
    }

    public String getByr() {
        return innerValue.get( BYR );
    }

    public String getIyr() {
        return innerValue.get( IYR );
    }

    public String getEyr() {
        return innerValue.get( EYR );
    }

    public String getHgt() {
        return innerValue.get( HGT );
    }

    public String getHcl() {
        return innerValue.get( HCL );
    }

    public String getEcl() {
        return innerValue.get( ECL );
    }

    public String getPid() {
        return innerValue.get( PID );
    }

    public String getCid() {
        return innerValue.get( CID );
    }


}
