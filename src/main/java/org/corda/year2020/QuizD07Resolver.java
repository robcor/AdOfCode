package org.corda.year2020;

import org.corda.helper.FileHelper;
import org.corda.helper.ParseBags;
import org.corda.model.BagRule;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class QuizD07Resolver {
    private final String filename;
    List<BagRule> rules;

    public QuizD07Resolver(String fileName) {
        this.filename = fileName;


        List<String> lines = FileHelper.readAllLines( fileName );

        this.rules = lines.stream()
            .map( x -> {
                ParseBags parser = new ParseBags( x );
                return parser.parse();
            } )
            .collect( Collectors.toList() );
    }


    public long resolve(String mainBag) {

        Set<String> containedBy = findContainedBy( mainBag );


        return 0;
    }

    public Set<String> findContainedBy(String mainBag) {

        Set<String> containedBy = rules.stream()
            .filter( x -> {
                boolean contain = x.contains( mainBag );
                return contain;
            } )
            .map( x -> x.containerBag() )
            .collect( Collectors.toSet() );

        return containedBy;
    }
}

