package org.corda.year2020;

import org.corda.helper.FileHelper;
import org.corda.helper.ParseBags;
import org.corda.model.BagPair;
import org.corda.model.BagRule;

import java.util.ArrayList;
import java.util.Collection;
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


        List<BagRule> mainRules = findBagRuleByMainBagName( mainBag );

        // start
        List<BagPair> allContainedBags = new ArrayList<>(  );

        List<BagPair> containedBags = recursiveContained( mainRules, allContainedBags );


        long numberOfBags = countBags( containedBags );


        return numberOfBags;
    }

    private List<BagPair> recursiveContained(List<BagRule> innerRules, List<BagPair> allContainedBags) {
        List<BagPair> containedBags = listOfContainedPair( innerRules  );
        List<BagRule> branchesRules = findRuleBranches(containedBags);

        if (branchesRules.size() > 0)
            recursiveContained(branchesRules, allContainedBags);

        allContainedBags.addAll( containedBags );
        return allContainedBags;
    }

    private long countBags(List<BagPair> containedBags) {

        return 0;
    }

    private List<BagPair> listOfContainedPair(List<BagRule> containerRules) {
        List<List<BagPair>> containedIntemediate = containerRules.stream()
            .map( x -> x.containedBags() )
            .collect( Collectors.toList() );
        List<BagPair> contained = containedIntemediate.stream()
            .flatMap( Collection::stream )
            .collect( Collectors.toList() );

        return contained;
    }


    public List<BagRule> findRuleBranches(List<BagPair> contained) {
        List<List<BagRule>> intermediate = contained.stream()
            .map( x -> findBagRuleByMainBagName( x.getBagName() ) )
            .collect( Collectors.toList() );
        List<BagRule> ruleList = intermediate.stream()
            .flatMap( Collection::stream )
            .collect( Collectors.toList() );

        return ruleList;
    }

    public List<BagRule> findBagRuleByMainBagName(String mainBag) {
        List<BagRule> ruleList = rules.stream()
            .filter( x -> mainBag.equals( x.containerBag() ) )
            .collect( Collectors.toList() );

        return ruleList;
    }
}

