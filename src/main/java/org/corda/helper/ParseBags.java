package org.corda.helper;


import org.corda.exception.AdventParseException;
import org.corda.year2020.model.BagRule;
import org.corda.year2020.model.BagsToken;
import static org.corda.year2020.model.BagsToken.BAG;
import static org.corda.year2020.model.BagsToken.BAGS_COMMA_LITERAL;
import static org.corda.year2020.model.BagsToken.BAGS_END_LITERAL;
import static org.corda.year2020.model.BagsToken.BAGS_LITERAL;
import static org.corda.year2020.model.BagsToken.BAG_COMMA_LITERAL;
import static org.corda.year2020.model.BagsToken.BAG_END_LITERAL;
import static org.corda.year2020.model.BagsToken.BAG_LITERAL;
import static org.corda.year2020.model.BagsToken.CONTAIN_LITERAL;
import static org.corda.year2020.model.BagsToken.NO_LITERAL;
import static org.corda.year2020.model.BagsToken.NUMBER;

import java.util.ArrayList;
import java.util.List;

public class ParseBags {



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
    public List<BagsToken> lexer() {

        BagsToken firstToken = getBag();
        firstToken.setAsMain();

        checkLiteralBagExists();
        checkContainExists();
        String nextToken = next();

        if (isLiteralNo( nextToken )) {
            return tokenList;
        }

        getNumber( nextToken );
        getBag();
        if (isLiteralEndBag( checkLiteralBagExists() ))
            return tokenList;

        do {
            getNumber();
            getBag();
        } while (!isLiteralEndBag( checkLiteralBagExists() ));

        return tokenList;
    }

    private boolean isLiteralNo(String nextToken) {
        return NO_LITERAL.equals( nextToken );
    }

    public BagRule parse() {

        List<BagsToken> tokens = lexer();

        return new BagRule( tokens );
    }

    private BagsToken getBag()  {
        String first = next();
        String second = next();
        String bagName = joinToken( first, second );
        BagsToken token = new BagsToken( BAG, bagName );

        tokenList.add( token );
        return token;
    }

    private void getNumber() {
        String number = next();

        BagsToken token = new BagsToken( NUMBER, number );
        tokenList.add( token );
    }

    private void getNumber(String number) {
        BagsToken token = new BagsToken( NUMBER, number );
        tokenList.add( token );
    }

    private void checkContainExists()  {
        if (!isContain( next() ))
            throw new AdventParseException(  "no contain literal found" );
    }


    private String checkLiteralBagExists()  {
        String bag = next();
        if (!isLiteralBag( bag ))
            throw new AdventParseException(  "no bags literal found" );

        return bag;
    }

    private boolean isLiteralBag(String literal) {
        return BAGS_LITERAL.equals( literal ) ||
            BAGS_COMMA_LITERAL.equals( literal ) ||
            BAGS_END_LITERAL.equals( literal ) ||
            BAG_END_LITERAL.equals( literal ) ||
            BAG_LITERAL.equals( literal ) ||
            BAG_COMMA_LITERAL.equals( literal );
    }

    private boolean isLiteralEndBag(String literal) {
        return (
            BAGS_END_LITERAL.equals( literal ) ||
            BAG_END_LITERAL.equals( literal )
        );
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

        throw new AdventParseException(  "no more bags tokens" );
    }

}
