package org.corda;


import org.apache.commons.lang3.StringUtils;
import org.corda.helper.NumberHelper;
import org.corda.model.Day02Data;

public class QuizD0201Resolver extends QuizD02 {

    public QuizD0201Resolver(String fileName) {
        super( fileName );
    }

    @Override
    public boolean checkValue(Day02Data data) {
        int count = StringUtils.countMatches( data.getPassword(), data.getLetter() );

        int minOccur = data.getFirstInt();
        int maxOccur = data.getSecondInt();
        return NumberHelper.isInRange( count, minOccur, maxOccur );
    }

}
