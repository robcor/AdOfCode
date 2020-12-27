package org.corda.year2020;

import org.corda.year2020.helper.HHVirtualMachine;
import org.corda.year2020.helper.MachineStatus;
import org.corda.year2020.model.HHInstruction;
import org.corda.year2020.model.HHMnemonic;

import java.util.List;

public class QuizD0802Resolver {

    private final HHVirtualMachine vm;

    public QuizD0802Resolver(String fileName) {
        vm = new HHVirtualMachine( fileName );
    }

    public long resolve() {

        MachineStatus lastStatus = null;
        for (int i = 0; i < vm.linesSize(); i++) {

            HHVirtualMachine vmModified = vm.duplicate();
            swapVmLine( vmModified, i );

            List<MachineStatus> result = vmModified.runStopOnDuplicate();
            lastStatus = getLastStatus( result );

            if (lastStatus.getLineNumber() >= vm.linesSize())
                break;
        }

        return lastStatus.getAcc();
    }

    private void swapVmLine(HHVirtualMachine vm, int i) {
        HHInstruction instructionOrig = vm.getLine( i );

        HHInstruction instructionNew = null;
        if (instructionOrig.getMnemo() == HHMnemonic.JMP) {
            instructionNew = new HHInstruction( HHMnemonic.NOP, instructionOrig.getValue() );
        } else if (instructionOrig.getMnemo() == HHMnemonic.NOP) {
            instructionNew = new HHInstruction( HHMnemonic.JMP, instructionOrig.getValue() );
        }  else {
            instructionNew = new HHInstruction( instructionOrig.getMnemo(), instructionOrig.getValue() );
        }
        vm.setLine( instructionNew, i );
    }

    private MachineStatus getLastStatus(List<MachineStatus> result) {
        return result.get( result.size() - 1 );
    }
}
