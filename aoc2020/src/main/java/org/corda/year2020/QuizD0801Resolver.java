package org.corda.year2020;

import org.corda.helper.HHVirtualMachine;
import org.corda.helper.MachineStatus;

import java.util.List;

public class QuizD0801Resolver {

    private final HHVirtualMachine vm;

    public QuizD0801Resolver(String fileName) {
        vm = new HHVirtualMachine(fileName);
    }

    public long resolve() {
        List<MachineStatus> result = vm.runStopOnDuplicate();

        MachineStatus lastStatus = result.get( result.size() - 1 );
        return lastStatus.getAcc();
    }
}
