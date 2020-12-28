package org.corda.year2020;

import org.corda.year2020.helper.Facade;
import org.corda.year2020.helper.FileHelper;

import java.io.IOException;
import java.util.List;

public class QuizD0901Resolver {
    private final List<Long> lines;
    private int preambleSize;


    public QuizD0901Resolver(String fileName, int preambleSize) throws IOException {
        List<String> rawLines = FileHelper.readAllLines( fileName );

        lines = Facade.longFromFile( fileName );

        this.preambleSize = preambleSize;
    }

    public long resolve() {
        Long valueToCheck = -1l;
        for (int i = 0; i < lines.size(); i++) {
            int valueIndex = i + preambleSize;
            valueToCheck = lines.get( valueIndex );
            if (!thereASum( valueToCheck, lines, i, preambleSize )) {
                break;
            }
        }

        return valueToCheck.longValue();
    }

    public static boolean thereASum(long value, List<Long> intList, int startIndex, int preambleSize) {

        for (int i = startIndex; i < preambleSize + startIndex; i++) {
            for (int j = i + 1; j < preambleSize + startIndex; j++) {
                long sum = intList.get( i ) + intList.get( j );

                if (sum == value)
                    return true;
            }
        }

        return false;
    }
}
