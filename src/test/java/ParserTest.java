import org.corda.helper.ParseBags;
import org.corda.model.BagsToken;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

class ParserTest {
    

    @Test
    void lexer() throws Exception {
        String toTest = "light red bags contain 1 bright white bag, 2 muted yellow bags.";

        ParseBags parser =  new ParseBags(toTest);

        List<BagsToken> parsed = parser.lexer();

        assertNotNull( parsed );
        assertEquals( 5, parsed.size() );
    }


}
