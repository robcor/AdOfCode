import org.apache.commons.lang3.StringUtils;
import org.corda.Facade;
import org.corda.NumberHelper;
import org.corda.Quiz0201Resolver;
import org.corda.Quiz0202Resolver;
import org.corda.model.DayTwoData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.function.Predicate;

class TestDay02 {

    @Test
    void firstQuizRefactoring() throws Exception {

        Quiz0201Resolver resolver = new Quiz0201Resolver( "daytwo.txt" );

        long result = resolver.resolve();

        assertEquals( 614, result );

        System.out.println( "D2Q1 result: " + result );
    }

    @Test
    void secondQuizRefactoring() throws Exception {

        Quiz0202Resolver resolver = new Quiz0202Resolver( "daytwo.txt" );

        long result = resolver.resolve();

        assertEquals( 354, result );

        System.out.println( "D2Q2 result: " + result );
    }


    /*
    1-3 a: abcde     is valid: position 1 contains a and position 3 does not.
    1-3 b: cdefg     is invalid: neither position 1 nor position 3 contains b.
    2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.
    3-7 d: fghjklb   is invalid none is contained
    1-3 a: kbade     is valid: position 1 not contains a and position 3 does.
     */
    @Test
    void checkTest_1() throws Exception {
        DayTwoData dayTwo = new DayTwoData( 1, 3, "a", "abcde" );
        Quiz0201Resolver resolver = new Quiz0201Resolver("alfa");
        assertTrue( resolver.checkPassword( dayTwo ) );
    }

    @Test
    void checkTest_2() throws Exception {
        DayTwoData dayTwo = new DayTwoData( 1, 3, "b", "cdefg" );
        Quiz0202Resolver resolver = new Quiz0202Resolver("alfa");
        assertFalse( resolver.checkPassword( dayTwo ) );
    }

    @Test
    void checkTest_3() throws Exception {
        DayTwoData dayTwo = new DayTwoData( 2, 9, "c", "ccccccccc" );
        Quiz0202Resolver resolver = new Quiz0202Resolver("alfa");
        assertFalse( resolver.checkPassword( dayTwo ) );
    }

    @Test
    void checkTest_4() throws Exception {
        DayTwoData dayTwo = new DayTwoData( 3, 7, "d", "fghjklb" );
        Quiz0202Resolver resolver = new Quiz0202Resolver("alfa");
        assertFalse( resolver.checkPassword( dayTwo ) );;
    }

    @Test
    void checkTest_5() throws Exception {
        DayTwoData dayTwo = new DayTwoData( 1, 3, "a", "kbade" );
        Quiz0202Resolver resolver = new Quiz0202Resolver("alfa");
        assertTrue( resolver.checkPassword( dayTwo ) );
    }



}
