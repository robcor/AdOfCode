package org.corda.year2020;


import org.corda.helper.StringHelper;
import org.corda.model.ConfigD03;
import org.corda.model.Day03Data;

public class QuizD0301Resolver extends QuizD03 {



    public QuizD0301Resolver(String fileName, ConfigD03 config) {
        super( fileName, config );
    }

    @Override
    public boolean checkValue(Day03Data data) {
        int position = (data.getSequence() * 3) % data.getInput().length();
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
