package org.corda;


import org.corda.helper.StringHelper;
import org.corda.model.DayThreeData;

public class QuizD0301Resolver extends QuizD03 {

    private static final String OPEN_SQUARE = ".";
    private static final String TREE = "#";

    public QuizD0301Resolver(String fileName) {
        super( fileName );
    }

    @Override
    public boolean checkValue(DayThreeData data) {
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
