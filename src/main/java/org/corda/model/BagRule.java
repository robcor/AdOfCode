package org.corda.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BagRule {
    private final List<BagsToken> tokens;
    private int counter = 1;
    private List<BagPair> nameValueList;

    public BagRule(List<BagsToken> tokens) {
        this.tokens = tokens;
    }

    public boolean contains(String bagName) {
        Set<BagsToken> containsSet = tokens.stream().filter( x -> {
            if (!x.isMain() && x.isBag()) {
                return bagName.equals( x.getValue() );
            } else {
                return false;
            }
        } ).collect( Collectors.toSet() );
        return !containsSet.isEmpty();
    }

    public String containerBag() {

        if (tokens == null || tokens.isEmpty()) {
            return null;
        }

        return tokens.get( 0 ).getValue();
    }

    public List<BagPair> containedPair() {

        if (counter != 1) {
           return nameValueList;
        }

        nameValueList = new ArrayList<>(  );
        BagPair nameValue = null;
        while ((nameValue = nextPair()) != null) {
            nameValueList.add( nameValue ) ;
        }

        return nameValueList;
    }

    @Override
    public String toString() {
        return "BagRule{" +
            "nameValueList=" + nameValueList +
            '}';
    }

    private BagPair nextPair() {

        if (counter >= tokens.size())
            return null;

        BagsToken number = tokens.get( counter );
        counter++;
        BagsToken bag = tokens.get( counter );
        counter++;

        return new BagPair(bag.getValue(), number.getValue());
    }
}
