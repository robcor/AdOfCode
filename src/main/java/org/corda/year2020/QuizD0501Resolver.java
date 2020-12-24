package org.corda.year2020;


import org.corda.helper.FileHelper;
import org.corda.helper.MathHelper;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class QuizD0501Resolver {


    private final String filename;

    public QuizD0501Resolver(String fileName) {
        this.filename = fileName;
    }

    public long maxValue() {

        List<String> lines = FileHelper.readAllLines( filename );

        Comparator<? super Integer> comparator = Integer::compareTo;
        Optional<Integer> maxValue = lines.stream()
            .map( l -> MathHelper.flightCodeToPosition( l ).getId() )
            .max( comparator );
        return maxValue.get();
    }
}
