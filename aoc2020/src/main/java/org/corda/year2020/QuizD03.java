package org.corda.year2020;

import org.corda.helper.FileHelper;
import org.corda.year2020.model.ConfigD03;
import org.corda.year2020.model.Day03Data;

public abstract class QuizD03 extends Quiz<Day03Data, ConfigD03> {

    static final String OPEN_SQUARE = ".";
    static final String TREE = "#";

    protected QuizD03(String fileName, ConfigD03 config) {
        super( fileName, config, s -> FileHelper.readAllLines( s ) );
    }

    @Override
    public Day03Data parseInput(String input) {
        return new Day03Data( input );
    }
}
