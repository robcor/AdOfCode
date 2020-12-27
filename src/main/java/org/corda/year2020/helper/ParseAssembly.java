package org.corda.year2020.helper;


import org.corda.exception.AdventParseException;
import org.corda.year2020.model.HHInstruction;
import org.corda.year2020.model.HHMnemonic;

public class ParseAssembly {

    // fields
    private final String[] rawToken;
    private int counter;


    public ParseAssembly(String input) {
        this.rawToken = input.split( " " );
        this.counter = -1;
    }

    // EXAMPLE
    /*
    nop +0
    acc +1
    jmp +4
    */
    public HHInstruction parse() {
        HHMnemonic mnemo = getMnemo();
        int value = getValue();

        HHInstruction instruction = new HHInstruction( mnemo, value );

        return instruction;
    }

    private int getValue() {
        String next = next();
        return Integer.parseInt( next );
    }

    private HHMnemonic getMnemo() {
        String mnemoStr = next();

        HHMnemonic mnemo = null;

        switch(mnemoStr) {
            case "acc":
                mnemo = HHMnemonic.ACC;
                break;
            case "jmp":
                mnemo = HHMnemonic.JMP;
                break;
            case "nop":
                mnemo = HHMnemonic.NOP;
                break;
            default:
                throw  new AdventParseException( "mnemonic does't exist:" +  mnemoStr);

        }

        return mnemo;
    }

    private String next() {
        counter++;

        if (counter < rawToken.length) {
            return rawToken[counter];
        }

        throw new AdventParseException( "no more assembly tokens" );
    }

}
