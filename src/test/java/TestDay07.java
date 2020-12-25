import org.corda.year2020.QuizD0601Resolver;
import org.corda.year2020.QuizD0602Resolver;
import org.corda.year2020.QuizD07Resolver;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay07 {

    @Disabled("skeleton: not yet implemented")
    @Test
    void firstQuiz() throws Exception {

        QuizD07Resolver resolver = new QuizD07Resolver( "day07input.txt" );

        long result = resolver.resolve("shiny_gold");

        assertEquals( 42, result );

        System.out.println( "D7Q1 result: " + result );
    }

    @Test
    void firstQuizExample() throws Exception {

        QuizD07Resolver resolver = new QuizD07Resolver( "day07inputexamplereduced.txt" );

        long result = resolver.resolve("shiny_gold");

        assertEquals( 42, result );
    }



    @Disabled("skeleton: not yet implemented")
    @Test
    void secondQuiz() throws Exception {

        QuizD07Resolver resolver = new QuizD07Resolver( "day07input.txt" );

        long result = resolver.resolve("shiny_gold");

        assertEquals( 42, result );

        System.out.println( "D7Q2 result: " + result );
    }

    @Disabled("skeleton: not yet implemented")
    @Test
    void secondQuizExample() throws Exception {

        QuizD07Resolver resolver = new QuizD07Resolver( "day07inputexample.txt" );

        long result = resolver.resolve("shiny_gold");

        assertEquals( 42, result );

    }




}