import org.corda.year2020.QuizD0701Resolver;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay07 {

    //@Disabled("skeleton: not yet implemented")
    @Test
    void firstQuiz() throws Exception {

        QuizD0701Resolver resolver = new QuizD0701Resolver( "day07.txt" );

        long result = resolver.resolve("shiny_gold");

        assertEquals( 213, result );

        System.out.println( "D7Q1 result: " + result );
    }

    @Test
    void firstQuizExampleReduced() throws Exception {

        QuizD0701Resolver resolver = new QuizD0701Resolver( "day07inputexamplereduced.txt" );

        long result = resolver.resolve("shiny_gold");

        assertEquals( 1, result );
    }

    @Test
    void firstQuizExample() throws Exception {
        QuizD0701Resolver resolver = new QuizD0701Resolver( "day07inputexample.txt" );

        long result = resolver.resolve("shiny_gold");

        assertEquals( 4, result );
    }



    @Disabled("skeleton: not yet implemented")
    @Test
    void secondQuiz() throws Exception {

        QuizD0701Resolver resolver = new QuizD0701Resolver( "day07input.txt" );

        long result = resolver.resolve("shiny_gold");

        assertEquals( 42, result );

        System.out.println( "D7Q2 result: " + result );
    }

    @Disabled("skeleton: not yet implemented")
    @Test
    void secondQuizExample() throws Exception {

        QuizD0701Resolver resolver = new QuizD0701Resolver( "day07inputexample.txt" );

        long result = resolver.resolve("shiny_gold");

        assertEquals( 42, result );

    }




}