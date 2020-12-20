package org.corda;

import org.corda.model.DayThreeData;

public abstract class Quiz03 extends Quiz<DayThreeData> {

    public Quiz03(String fileName) {
        super( fileName );
    }

    @Override
    public DayThreeData parseInput(String input) {
        return new DayThreeData( input );
    }
}
