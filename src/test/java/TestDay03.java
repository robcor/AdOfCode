import org.corda.Quiz0201Resolver;
import org.corda.Quiz0202Resolver;
import org.corda.Quiz0301Resolver;
import org.corda.Quiz0302Resolver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

 class TestDay03 {

     @Test
     void firstQuizRefactoring() throws Exception {

         Quiz0301Resolver resolver = new Quiz0301Resolver( "daytwo.txt" );

         long result = resolver.resolve();

         assertEquals( 614, result );

         System.out.println( "D2Q1 result: " + result );
     }

     @Test
     void secondQuizRefactoring() throws Exception {

         Quiz0302Resolver resolver = new Quiz0302Resolver( "daytwo.txt" );

         long result = resolver.resolve();

         assertEquals( 354, result );

         System.out.println( "D2Q2 result: " + result );
     }




}
