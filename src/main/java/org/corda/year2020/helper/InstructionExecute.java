package org.corda.year2020.helper;


public interface InstructionExecute {
    MachineStatus execute(MachineStatus status, int value);
}
