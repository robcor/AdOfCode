import org.corda.year2020.QuizD06Resolver;
import org.corda.year2020.QuizD05Resolver;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay06 {

    @Test
    void firstQuiz() throws Exception {

        QuizD06Resolver resolver = new QuizD06Resolver( "day06input.txt" );

        long result = resolver.sum();

        assertEquals( 6387, result );

        System.out.println( "D6Q1 result: " + result );
    }

    @Test
    void firstQuizExample() throws Exception {

        QuizD06Resolver resolver = new QuizD06Resolver( "day06inputexample.txt" );

        long result = resolver.sum();

        assertEquals( 11, result );
    }



    @Disabled("skeleton: not yet implemented")
    @Test
    void secondQuiz() throws Exception {

        QuizD06Resolver resolver = new QuizD06Resolver( "day06input.txt" );

        //int result = resolver.resolve();

        //assertEquals( 42, result );

        //System.out.println( "D5Q2 result: " + result );
    }




}