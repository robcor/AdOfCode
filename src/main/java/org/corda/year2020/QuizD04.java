package org.corda.year2020;

import org.apache.commons.lang3.StringUtils;
import org.corda.helper.FileHelper;
import org.corda.year2020.model.Day04Data;

import java.util.Arrays;
import java.util.HashMap;

public abstract class QuizD04 extends Quiz<Day04Data, Object>{
    public QuizD04(String fileName) {
        super( fileName, null, s -> FileHelper.readLinesDividedByCr( s ) );
    }


    @Override
    public Day04Data parseInput(String input) {

        if (StringUtils.trimToNull(input) == null) {
            return null;
        }

        String[] splitByBlank = input.split( " " );

        HashMap<String, String> valueMap = new HashMap<>();
        Arrays.stream( splitByBlank )
            .forEach( s -> {
                String[] valuePair = s.split( ":" );
                valueMap.put( valuePair[0], valuePair[1] );
            } );

        return new Day04Data( valueMap );

    }
}
