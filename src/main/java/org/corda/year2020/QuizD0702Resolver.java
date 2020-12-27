package org.corda.year2020;

import org.corda.year2020.helper.FileHelper;
import org.corda.year2020.helper.ParseBags;
import org.corda.year2020.model.BagPair;
import org.corda.year2020.model.BagRule;

import java.util.List;
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
        int sum = recursiveContained( mainBag);

        return sum -1;
    }

    private int recursiveContained(String outerBagName) {

        int sum = 0;
        List<BagRule> outerRules = findBagRuleByBagName( outerBagName );

        if (outerRules.size() > 0)  {
            for (BagRule curRule : outerRules) {
                List<BagPair> pairList = curRule.containedPair();
                if (pairList.size() > 0) {
                    for (BagPair curPair : pairList) {
                       sum = sum +   curPair.getBagNumberInt() * recursiveContained(curPair.getBagName());
                    }
                }
            }
        }
        return sum + 1;
    }



    public List<BagRule> findBagRuleByBagName(String bagName) {
        List<BagRule> ruleList = rules.stream()
            .filter( x -> bagName.equals( x.containerBag() ) )
            .collect( Collectors.toList() );

        return ruleList;
    }
}

