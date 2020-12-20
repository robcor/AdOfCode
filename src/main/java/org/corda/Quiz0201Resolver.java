package org.corda;


import org.apache.commons.lang3.StringUtils;
import org.corda.model.DayTwoData;

public class Quiz0201Resolver extends Quiz02  {

    public Quiz0201Resolver(String fileName) {
        super( fileName );
    }

    @Override
    public boolean checkValue(DayTwoData data) {
        int count = StringUtils.countMatches( data.getPassword(), data.getLetter() );

        int minOccur = data.getFirstInt();
        int maxOccur = data.getSecondInt();
        return NumberHelper.isInRange( count, minOccur, maxOccur );
    }

}
