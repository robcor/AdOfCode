import org.corda.QuizD0201Resolver;
import org.corda.QuizD0301Resolver;
import org.corda.QuizD0302Resolver;
import org.corda.model.DayThreeData;
import org.corda.model.DayTwoData;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestDay03 {

    // DOC: how to disable test with junit 5 (former: @Ignore)
    // @Disabled
    @Test
    void firstQuiz() throws Exception {

        QuizD0301Resolver resolver = new QuizD0301Resolver( "daythree.txt" );

        long result = resolver.resolve();

        assertEquals( 42, result );

        System.out.println( "D3Q1 result: " + result );
    }

    // DOC: how to disable test with junit 5 (former: @Ignore)
    // @Disabled
    @Test
    void secondQuiz() throws Exception {

        QuizD0302Resolver resolver = new QuizD0302Resolver( "daythree.txt" );

        long result = resolver.resolve();

        assertEquals( 42, result );

        System.out.println( "D3Q2 result: " + result );
    }

    @Test
    void checkValue_1() throws Exception {
        DayThreeData dayThreeData = new DayThreeData( "#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#.." );
        QuizD0301Resolver resolver = new QuizD0301Resolver("FAKE filename");
        assertTrue( resolver.checkValue( dayThreeData ) );
    }


}
