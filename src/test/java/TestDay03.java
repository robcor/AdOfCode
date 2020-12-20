import org.corda.Quiz0201Resolver;
import org.corda.Quiz0202Resolver;
import org.corda.Quiz0301Resolver;
import org.corda.Quiz0302Resolver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

 class TestDay03 {

     @Test
     void firstQuizRefactoring() throws Exception {

         Quiz0301Resolver resolver = new Quiz0301Resolver( "daythree.txt" );

         long result = resolver.resolve();

         assertEquals( 42, result );

         System.out.println( "D3Q1 result: " + result );
     }

     @Test
     void secondQuizRefactoring() throws Exception {

         Quiz0302Resolver resolver = new Quiz0302Resolver( "daythree.txt" );

         long result = resolver.resolve();

         assertEquals( 42, result );

         System.out.println( "D3Q2 result: " + result );
     }




}
