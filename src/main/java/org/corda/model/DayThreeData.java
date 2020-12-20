package org.corda.model;


import org.corda.Numerable;

public class DayThreeData extends Numerable {
    public String getInput() {
        return input;
    }

    private String input;

    public DayThreeData(String input) {
        this.input = input;
    }


}
