import org.corda.QuizD0401Resolver;
import org.corda.QuizD0402Resolver;
import org.corda.model.Day04Data;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestDay04 {


    //@Disabled("skeleton: not yet implemented")
    @Test
    void firstQuiz() throws Exception {

        QuizD0401Resolver resolver = new QuizD0401Resolver( "day04input.txt" );

        long result = resolver.resolve();

        assertEquals( 208, result );

        System.out.println( "D4Q1 result: " + result );
    }

    @Test
    void firstQuizExample() throws Exception {

        QuizD0401Resolver resolver = new QuizD0401Resolver( "day04inputexample.txt" );

        long result = resolver.resolve();

        assertEquals( 2, result );

    }

    @Disabled("skeleton: not yet implemented")
    @Test
    void secondQuiz() throws Exception {

        QuizD0402Resolver resolver = new QuizD0402Resolver( "day04input.txt" );

        long result = resolver.resolve();

        assertEquals( 42, result );

        System.out.println( "D4Q1 result: " + result );
    }

    @Test
    void secondQuizExample() throws Exception {

        QuizD0402Resolver resolver = new QuizD0402Resolver( "testValidPassport.txt" );

        long result = resolver.resolve();

        assertEquals( 4, result );

    }


    // byr (Birth Year) - four digits; at least 1920 and at most 2002.
    @Test
    void isValidByr() throws Exception {

        QuizD0402Resolver resolver = new QuizD0402Resolver( "testValidPassport.txt" );

        assertFalse( resolver.isValidByr( "1919" ) );
        assertTrue( resolver.isValidByr( "1920" ) );
        assertTrue( resolver.isValidByr( "2002" ) );
        assertFalse( resolver.isValidByr( "2003" ) );

    }
    
    @Test
    void isValidIyr() throws Exception {

        QuizD0402Resolver resolver = new QuizD0402Resolver( "testValidPassport.txt" );

        assertFalse( resolver.isValidIyr( "2009" ) );
        assertTrue( resolver.isValidIyr( "2010" ) );
        assertTrue( resolver.isValidIyr( "2020" ) );
        assertFalse( resolver.isValidIyr( "2021" ) );

    }

    @Test
    void isValidEyr() throws Exception {

        QuizD0402Resolver resolver = new QuizD0402Resolver( "testValidPassport.txt" );

        assertFalse( resolver.isValidEyr( "2019" ) );
        assertTrue( resolver.isValidEyr( "2020" ) );
        assertTrue( resolver.isValidEyr( "2030" ) );
        assertFalse( resolver.isValidEyr( "2031" ) );
    }


    @Test
    void isValidHgt() throws Exception {

        QuizD0402Resolver resolver = new QuizD0402Resolver( "testValidPassport.txt" );

        assertFalse( resolver.isValidHgt( "150pm" ) );
        assertFalse( resolver.isValidHgt( "59kz" ) );
        
        assertFalse( resolver.isValidHgt( "149cm" ) );
        assertTrue( resolver.isValidHgt( "150cm" ) );
        assertTrue( resolver.isValidHgt( "193cm" ) );
        assertFalse( resolver.isValidHgt( "194cm" ) );

        assertFalse( resolver.isValidHgt( "58in" ) );
        assertTrue( resolver.isValidHgt( "59in" ) );
        assertTrue( resolver.isValidHgt( "76in" ) );
        assertFalse( resolver.isValidHgt( "77in" ) );
    }


    //hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
    @Test
    void isValidHcl() throws Exception {

        QuizD0402Resolver resolver = new QuizD0402Resolver( "testValidPassport.txt" );

        assertFalse( resolver.isValidHcl( ".a2a0a1" ) );
        assertFalse( resolver.isValidHcl( "#a2a0a1k" ) );
        assertFalse( resolver.isValidHcl( "#a2a@a1" ) );

        assertTrue( resolver.isValidHcl( "#a2a0a1" ) );
        assertTrue( resolver.isValidHcl( "#abcdef" ) );
        assertTrue( resolver.isValidHcl( "#123456" ) );

    }



    //ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
    //pid (Passport ID) - a nine-digit number, including leading zeroes.
    //cid (Country ID) - ignored, missing or not.

    @Test
    void parseInput_smoketest() {
        String inputExample = INPUT_EXAMPLE_1;

        QuizD0401Resolver resolver = new QuizD0401Resolver( "FAKE" );

        Day04Data data = resolver.parseInput( inputExample );
        assertNotNull( data );
    }

    public static final String INPUT_EXAMPLE_1 = "hcl:ff4451 iyr:2022 " +
        "byr:1972 ecl:#86cbc5 pid:29044223 eyr:1985 " +
        "hgt:62cm";

    @Test
    void parseInput_happypath1() {
        String inputExample = INPUT_EXAMPLE_1;

        QuizD0401Resolver resolver = new QuizD0401Resolver( "FAKE" );

        Day04Data data = resolver.parseInput( inputExample );
        assertEquals( "1972", data.getByr() );
        assertEquals( "2022", data.getIyr() );
        assertEquals( "1985", data.getEyr() );
        assertEquals( "62cm", data.getHgt() );
        assertEquals( "ff4451", data.getHcl() );
        assertEquals( "#86cbc5", data.getEcl() );
        assertEquals( "29044223", data.getPid() );
        assertEquals( null, data.getCid() );

    }

    public static final String INPUT_EXAMPLE_2 = "hcl:#623a2f iyr:2013 eyr:2023 hgt:164cm byr:1956 " +
        "ecl:oth";

    @Test
    void parseInput_happypath2() {
        String inputExample = INPUT_EXAMPLE_2;

        QuizD0401Resolver resolver = new QuizD0401Resolver( "FAKE" );

        Day04Data data = resolver.parseInput( inputExample );
        assertEquals( "1956", data.getByr() );
        assertEquals( "2013", data.getIyr() );
        assertEquals( "2023", data.getEyr() );
        assertEquals( "164cm", data.getHgt() );
        assertEquals( "#623a2f", data.getHcl() );
        assertEquals( "oth", data.getEcl() );
        assertEquals( null, data.getPid() );
        assertEquals( null, data.getCid() );
    }


    public static final String VALID_8 = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd " +
        "byr:1937 iyr:2017 cid:147 hgt:183cm ";

    @Test
    void checkValue_valid8() {
        String inputExample = VALID_8;

        QuizD0401Resolver resolver = new QuizD0401Resolver( "FAKE" );

        Day04Data data = resolver.parseInput( inputExample );

        boolean isValid = resolver.checkValue( data );

        assertTrue( isValid );

    }

    public static final String INVALID_7 = "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 " +
        "hcl:#cfa07d byr:1929 ";

    @Test
    void checkValue_invalid8() {
        QuizD0401Resolver resolver = new QuizD0401Resolver( "FAKE" );

        Day04Data data = resolver.parseInput( INVALID_7 );

        boolean isValid = resolver.checkValue( data );
        assertFalse( isValid );
    }

    public static final String VALID_NOCID = "hcl:#ae17e1 iyr:2013 " +
        "eyr:2024 " +
        "ecl:brn pid:760753108 byr:1931 " +
        "hgt:179cm ";

    @Test
    void checkValue_validNoCid() {
        QuizD0401Resolver resolver = new QuizD0401Resolver( "FAKE" );

        Day04Data data = resolver.parseInput( VALID_NOCID );

        boolean isValid = resolver.checkValue( data );
        assertTrue( isValid );
    }

    @Test
    void checkValue_validNoCid_2() {
        QuizD0402Resolver resolver = new QuizD0402Resolver( "FAKE" );

        Day04Data data = resolver.parseInput( VALID_NOCID );

        boolean isValid = resolver.checkValue( data );
        assertTrue( isValid );
    }


}