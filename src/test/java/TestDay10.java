import org.corda.year2020.QuizD0901Resolver;
import org.corda.year2020.QuizD0902Resolver;
import org.corda.year2020.QuizD1001Resolver;
import org.corda.year2020.QuizD1002Resolver;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

class TestDay10 {

    //@Disabled("skeleton: not yet implemented")
    @Test
    void firstQuiz() throws Exception {

        QuizD1001Resolver resolver = new QuizD1001Resolver( "day10.txt" );

        long result = resolver.resolve();

        assertEquals( 2112, result );

        System.out.println( "D9Q1 result: " + result );
    }


    @Test
    void firstQuizExample() throws Exception {
        QuizD1001Resolver resolver = new QuizD1001Resolver( "day10example.txt" );

        long result = resolver.resolve();

        assertEquals( 35, result );
    }

    @Test
    void firstQuizExample2() throws Exception {
        QuizD1001Resolver resolver = new QuizD1001Resolver( "day10example2.txt" );

        long result = resolver.resolve();

        assertEquals( 220, result );
    }


    //@Disabled("skeleton: not yet implemented")
    @Test
    void secondQuiz() throws Exception {

        QuizD1002Resolver resolver = new QuizD1002Resolver( "day10.txt");

        long result = resolver.resolve();

        assertEquals( 42, result );

        System.out.println( "D8Q2 result: " + result );
    }

    //@Disabled("skeleton: not yet implemented")
    @Test
    void secondQuizExample() throws Exception {

        QuizD1002Resolver resolver = new QuizD1002Resolver( "day10example.txt" );

        long result = resolver.resolve();

        assertEquals( 8, result );

    }

    @Test
    void secondQuizExample2() throws Exception {

        QuizD1002Resolver resolver = new QuizD1002Resolver( "day10example2.txt" );

        long result = resolver.resolve();

        assertEquals( 19208, result );

    }

    @Test
    void secondQuizPermSimple() throws Exception {

        QuizD1002Resolver resolver = new QuizD1002Resolver( "day10simple.txt" );

        long result = resolver.testPerm();

        assertEquals( 1112, result );

    }

    @Test
    void secondQuizPerm() throws Exception {

        QuizD1002Resolver resolver = new QuizD1002Resolver( "day10.txt" );

        long result = resolver.testPerm();

        // 922181
        assertEquals( 1 + 98 + 98*97 + 98*97*96, result );

    }





}