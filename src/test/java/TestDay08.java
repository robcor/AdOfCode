import org.corda.year2020.QuizD0801Resolver;
import org.corda.year2020.QuizD0701Resolver;
import org.corda.year2020.QuizD0702Resolver;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay08 {

    //@Disabled("skeleton: not yet implemented")
    @Test
    void firstQuiz() throws Exception {

        QuizD0801Resolver resolver = new QuizD0801Resolver( "day08.txt" );

        long result = resolver.resolve();

        assertEquals( 1671, result );

        System.out.println( "D8Q1 result: " + result );
    }


    @Test
    void firstQuizExample() throws Exception {
        QuizD0801Resolver resolver = new QuizD0801Resolver( "day08example.txt" );

        long result = resolver.resolve();

        assertEquals( 5, result );
    }



    @Disabled("skeleton: not yet implemented")
    @Test
    void secondQuiz() throws Exception {

        QuizD0801Resolver resolver = new QuizD0801Resolver( "day08.txt" );

        long result = resolver.resolve();

        assertEquals( 42, result );

        System.out.println( "D8Q2 result: " + result );
    }

    @Disabled("skeleton: not yet implemented")
    @Test
    void secondQuizExample() throws Exception {

        QuizD0801Resolver resolver = new QuizD0801Resolver( "day08example.txt" );

        long result = resolver.resolve();

        assertEquals( 42, result );

    }




}