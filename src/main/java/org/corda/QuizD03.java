package org.corda;

import org.corda.model.ConfigD03;
import org.corda.model.DayThreeData;

public abstract class QuizD03 extends Quiz<DayThreeData, ConfigD03> {

    static final String OPEN_SQUARE = ".";
    static final String TREE = "#";

    protected QuizD03(String fileName, ConfigD03 config) {
        super( fileName, config);
    }

    @Override
    public DayThreeData parseInput(String input) {
        return new DayThreeData( input );
    }
}
