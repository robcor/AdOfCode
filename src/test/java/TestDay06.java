import org.corda.year2020.QuizD0601Resolver;
import org.corda.year2020.QuizD0602Resolver;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay06 {

    @Test
    void firstQuiz() throws Exception {

        QuizD0601Resolver resolver = new QuizD0601Resolver( "day06input.txt" );

        long result = resolver.sum();

        assertEquals( 6387, result );

        System.out.println( "D6Q1 result: " + result );
    }

    @Test
    void firstQuizExample() throws Exception {

        QuizD0601Resolver resolver = new QuizD0601Resolver( "day06inputexample.txt" );

        long result = resolver.sum();

        assertEquals( 11, result );
    }



    //@Disabled("skeleton: not yet implemented")
    @Test
    void secondQuiz() throws Exception {

        QuizD0602Resolver resolver = new QuizD0602Resolver( "day06input.txt" );

        long result = resolver.sum();

        assertEquals( 3039, result );

        System.out.println( "D5Q2 result: " + result );
    }

    @Test
    void secondQuizExample() throws Exception {

        QuizD0602Resolver resolver = new QuizD0602Resolver( "day06inputexample.txt" );

        long result = resolver.sum();

        assertEquals( 6, result );

    }




}