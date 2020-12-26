package org.corda.year2020;

import org.corda.helper.FileHelper;
import org.corda.helper.ParseBags;
import org.corda.model.BagRule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class QuizD0702Resolver {
    List<BagRule> rules;

    public QuizD0702Resolver(String fileName) {


        List<String> lines = FileHelper.readAllLines( fileName );

        this.rules = lines.stream()
            .map( x -> {
                ParseBags parser = new ParseBags( x );
                return parser.parse();
            } )
            .collect( Collectors.toList() );
    }


    public long resolve(String mainBag) {


        Set<String> alreadyChecked = new HashSet<>();

        Set<String> contains = findContains( mainBag );

        recursiveSearchContains( alreadyChecked, contains );

        return contains.size();
    }

    private void recursiveSearchContains(Set<String> alreadyChecked, Set<String> containedBy) {
        Set<String> newContained = new HashSet<>();
        containedBy.stream().forEach( x -> {
            if (!alreadyChecked.contains( x )) {
                newContained.addAll( findContains( x ) );
                alreadyChecked.add( x );

            }
        } );

        containedBy.addAll( newContained );
        if (!alreadyChecked.equals( containedBy )) {
            recursiveSearchContains( alreadyChecked, containedBy );
        }
    }

    public Set<String> findContains(String mainBag) {

        Set<String> containedBy = rules.stream()
            .filter( x -> mainBag.equals( x.containerBag() ) )
            .map( x -> x.containerBag() )
            .collect( Collectors.toSet() );

        return containedBy;
    }
}

