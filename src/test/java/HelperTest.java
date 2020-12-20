import org.corda.FileHelper;
import org.corda.NumberHelper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class HelperTest {


    @Test
    public void loadFile() throws Exception {
        List<String> result = FileHelper.readAllLines( "testNumberList.txt" );

        assertTrue( result.size() == 6 );
    }
    
    @Test
    public void getInputStream() throws Exception {
        InputStream result = FileHelper.getInputStream( "testNumberList.txt" );
        
        assertTrue( result != null );
    }


    @Test
    public void stringListToInteger() throws Exception {
        List<String> stringList = new ArrayList<>(  );
        stringList.add( "10" );
        stringList.add( "20" );
        List<Integer> intList = NumberHelper.stringListToInteger( stringList );


        assertTrue( intList.size() == 2);
    }

    @Test
    public void stringListToIntArray() throws Exception {
        List<String> stringList = new ArrayList<>(  );
        stringList.add( "10" );
        stringList.add( "20" );
        int[] intArray = NumberHelper.stringListToIntArray( stringList );

        assertTrue( intArray.length == 2);
    }


}
