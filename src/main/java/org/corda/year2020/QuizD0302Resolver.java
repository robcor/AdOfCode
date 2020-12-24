package org.corda.year2020;


import org.corda.helper.StringHelper;
import org.corda.model.ConfigD03;
import org.corda.model.Day03Data;

public class QuizD0302Resolver extends QuizD03 {

    public QuizD0302Resolver(String fileName, ConfigD03 config) {
        super( fileName, config );
    }

    @Override
    public boolean checkValue(Day03Data data) {

        // ycheck
        if (data.getSequence() % config.getyDelta() != 0) {
            return false;
        }

        // xcheck
        int position = ((data.getSequence()/config.getyDelta()) * config.getxDelta()) % data.getInput().length();
        String letter = StringHelper.getLetterAtStandard( data.getInput(), position );

        if (OPEN_SQUARE.equals( letter )) {
            return false;
        } else if (TREE.equals( letter )) {
            return true;
        } else {
            throw new IllegalArgumentException( "value is:" + letter );
        }
    }
}
