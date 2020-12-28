import org.corda.helper.HHVirtualMachine;
import org.corda.helper.MachineStatus;
import org.corda.helper.ParseAssembly;
import org.corda.year2020.model.HHInstruction;
import org.corda.year2020.model.HHMnemonic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParserAssemblyTest {

    @Test
    void parseAssembly_nop() throws Exception {
        String toTest = "nop +0";

        ParseAssembly parser = new ParseAssembly( toTest );
        HHInstruction parsed = parser.parse();

        assertNotNull( parsed );
        assertEquals( HHMnemonic.NOP, parsed.getMnemo());
        assertEquals( 0, parsed.getValue());
    }

    @Test
    void parseAssembly_acc() throws Exception {
        String toTest = "acc +1";

        ParseAssembly parser = new ParseAssembly( toTest );
        HHInstruction parsed = parser.parse();

        assertNotNull( parsed );
        assertEquals( HHMnemonic.ACC, parsed.getMnemo());
        assertEquals( 1, parsed.getValue());
    }

    @Test
    void parseAssembly_jmp() throws Exception {
        String toTest = "jmp -2";

        ParseAssembly parser = new ParseAssembly( toTest );
        HHInstruction parsed = parser.parse();

        assertNotNull( parsed );
        assertEquals( HHMnemonic.JMP, parsed.getMnemo());
        assertEquals( -2, parsed.getValue());
    }

    @Test
    void virtualMachine_acc() throws Exception {
        String toTest = "acc +1";
        MachineStatus currentStatus = new MachineStatus( 0, 0 );
        ParseAssembly parser = new ParseAssembly( toTest );
        HHInstruction instruction = parser.parse();

        MachineStatus newStatus = HHVirtualMachine.execute( currentStatus, instruction );

        assertNotNull( newStatus );
        assertEquals( 1, newStatus.getLineNumber());
        assertEquals( 1, newStatus.getAcc());

    }

    @Test
    void virtualMachine_nop() throws Exception {
        String toTest = "nop +0";
        MachineStatus currentStatus = new MachineStatus( 0, 0 );
        ParseAssembly parser = new ParseAssembly( toTest );
        HHInstruction instruction = parser.parse();

        MachineStatus newStatus = HHVirtualMachine.execute( currentStatus, instruction );

        assertNotNull( newStatus );
        assertEquals( 1, newStatus.getLineNumber());
        assertEquals( 0, newStatus.getAcc());
    }

    @Test
    void virtualMachine_jmp() throws Exception {
        String toTest = "jmp +2";
        MachineStatus currentStatus = new MachineStatus( 0, 0 );
        ParseAssembly parser = new ParseAssembly( toTest );
        HHInstruction instruction = parser.parse();

        MachineStatus newStatus = HHVirtualMachine.execute( currentStatus, instruction );

        assertNotNull( newStatus );
        assertEquals( 2, newStatus.getLineNumber());
        assertEquals( 0, newStatus.getAcc());
    }

}
