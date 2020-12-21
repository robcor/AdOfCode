import org.corda.QuizD0301Resolver;
import org.corda.QuizD0302Resolver;
import org.corda.model.ConfigD03;
import org.corda.model.DayThreeData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestDay03 {

    // DOC: how to disable test with junit 5 (former: @Ignore)
    // @Disabled
    @Test
    void firstQuiz() throws Exception {

        QuizD0301Resolver resolver = new QuizD0301Resolver( "daythree.txt" , null);

        long result = resolver.resolve();

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
    // @Disabled
    @Test
    void secondQuiz() throws Exception {
        long result1 = resultByConfig( new ConfigD03( 1, 1 ), "daythree.txt" );
        long result2 = resultByConfig( new ConfigD03( 3, 1 ), "daythree.txt" );
        long result3 = resultByConfig( new ConfigD03( 5, 1 ), "daythree.txt" );
        long result4 = resultByConfig( new ConfigD03( 7, 1 ), "daythree.txt" );
        long result5 = resultByConfig( new ConfigD03( 1, 2 ), "daythree.txt" );

        long result = result1 * result2 * result3 * result4 * result5;
        assertEquals( 9406609920L, result );

        System.out.println( "D3Q2 result: " + result );
    }

    // "daythree.txt"
    private long resultByConfig(ConfigD03 config1, String fileName) throws java.io.IOException {
        QuizD0302Resolver resolver = new QuizD0302Resolver( fileName, config1);
        long result = resolver.resolve();

        return result;
    }

    @Test
    void checkValue_Q1() throws Exception {
        //             "012345678901234567890123456789012345678901234567890123456789012345";
        //             "#..1#.2.#3.#4..X..6#.7#.8.#9..X..#...#...#..#...#...#..#...#...#..";
        String input = "#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..";
        int inputLength = input.length();
        DayThreeData dayThreeData = new DayThreeData( input );


        QuizD0301Resolver resolver = new QuizD0301Resolver( "FAKE filename" , null);

        // simple
        dayThreeData.setSequence( 1 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( 4 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( 5 );
        assertTrue( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( 10 );
        assertTrue( resolver.checkValue( dayThreeData) );

        // repeat
        dayThreeData.setSequence( inputLength + 1 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength + 4 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength + 5 );
        assertTrue( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength + 10 );
        assertTrue( resolver.checkValue( dayThreeData) );

        // repeat more
        dayThreeData.setSequence( inputLength * 5 + 1 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength * 5 + 4 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength * 5 + 5 );
        assertTrue( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength * 5 + 10 );
        assertTrue( resolver.checkValue( dayThreeData) );

    }


    @Test
    void checkValue_Q2() throws Exception {
        //             "012345678901234567890123456789012345678901234567890123456789012345";
        //             "#..1#.2.#3.#4..X..6#.7#.8.#9..X..#...#...#..#...#...#..#...#...#..";
        String input = "#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..";
        int inputLength = input.length();
        DayThreeData dayThreeData = new DayThreeData( input );

        ConfigD03 config = new ConfigD03( 3, 1 );
        QuizD0302Resolver resolver = new QuizD0302Resolver( "FAKE filename", config);

        // simple
        dayThreeData.setSequence( 1 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( 4 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( 5 );
        assertTrue( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( 10 );
        assertTrue( resolver.checkValue( dayThreeData) );

        // repeat
        dayThreeData.setSequence( inputLength + 1 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength + 4 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength + 5 );
        assertTrue( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength + 10 );
        assertTrue( resolver.checkValue( dayThreeData) );

        // repeat more
        dayThreeData.setSequence( inputLength * 5 + 1 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength * 5 + 4 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength * 5 + 5 );
        assertTrue( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength * 5 + 10 );
        assertTrue( resolver.checkValue( dayThreeData) );

    }


    @Test
    void checkValue_Q2_delta2() throws Exception {
        //             "012345678901234567890123456789012345678901234567890123456789012345";
        //             "#..1#.2.#3.#4..X..6#.7#.8.#9..X..#...#...#..#...#...#..#...#...#..";
        String input = "#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..";
        int inputLength = input.length();
        DayThreeData dayThreeData = new DayThreeData( input );


        ConfigD03 config = new ConfigD03( 3, 2 );
        QuizD0302Resolver resolver = new QuizD0302Resolver( "FAKE filename", config);



        // simple
        dayThreeData.setSequence( 1 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( 4 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( 5 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( 10 );
        assertTrue( resolver.checkValue( dayThreeData) );

        // repeat
        dayThreeData.setSequence( inputLength + 1 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength + 4 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength + 5 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength + 10 );
        assertTrue( resolver.checkValue( dayThreeData) );

        // repeat more
        dayThreeData.setSequence( inputLength * 5 + 1 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength * 5 + 4 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength * 5 + 5 );
        assertFalse( resolver.checkValue( dayThreeData) );

        dayThreeData.setSequence( inputLength * 5 + 10 );
        assertTrue( resolver.checkValue( dayThreeData) );

    }


    /*
    In the above example, these slopes would find 2, 7, 3, 4, and 2 tree(s) respectively;
    multiplied together, these produce the answer 336.
     */
    @Test
    void secondQuizExample() throws Exception {
        long result1 = resultByConfig( new ConfigD03( 1, 1 ), "daythreeexample.txt" );
        assertEquals( 2, result1 );
        long result2 = resultByConfig( new ConfigD03( 3, 1 ), "daythreeexample.txt" );
        assertEquals( 7, result2 );
        long result3 = resultByConfig( new ConfigD03( 5, 1 ), "daythreeexample.txt" );
        assertEquals( 3, result3 );
        long result4 = resultByConfig( new ConfigD03( 7, 1 ), "daythreeexample.txt" );
        assertEquals( 4, result4 );
        long result5 = resultByConfig( new ConfigD03( 1, 2 ), "daythreeexample.txt" );
        assertEquals( 2, result5 );

        long result = result1 * result2 * result3 * result4 * result5;
        assertEquals( 336, result );
    }


}