import org.corda.helper.ParseBags;
import org.corda.model.BagRule;
import org.corda.model.BagsToken;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

class ParserTest {


    @Test
    void lexer() throws Exception {
        String toTest = "light red bags contain 1 bright white bag, 2 muted yellow bags.";

        ParseBags parser = new ParseBags( toTest );

        List<BagsToken> parsed = parser.lexer();

        assertNotNull( parsed );
        assertEquals( 5, parsed.size() );
    }

    @Test
    void contains() throws Exception {
        String toTest = "light red bags contain 1 bright white bag, 2 muted yellow bags.";

        ParseBags parser = new ParseBags( toTest );

        BagRule parsed = parser.parse();

        assertNotNull( parsed );
        assertTrue( parsed.contains( "bright_white" ) );
        assertTrue( parsed.contains( "muted_yellow" ) );
        assertFalse( parsed.contains( "pale_white" ) );
    }


    @Test
    void containerBag() throws Exception {
        String toTest = "light red bags contain 1 bright white bag, 2 muted yellow bags.";

        ParseBags parser = new ParseBags( toTest );

        BagRule parsed = parser.parse();

        assertNotNull( parsed );
        assertEquals( "light_red", parsed.containerBag( ) );
        assertNotEquals(  "muted_yellow", parsed.containerBag( ) );
    }


    @Test
    void lexer_noOther() throws Exception {
        String toTest = "faded blue bags contain no other bags.";

        ParseBags parser = new ParseBags( toTest );

        List<BagsToken> parsed = parser.lexer();

        assertNotNull( parsed );
        assertEquals( 1, parsed.size() );
    }

    @Test
    void lexer_justOne() throws Exception {
        String toTest = "bright white bags contain 1 shiny gold bag.";

        ParseBags parser = new ParseBags( toTest );

        List<BagsToken> parsed = parser.lexer();

        assertNotNull( parsed );
        assertEquals( 3, parsed.size() );
    }

}
