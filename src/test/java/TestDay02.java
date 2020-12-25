import org.corda.year2020.QuizD0201Resolver;
import org.corda.year2020.QuizD0202Resolver;
import org.corda.model.Day02Data;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestDay02 {

    @Test
    void firstQuiz() throws Exception {

        QuizD0201Resolver resolver = new QuizD0201Resolver( "day02input.txt" );

        long result = resolver.count();

        assertEquals( 614, result );

        System.out.println( "D2Q1 result: " + result );
    }

    @Test
    void secondQuiz() throws Exception {

        QuizD0202Resolver resolver = new QuizD0202Resolver( "day02input.txt" );

        long result = resolver.count();

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
    void checkValue_1() throws Exception {
        Day02Data dayTwo = new Day02Data( 1, 3, "a", "abcde" );
        QuizD0201Resolver resolver = new QuizD0201Resolver("alfa");
        assertTrue( resolver.checkValue( dayTwo  ) );
    }

    @Test
    void checkTest_2() throws Exception {
        Day02Data dayTwo = new Day02Data( 1, 3, "b", "cdefg" );
        QuizD0202Resolver resolver = new QuizD0202Resolver("alfa");
        assertFalse( resolver.checkValue( dayTwo  ) );
    }

    @Test
    void checkTest_3() throws Exception {
        Day02Data dayTwo = new Day02Data( 2, 9, "c", "ccccccccc" );
        QuizD0202Resolver resolver = new QuizD0202Resolver("alfa");
        assertFalse( resolver.checkValue( dayTwo  ) );
    }

    @Test
    void checkTest_4() throws Exception {
        Day02Data dayTwo = new Day02Data( 3, 7, "d", "fghjklb" );
        QuizD0202Resolver resolver = new QuizD0202Resolver("alfa");
        assertFalse( resolver.checkValue( dayTwo  ) );;
    }

    @Test
    void checkTest_5() throws Exception {
        Day02Data dayTwo = new Day02Data( 1, 3, "a", "kbade" );
        QuizD0202Resolver resolver = new QuizD0202Resolver("alfa");
        assertTrue( resolver.checkValue( dayTwo  ) );
    }



}
