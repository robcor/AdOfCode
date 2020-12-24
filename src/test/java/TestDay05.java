import org.corda.model.Day04Data;
import org.corda.year2020.QuizD0401Resolver;
import org.corda.year2020.QuizD0402Resolver;
import org.corda.year2020.QuizD0501Resolver;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestDay05 {

    @Test
    void firstQuiz() throws Exception {

        QuizD0501Resolver resolver = new QuizD0501Resolver( "day05input.txt" );

        long result = resolver.maxValue();

        assertEquals( 928, result );

        System.out.println( "D5Q1 result: " + result );
    }

    @Test
    void firstQuizExample() throws Exception {

        QuizD0501Resolver resolver = new QuizD0501Resolver( "day05inputexample.txt" );

        long result = resolver.maxValue();

        assertEquals( 820, result );
    }



    @Disabled("skeleton: not yet implemented")
    @Test
    void secondQuiz() throws Exception {

        QuizD0402Resolver resolver = new QuizD0402Resolver( "day04input.txt" );

        long result = resolver.counter();

        assertEquals( 42, result );

        System.out.println( "D5Q2 result: " + result );
    }




}