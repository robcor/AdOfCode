package org.corda.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BagRule {
    private final List<BagsToken> tokens;

    public BagRule(List<BagsToken> tokens) {
        this.tokens = tokens;
    }

    public boolean contains(String bagName) {
        int a =42;
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
}
