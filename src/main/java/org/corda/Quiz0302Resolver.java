package org.corda;


import org.corda.model.DayThreeData;

public class Quiz0302Resolver extends Quiz<DayThreeData> {

    public Quiz0302Resolver(String fileName) {
        super( fileName );
    }


    @Override
    public boolean checkValue(DayThreeData data) {
        return false;
    }

    @Override
    public DayThreeData parseInput(String input) {
        return new DayThreeData( input );
    }
}
