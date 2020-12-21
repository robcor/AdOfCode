package org.corda.model;


public class Day02Data extends Numerable {
    private int firstInt;
    private int secondInt;
    private String letter;
    private String password;


    public Day02Data(int firstInt, int secondInt, String letter, String password) {
        this.firstInt = firstInt;
        this.secondInt = secondInt;
        this.letter = letter;
        this.password = password;
    }

    public int getFirstInt() {
        return firstInt;
    }

    public int getSecondInt() {
        return secondInt;
    }

    public String getLetter() {
        return letter;
    }

    public String getPassword() {
        return password;
    }
}
