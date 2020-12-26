package org.corda.model;


public class BagNameValue {

    private final String bagName;
    private final String bagNumber;

    public BagNameValue(String bagName, String bagNumber) {
         this.bagName = bagName;
         this.bagNumber = bagNumber;
    }

    public String getBagName() {
        return bagName;
    }

    public String getBagNumber() {
        return bagNumber;
    }
}
