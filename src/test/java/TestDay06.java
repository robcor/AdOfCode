import org.corda.year2020.QuizD06Resolver;
import org.corda.year2020.QuizD05Resolver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay06 {

    @Test
    void firstQuiz() throws Exception {

        QuizD06Resolver resolver = new QuizD06Resolver( "day06input.txt" );

        long result = resolver.count();

        assertEquals( 928, result );

        System.out.println( "D5Q1 result: " + result );
    }

    @Test
    void firstQuizExample() throws Exception {

        QuizD06Resolver resolver = new QuizD06Resolver( "day05inputexample.txt" );

        long result = resolver.count();

        assertEquals( 820, result );
    }



    //@Disabled("skeleton: not yet implemented")
    @Test
    void secondQuiz() throws Exception {

        QuizD05Resolver resolver = new QuizD05Resolver( "day05input.txt" );

        int result = resolver.resolve();

        assertEquals( 610, result );

        System.out.println( "D5Q2 result: " + result );
    }




}