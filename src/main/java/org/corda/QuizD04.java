package org.corda;

import org.corda.helper.FileHelper;
import org.corda.model.ConfigD03;
import org.corda.model.Day03Data;
import org.corda.model.Day04Data;

import java.util.List;
import java.util.function.Function;

public abstract class QuizD04 extends Quiz<Day04Data, Object>{
    public QuizD04(String fileName) {
        super( fileName, null, s -> FileHelper.readLinesDividedByCr( s ) );
    }


}
