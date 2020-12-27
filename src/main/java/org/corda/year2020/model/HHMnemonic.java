package org.corda.year2020.model;

import org.corda.year2020.helper.InstructionExecute;
import org.corda.year2020.helper.MachineStatus;

public enum HHMnemonic implements InstructionExecute {
    NOP {
        @Override
        public MachineStatus execute(MachineStatus status, int value) {
            return new MachineStatus( status.getLineNumber() + 1,  status.getAcc());
        }
    },
    JMP {
        @Override
        public MachineStatus execute(MachineStatus status, int value) {
            return new MachineStatus( status.getLineNumber() + value,  status.getAcc());
        }
    } ,
    ACC {
        @Override
        public MachineStatus execute(MachineStatus status, int value) {
            return new MachineStatus( status.getLineNumber() + 1,  status.getAcc() + value);
        }
    }
}
