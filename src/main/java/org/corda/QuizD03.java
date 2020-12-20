package org.corda;

import org.corda.model.DayThreeData;

public abstract class QuizD03 extends Quiz<DayThreeData> {

    public QuizD03(String fileName) {
        super( fileName );
    }

    @Override
    public DayThreeData parseInput(String input) {
        return new DayThreeData( input );
    }
}
