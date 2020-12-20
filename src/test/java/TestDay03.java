import org.corda.QuizD0301Resolver;
import org.corda.QuizD0302Resolver;
import org.corda.model.DayThreeData;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestDay03 {

    // DOC: how to disable test with junit 5 (former: @Ignore)
    // @Disabled
    @Test
    void firstQuiz() throws Exception {

        QuizD0301Resolver resolver = new QuizD0301Resolver( "daythree.txt" );

        long result = resolver.resolve();

        assertEquals( 244, result );

        System.out.println( "D3Q1 result: " + result );
    }

    @Disabled
    @Test
    void secondQuiz() throws Exception {

        QuizD0302Resolver resolver = new QuizD0302Resolver( "daythree.txt" );

        long result = resolver.resolve();

        assertEquals( 42, result );

        System.out.println( "D3Q2 result: " + result );
    }

    @Test
    void checkValue_1() throws Exception {
        //             "012345678901234567890123456789012345678901234567890123456789012345";
        //             "#..1#.2.#3.#4..X..6#.7#.8.#9..X..#...#...#..#...#...#..#...#...#..";
        String input = "#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..";
        int inputLength = input.length();
        DayThreeData dayThreeData = new DayThreeData( input );


        QuizD0301Resolver resolver = new QuizD0301Resolver( "FAKE filename" );

        // simple
        dayThreeData.setSequence( 1 );
        assertFalse( resolver.checkValue( dayThreeData ) );

        dayThreeData.setSequence( 4 );
        assertFalse( resolver.checkValue( dayThreeData ) );

        dayThreeData.setSequence( 5 );
        assertTrue( resolver.checkValue( dayThreeData ) );

        dayThreeData.setSequence( 10 );
        assertTrue( resolver.checkValue( dayThreeData ) );

        // repeat
        dayThreeData.setSequence( inputLength + 1 );
        assertFalse( resolver.checkValue( dayThreeData ) );

        dayThreeData.setSequence( inputLength + 4 );
        assertFalse( resolver.checkValue( dayThreeData ) );

        dayThreeData.setSequence( inputLength + 5 );
        assertTrue( resolver.checkValue( dayThreeData ) );

        dayThreeData.setSequence( inputLength + 10 );
        assertTrue( resolver.checkValue( dayThreeData ) );

        // repeat more
        dayThreeData.setSequence( inputLength * 5 + 1 );
        assertFalse( resolver.checkValue( dayThreeData ) );

        dayThreeData.setSequence( inputLength * 5 + 4 );
        assertFalse( resolver.checkValue( dayThreeData ) );

        dayThreeData.setSequence( inputLength * 5 + 5 );
        assertTrue( resolver.checkValue( dayThreeData ) );

        dayThreeData.setSequence( inputLength * 5 + 10 );
        assertTrue( resolver.checkValue( dayThreeData ) );

    }


}