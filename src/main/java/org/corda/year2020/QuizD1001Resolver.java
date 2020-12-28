package org.corda.year2020;

import org.corda.exception.AdventIllegalState;
import org.corda.helper.Facade;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class QuizD1001Resolver {
    private final List<Long> valuesList;

    public QuizD1001Resolver(String fileName) throws IOException {
        valuesList = Facade.longFromFile( fileName );
        Collections.sort( this.valuesList );
    }

    public long resolve() {
        long formerValue = 0;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (long value : valuesList) {
            long delta = value - formerValue;

            formerValue = value;
            if (delta == 1) {
                sum1++;
            } else if (delta == 2) {
                sum2++;
            } else if (delta == 3) {
                sum3++;
            } else {
                throw new AdventIllegalState( "delta not in 1,2,3: " + delta );
            }
        }

        return sum1 * (sum3+1);
    }
}
