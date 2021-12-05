package org.corda.year2020.model;


public class HHInstruction {
    private HHMnemonic mnemo;

    public int getValue() {
        return value;
    }

    private int value;

    public HHMnemonic getMnemo() {
        return mnemo;
    }
    
    public HHInstruction(HHMnemonic mnemo, int value) {
        this.mnemo = mnemo;
        this.value = value;
    }
}
