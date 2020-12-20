import org.corda.helper.FileHelper;
import org.corda.helper.NumberHelper;
import org.corda.helper.StringHelper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class HelperTest {


    @Test
    void loadFile() throws Exception {
        List<String> result = FileHelper.readAllLines( "testNumberList.txt" );

        assertEquals( 6, result.size() );
    }

    @Test
    void getInputStream() throws Exception {
        InputStream result = FileHelper.getInputStream( "testNumberList.txt" );

        assertNotNull( result );
    }


    @Test
    void stringListToInteger() throws Exception {
        List<String> stringList = new ArrayList<>();
        stringList.add( "10" );
        stringList.add( "20" );
        List<Integer> intList = NumberHelper.stringListToInteger( stringList );


        assertEquals( 2, intList.size() );
    }

    @Test
    void stringListToIntArray() throws Exception {
        List<String> stringList = new ArrayList<>();
        stringList.add( "10" );
        stringList.add( "20" );
        int[] intArray = NumberHelper.stringListToIntArray( stringList );

        assertEquals( 2, intArray.length );
    }

    @Test
    void getLetterAt() throws Exception {
        String toTest = "abcdefg";

        assertEquals( "a", StringHelper.getLetterAt( toTest, 1 ) );
        assertEquals( "c", StringHelper.getLetterAt( toTest, 3 ) );
    }


}
