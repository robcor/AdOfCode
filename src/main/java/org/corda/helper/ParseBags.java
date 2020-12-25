package org.corda.helper;


import org.corda.model.BagsToken;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ParseBags {
    // literals
    public static final String BAGS_LITERAL = "bags";
    private static final String BAGS_COMMA_LITERAL = "bags,";
    public static final String BAG_LITERAL = "bags";
    private static final String BAG_COMMA_LITERAL = "bag,";
    private static final String BAG_END_LITERAL = "bag.";
    private static final String BAGS_END_LITERAL = "bags.";
    private static final String CONTAIN_LITERAL = "contain";


    // types
    private static final String NUMBER = "NUMBER";
    private static final String BAG = "BAG";


    // fields
    private final String[] rawToken;
    private int counter;
    private List<BagsToken> tokenList;

    public ParseBags(String input) {
        this.rawToken = input.split( " " );
        this.counter = -1;
        this.tokenList = new ArrayList<>();
    }

    // EXAMPLE
    // bright beige bags contain 4 faded magenta bags, 1 dotted purple bag, 2 mirrored cyan bags, 1 drab white bag.
    // (bright_beige, (faded_magenta, 4), (dotted purple, 1), (mirrored_cyan, 2), (drab_white, 1))
    public List<BagsToken> lexer() throws ParseException {

        getBag();

        checkBagExists();

        checkContainExists();

        getNumber();

        getBag();

        checkBagExists();

        // TODO repeat
        do {
            getNumber();

            getBag();

        } while (BAG_END_LITERAL.equals( checkBagExists() ));

        return tokenList;
    }

    private void getBag() {
        String first = next();
        String second = next();
        String bagName = joinToken( first, second );
        BagsToken token = new BagsToken( BAG, bagName );

        tokenList.add( token );
    }

    private void getNumber() {
        String number = next();

        BagsToken token = new BagsToken( NUMBER, number );
        tokenList.add( token );
    }

    private void checkContainExists() throws ParseException {
        if (!isContain( next() ))
            throw new ParseException( "no bags", 1 );
    }


    private String checkBagExists() throws ParseException {
        String bag = next();
        if (!isBags( bag ))
            throw new ParseException( "no bags", 1 );

        return bag;
    }

    private boolean isBags(String literal) {
        return
            BAGS_LITERAL.equals( literal ) ||
            BAGS_COMMA_LITERAL.equals( literal ) ||
            BAGS_END_LITERAL.equals( literal ) ||
            BAG_END_LITERAL.equals( literal ) ||
            BAG_LITERAL.equals( literal ) ||
            BAG_COMMA_LITERAL.equals( literal );
    }

    private boolean isContain(String bags) {
        return CONTAIN_LITERAL.equals( bags );
    }

    private String joinToken(String first, String second) {
        return first + "_" + second;
    }

    private String next() {
        counter++;

        if (counter < rawToken.length) {
            return rawToken[counter];
        }

        return null;
    }

}
