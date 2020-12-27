package org.corda.model;


public class BagPair {

    private final String bagName;
    private final String bagNumber;

    public BagPair(String bagName, String bagNumber) {
         this.bagName = bagName;
         this.bagNumber = bagNumber;
    }

    public String getBagName() {
        return bagName;
    }

    public String getBagNumber() {
        return bagNumber;
    }

    public int getBagNumberInt() {
        return Integer.parseInt( bagNumber );
    }

    @Override
    public String toString() {
        return "{" +
            "bagName:'" + bagName + '\'' +
            ", bagNumber:'" + bagNumber + '\'' +
            '}';
    }
}
