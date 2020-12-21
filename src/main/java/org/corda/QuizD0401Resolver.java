package org.corda;

import org.apache.commons.lang3.StringUtils;
import org.corda.model.Day04Data;

import java.util.Arrays;
import java.util.HashMap;

public class QuizD0401Resolver extends Quiz<Day04Data, Object> {
    public QuizD0401Resolver(String fileName, Object config) {
        super( fileName, config );
    }

    public QuizD0401Resolver(String fileName) {
        super( fileName, null );
    }

    @Override
    public boolean checkValue(Day04Data data) {


        if (data == null) {
            return false;
        }

        if (data.getByr() != null &&
            data.getEcl() != null &&
            data.getEyr() != null &&
            data.getHcl() != null &&
            data.getHgt() != null &&
            data.getIyr() != null &&
            data.getPid() != null
        ) {
            return true;
        } else {
            return false;
        }
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
