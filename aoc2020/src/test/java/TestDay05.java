import org.corda.year2020.QuizD0402Resolver;
import org.corda.year2020.QuizD05Resolver;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

class TestDay05 {

    @Test
    void firstQuiz() throws Exception {

        QuizD05Resolver resolver = new QuizD05Resolver( "day05input.txt" );

        long result = resolver.maxValue();

        assertEquals( 928, result );

        System.out.println( "D5Q1 result: " + result );
    }

    @Test
    void firstQuizExample() throws Exception {

        QuizD05Resolver resolver = new QuizD05Resolver( "day05inputexample.txt" );

        long result = resolver.maxValue();

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