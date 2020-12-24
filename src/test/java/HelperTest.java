import org.corda.helper.FileHelper;
import org.corda.helper.MathHelper;
import org.corda.helper.NumberHelper;
import org.corda.helper.StringHelper;
import org.corda.model.FlightPosition;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class HelperTest {


    public static final boolean IS_FRONT = true;
    private static final boolean IS_BACK = false;

    @Test
    void getInputStream() throws Exception {
        InputStream result = FileHelper.getInputStream( "testNumberList.txt" );

        assertNotNull( result );
    }

    @Test
    void readAllLines() throws Exception {
        List<String> result = FileHelper.readAllLines( "testNumberList.txt" );

        assertEquals( 6, result.size() );
    }

    @Test
    void readLinesDividedByCr() throws Exception {
        List<String> result = FileHelper.readLinesDividedByCr( "testGroupedLines.txt" );

        assertEquals( 3, result.size() );
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

    @Test
    void splitAt() throws Exception {
        String toTest = "BFFFBBFRRR";

        String[] result = StringHelper.splitAt( toTest, 7 );
        assertEquals( "BFFFBBF", result[0] );
        assertEquals( "RRR", result[1] );
    }

    // FBFBBFFRLR
    @Test
    void calculateMiddlePosition() {
        assertEquals( 63, MathHelper.calculateMiddlePosition( 0, 127, IS_FRONT ) );
        assertEquals( 32, MathHelper.calculateMiddlePosition( 0, 63, IS_BACK ) );
        assertEquals( 47, MathHelper.calculateMiddlePosition( 32, 63, IS_FRONT ) );
        assertEquals( 40, MathHelper.calculateMiddlePosition( 32, 47, IS_BACK ) );
        assertEquals( 44, MathHelper.calculateMiddlePosition( 40, 47, IS_BACK ) );
        assertEquals( 45, MathHelper.calculateMiddlePosition( 44, 47, IS_FRONT ) );
        assertEquals( 44, MathHelper.calculateMiddlePosition( 44, 45, IS_FRONT ) );
    }

    @Test
    void calculateMiddlePositionLow() {
        assertEquals( 63, MathHelper.calculateMiddlePositionLow( 0, 127 ) );
        assertEquals( 31, MathHelper.calculateMiddlePositionLow( 0, 63 ) );
        assertEquals( 47, MathHelper.calculateMiddlePositionLow( 32, 63 ) );
        assertEquals( 39, MathHelper.calculateMiddlePositionLow( 32, 47 ) );
        assertEquals( 43, MathHelper.calculateMiddlePositionLow( 40, 47 ) );
        assertEquals( 45, MathHelper.calculateMiddlePositionLow( 44, 47 ) );
        assertEquals( 44, MathHelper.calculateMiddlePositionLow( 44, 45 ) );
    }

    @Test
    void toPosition() throws Exception {
        String toTest = "FBFBBFF";

        int position = MathHelper.toPosition( toTest, 'F', 'B', 127 );

        assertNotNull( position );
        assertEquals( 44, position );
    }

    // BFFFBBFRRR: row 70, column 7, seat ID 567.
    @Test
    void flightCodeToPosition_row() throws Exception {
        String toTest = "BFFFBBFRRR";

        FlightPosition position = MathHelper.flightCodeToPosition( toTest );

        assertNotNull( position );
        assertEquals( 70, position.getRow() );
    }

    @Test
    void flightCodeToPosition_column() throws Exception {
        String toTest = "BFFFBBFRRR";

        FlightPosition position = MathHelper.flightCodeToPosition( toTest );

        assertNotNull( position );
        assertEquals( 7, position.getColumn() );
    }

    @Test
    void flightCodeToPosition() throws Exception {
        String toTest = "BFFFBBFRRR";

        FlightPosition position = MathHelper.flightCodeToPosition( toTest );

        assertNotNull( position );
        assertEquals( 567, position.getId() );
    }

    // FFFBBBFRRR: row 14, column 7, seat ID 119.
    @Test
    void flightCodeToPosition2_row() throws Exception {
        String toTest = "FFFBBBFRRR";

        FlightPosition position = MathHelper.flightCodeToPosition( toTest );

        assertNotNull( position );
        assertEquals( 14, position.getRow() );
    }

    @Test
    void flightCodeToPosition2_column() throws Exception {
        String toTest = "FFFBBBFRRR";

        FlightPosition position = MathHelper.flightCodeToPosition( toTest );

        assertNotNull( position );
        assertEquals( 7, position.getColumn() );
    }

    @Test
    void flightCodeToPosition2_id() throws Exception {
        String toTest = "FFFBBBFRRR";

        FlightPosition position = MathHelper.flightCodeToPosition( toTest );

        assertNotNull( position );
        assertEquals( 119, position.getId() );
    }

    // BBFFBBFRLL: row 102, column 4, seat ID 820.
    @Test
    void flightCodeToPosition3_row() throws Exception {
        String toTest = "BBFFBBFRLL";

        FlightPosition position = MathHelper.flightCodeToPosition( toTest );

        assertNotNull( position );
        assertEquals( 102, position.getRow() );
    }

    @Test
    void flightCodeToPosition3_column() throws Exception {
        String toTest = "BBFFBBFRLL";

        FlightPosition position = MathHelper.flightCodeToPosition( toTest );

        assertNotNull( position );
        assertEquals( 4, position.getColumn() );
    }

    @Test
    void flightCodeToPosition3_id() throws Exception {
        String toTest = "BBFFBBFRLL";

        FlightPosition position = MathHelper.flightCodeToPosition( toTest );

        assertNotNull( position );
        assertEquals( 820, position.getId() );
    }


}
