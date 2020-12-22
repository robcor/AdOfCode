import org.corda.Facade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay01 {


    //result:631+1389=2020
    //631*1389=876459
    @Test
    void firstQuiz() throws Exception {

        int[] intArray = Facade.sortedIntFromFile( "day01input.txt" );

        long result = 0;
        for (int indexA = 0; indexA < intArray.length; indexA++) {
            for (int indexB = indexA + 1; indexB < intArray.length; indexB++) {
                int valueA = intArray[indexA];
                int valueB = intArray[indexB];
                if (valueA + valueB == 2020) {
                    result = valueA * valueB;
                    System.out.println( "D1Q1 result: " + valueA * valueB );
                    break;
                }
            }

        }

        assertEquals( 876459, result );
    }

    /*
    result:140+708+1172=2020
    result:140*708*1172=116168640
     */
    @Test
    void secondQuiz() throws Exception {

        int[] intArray = Facade.sortedIntFromFile( "day01input.txt" );

        long result = 0;
        for (int indexA = 0; indexA < intArray.length; indexA++) {
            for (int indexB = indexA + 1; indexB < intArray.length; indexB++) {
                for (int indexC = indexB + 1; indexC < intArray.length; indexC++) {
                    int valueA = intArray[indexA];
                    int valueB = intArray[indexB];
                    int valueC = intArray[indexC];
                    if (valueA + valueB + valueC == 2020) {
                        result = valueA * valueB * valueC;
                        System.out.println( "D1Q2 result: " + valueA * valueB * valueC );
                        break;
                    }
                }
            }

        }

        assertEquals( 116168640, result );


    }


}
