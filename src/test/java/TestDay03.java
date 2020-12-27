import org.corda.year2020.QuizD0301Resolver;
import org.corda.year2020.QuizD0302Resolver;
import org.corda.year2020.model.ConfigD03;
import org.corda.year2020.model.Day03Data;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestDay03 {

    // DOC: how to disable test with junit 5 (former: @Ignore)
    // @Disabled
    @Test
    void firstQuiz() throws Exception {

        QuizD0301Resolver resolver = new QuizD0301Resolver( "day03input.txt" , null);

        long result = resolver.count();

        assertEquals( 244, result );

        System.out.println( "D3Q1 result: " + result );
    }

    /*
    1) Right 1, down 1.
    2) Right 3, down 1.
    3) Right 5, down 1.
    4) Right 7, down 1.
    5) Right 1, down 2.
     */
    @Test
    void secondQuiz() throws Exception {
        long result1 = resultByConfig( new ConfigD03( 1, 1 ), "day03input.txt" );
        long result2 = resultByConfig( new ConfigD03( 3, 1 ), "day03input.txt" );
        long result3 = resultByConfig( new ConfigD03( 5, 1 ), "day03input.txt" );
        long result4 = resultByConfig( new ConfigD03( 7, 1 ), "day03input.txt" );
        long result5 = resultByConfig( new ConfigD03( 1, 2 ), "day03input.txt" );

        long result = result1 * result2 * result3 * result4 * result5;
        assertEquals( 9406609920L, result );

        System.out.println( "D3Q2 result: " + result );
    }

    private long resultByConfig(ConfigD03 config1, String fileName) throws java.io.IOException {
        QuizD0302Resolver resolver = new QuizD0302Resolver( fileName, config1);
        long result = resolver.count();

        return result;
    }

    @Test
    void checkValue_Q1() throws Exception {
        //             "012345678901234567890123456789012345678901234567890123456789012345";
        //             "#..1#.2.#3.#4..X..6#.7#.8.#9..X..#...#...#..#...#...#..#...#...#..";
        String input = "#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..";
        int inputLength = input.length();
        Day03Data day03Data = new Day03Data( input );


        QuizD0301Resolver resolver = new QuizD0301Resolver( "FAKE filename" , null);

        // simple
        day03Data.setSequence( 1 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( 4 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( 5 );
        assertTrue( resolver.checkValue( day03Data ) );

        day03Data.setSequence( 10 );
        assertTrue( resolver.checkValue( day03Data ) );

        // repeat
        day03Data.setSequence( inputLength + 1 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength + 4 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength + 5 );
        assertTrue( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength + 10 );
        assertTrue( resolver.checkValue( day03Data ) );

        // repeat more
        day03Data.setSequence( inputLength * 5 + 1 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength * 5 + 4 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength * 5 + 5 );
        assertTrue( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength * 5 + 10 );
        assertTrue( resolver.checkValue( day03Data ) );

    }


    @Test
    void checkValue_Q2() throws Exception {
        //             "012345678901234567890123456789012345678901234567890123456789012345";
        //             "#..1#.2.#3.#4..X..6#.7#.8.#9..X..#...#...#..#...#...#..#...#...#..";
        String input = "#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..";
        int inputLength = input.length();
        Day03Data day03Data = new Day03Data( input );

        ConfigD03 config = new ConfigD03( 3, 1 );
        QuizD0302Resolver resolver = new QuizD0302Resolver( "FAKE filename", config);

        // simple
        day03Data.setSequence( 1 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( 4 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( 5 );
        assertTrue( resolver.checkValue( day03Data ) );

        day03Data.setSequence( 10 );
        assertTrue( resolver.checkValue( day03Data ) );

        // repeat
        day03Data.setSequence( inputLength + 1 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength + 4 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength + 5 );
        assertTrue( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength + 10 );
        assertTrue( resolver.checkValue( day03Data ) );

        // repeat more
        day03Data.setSequence( inputLength * 5 + 1 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength * 5 + 4 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength * 5 + 5 );
        assertTrue( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength * 5 + 10 );
        assertTrue( resolver.checkValue( day03Data ) );

    }


    @Test
    void checkValue_Q2_delta2() throws Exception {
        //             "012345678901234567890123456789012345678901234567890123456789012345";
        //             "#..1#.2.#3.#4..X..6#.7#.8.#9..X..#...#...#..#...#...#..#...#...#..";
        String input = "#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..";
        int inputLength = input.length();
        Day03Data day03Data = new Day03Data( input );


        ConfigD03 config = new ConfigD03( 3, 2 );
        QuizD0302Resolver resolver = new QuizD0302Resolver( "FAKE filename", config);



        // simple
        day03Data.setSequence( 1 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( 4 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( 5 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( 10 );
        assertTrue( resolver.checkValue( day03Data ) );

        // repeat
        day03Data.setSequence( inputLength + 1 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength + 4 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength + 5 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength + 10 );
        assertTrue( resolver.checkValue( day03Data ) );

        // repeat more
        day03Data.setSequence( inputLength * 5 + 1 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength * 5 + 4 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength * 5 + 5 );
        assertFalse( resolver.checkValue( day03Data ) );

        day03Data.setSequence( inputLength * 5 + 10 );
        assertTrue( resolver.checkValue( day03Data ) );

    }


    /*
    In the above example, these slopes would find 2, 7, 3, 4, and 2 tree(s) respectively;
    multiplied together, these produce the answer 336.
     */
    @Test
    void secondQuizExample() throws Exception {
        long result1 = resultByConfig( new ConfigD03( 1, 1 ), "day03inputexample.txt" );
        assertEquals( 2, result1 );
        long result2 = resultByConfig( new ConfigD03( 3, 1 ), "day03inputexample.txt" );
        assertEquals( 7, result2 );
        long result3 = resultByConfig( new ConfigD03( 5, 1 ), "day03inputexample.txt" );
        assertEquals( 3, result3 );
        long result4 = resultByConfig( new ConfigD03( 7, 1 ), "day03inputexample.txt" );
        assertEquals( 4, result4 );
        long result5 = resultByConfig( new ConfigD03( 1, 2 ), "day03inputexample.txt" );
        assertEquals( 2, result5 );

        long result = result1 * result2 * result3 * result4 * result5;
        assertEquals( 336, result );
    }


}