import org.corda.QuizD0301Resolver;
import org.corda.QuizD0302Resolver;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay03 {

    @Disabled
    @Test
    void firstQuizRefactoring() throws Exception {

        QuizD0301Resolver resolver = new QuizD0301Resolver( "daythree.txt" );

        long result = resolver.resolve();

        assertEquals( 42, result );

        System.out.println( "D3Q1 result: " + result );
    }

    @Disabled
    @Test
    void secondQuizRefactoring() throws Exception {

        QuizD0302Resolver resolver = new QuizD0302Resolver( "daythree.txt" );

        long result = resolver.resolve();

        assertEquals( 42, result );

        System.out.println( "D3Q2 result: " + result );
    }


}
