package org.corda.year2020;


import org.corda.year2020.helper.FileHelper;
import org.corda.year2020.helper.MathHelper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuizD05Resolver {


    private final String filename;

    public QuizD05Resolver(String fileName) {
        this.filename = fileName;
    }

    public long maxValue() {

        List<String> lines = loadLines();

        Comparator<? super Integer> comparator = Integer::compareTo;
        Optional<Integer> maxValue = lines.stream()
            .map( l -> MathHelper.flightCodeToPosition( l ).getId() )
            .max( comparator );
        return maxValue.get();
    }

    public List notPresent() {
        List<Integer> presentList = presentList();

        List<Integer> notPresentList = new ArrayList<>();
        IntStream rangeStream = IntStream.range( 0, 1023 );
        rangeStream.asLongStream().forEach( x -> {
            int intValue = ((Long) x).intValue();
            if (!presentList.contains( intValue )) {
                notPresentList.add( intValue );
            }
        } );

        notPresentList.stream().sorted();

        return notPresentList;
    }

    private List<Integer> presentList() {
        List<String> lines = loadLines();


        return lines.stream()
            .map( l -> MathHelper.flightCodeToPosition( l ).getId() )
            .collect( Collectors.toList() );
    }


    public int resolve() {
        List<Integer> notPresent = notPresent();
        List<Integer> presentList = presentList();

        List<Integer> resultList = notPresent.stream()
            .filter( x -> {
                return (presentList.contains( x + 1 ) && presentList.contains( x - 1 ));
            } )
            .collect( Collectors.toList() );
        ;

        return  resultList.get(0);
    }

    private List<String> loadLines() {
        return FileHelper.readAllLines( filename );
    }


}
