package org.corda.year2020.helper;


public class MachineStatus {
    int lineNumber;
    int acc;

    public MachineStatus(int lineNumber, int acc) {
        this.lineNumber = lineNumber;
        this.acc = acc;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getAcc() {
        return acc;
    }
}
