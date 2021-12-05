package org.corda.helper;


import org.corda.year2020.model.HHInstruction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HHVirtualMachine {
    private final List<HHInstruction> instructionList;
    String fileInput;


    public HHVirtualMachine(String fileInput) {
        this.fileInput = fileInput;

        List<String> lines = FileHelper.readAllLines( fileInput );

        this.instructionList = lines.stream()
            .map( x -> {
                ParseAssembly parser = new ParseAssembly( x );
                return parser.parse();
            } )
            .collect( Collectors.toList() );
    }

    private HHVirtualMachine(List<HHInstruction> instructionList) {
        this.instructionList = new ArrayList<>(  instructionList);
    }

    public List<MachineStatus> runStopOnDuplicate() {
        List<MachineStatus> statusHistory = new ArrayList<>();
        Set<Integer> lineNumberHistory = new HashSet<>();
        MachineStatus currentStatus = new MachineStatus( 0, 0 );
        lineNumberHistory.add( 0 );
        statusHistory.add( currentStatus );

        MachineStatus newStatus = null;
        do {
            newStatus = execute( currentStatus );
            currentStatus = newStatus;
            statusHistory.add( newStatus );
        } while (
            lineNumberNotAlreadyPresent( lineNumberHistory, newStatus ) &&
            isInLinesRange( newStatus ));

        return statusHistory;
    }

    public int linesSize() {
        return instructionList.size();
    }

    private boolean isInLinesRange(MachineStatus newStatus) {
        int lineNumber = newStatus.lineNumber;
        int size = instructionList.size();

        return lineNumber < size;
    }

    public MachineStatus execute(MachineStatus currentStatus) {
        HHInstruction instr = instructionList.get( currentStatus.getLineNumber() );
        return execute( currentStatus, instr );
    }

    public static MachineStatus execute(MachineStatus currentStatus, HHInstruction instr) {
        MachineStatus newStatus = instr.getMnemo().execute( currentStatus, instr.getValue() );
        return newStatus;
    }

    private boolean lineNumberNotAlreadyPresent(Set<Integer> lineNumberHistory, MachineStatus newStatus) {
        boolean result;
        int lineNumber = newStatus.getLineNumber();
        if (lineNumberHistory.contains( lineNumber )) {
            result = false;
        } else {
            result = true;
        }
        lineNumberHistory.add( lineNumber ) ;
        return result;
    }

    public HHVirtualMachine duplicate() {
        return new HHVirtualMachine(this.instructionList);
    }

    public HHInstruction getLine(int i) {
        return instructionList.get( i );
    }

    public void setLine(HHInstruction instructionNew, int i) {
        instructionList.set( i , instructionNew);
    }
}
