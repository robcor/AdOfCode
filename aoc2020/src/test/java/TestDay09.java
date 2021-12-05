import org.corda.year2020.QuizD0901Resolver;
import org.corda.year2020.QuizD0902Resolver;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

class TestDay09 {

    @Test
    void firstQuiz() throws Exception {

        QuizD0901Resolver resolver = new QuizD0901Resolver( "day09.txt" , 25);

        long result = resolver.resolve();

        assertEquals( 26796446, result );

        System.out.println( "D9Q1 result: " + result );
    }


    @Test
    void firstQuizExample() throws Exception {
        QuizD0901Resolver resolver = new QuizD0901Resolver( "day09example.txt", 5 );

        long result = resolver.resolve();

        assertEquals( 127, result );
    }


    //@Disabled("skeleton: not yet implemented")
    @Test
    void secondQuiz() throws Exception {

        QuizD0902Resolver resolver = new QuizD0902Resolver( "day09.txt", 26796446l);

        long result = resolver.resolve();

        assertEquals( 3353494, result );

        System.out.println( "D8Q2 result: " + result );
    }

    //@Disabled("skeleton: not yet implemented")
    @Test
    void secondQuizExample() throws Exception {

        QuizD0902Resolver resolver = new QuizD0902Resolver( "day09example.txt" , 127l);

        long result = resolver.resolve();

        assertEquals( 62, result );

    }

    public static final List<Long> list = Arrays.asList(
        35l, 20l, 15l, 25l, 47l, 40l, 62l, 55l, 65l, 95l,
        102l, 117l, 150l, 182l, 127l, 219l, 299l, 277l, 309l, 576l );

    @Test
    void thereASum_a() {
        boolean thereSum = QuizD0901Resolver.thereASum( 40, list, 0, 5 );

        assertTrue( thereSum );
    }

    @Test
    void thereASum_b() {
        boolean thereSum = QuizD0901Resolver.thereASum( 62, list, 1, 5 );

        assertTrue( thereSum );
    }

    @Test
    void thereASum_c() {
        boolean thereSum = QuizD0901Resolver.thereASum( 55, list, 2, 5 );

        assertTrue( thereSum );
    }

    @Test
    void thereASum_NO() {
        boolean thereSum = QuizD0901Resolver.thereASum( 127, list, 10, 5 );

        assertFalse( thereSum );
    }



}