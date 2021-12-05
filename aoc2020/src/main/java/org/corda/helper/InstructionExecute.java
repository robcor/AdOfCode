package org.corda.helper;


public interface InstructionExecute {
    MachineStatus execute(MachineStatus status, int value);
}
