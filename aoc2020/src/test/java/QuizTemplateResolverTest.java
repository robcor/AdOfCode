import org.corda.year2020.QuizTemplateResolver;
import org.corda.helper.FileHelper;
import org.corda.year2020.model.Day03Data;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class QuizTemplateResolverTest {

    @Test
    void loadData() throws Exception {
        QuizTemplateResolver<Day03Data> resolver = makeDummyTemplateResolver();

        List<Day03Data> dataList = resolver.loadData();

        assertEquals( 6, dataList.size() );
        assertEquals( "200", dataList.get( 5 ).getInput() );
        assertEquals( 5, dataList.get( 5 ).getSequence() );

    }

    private QuizTemplateResolver<Day03Data> makeDummyTemplateResolver() {
        Predicate<Day03Data> isOk = s -> false;
        Function<String, Day03Data> parse = s -> new Day03Data( s );
        QuizTemplateResolver<Day03Data> templateResolver = new QuizTemplateResolver<Day03Data>(
            "testNumberList.txt",
            isOk,
            parse, s -> FileHelper.readAllLines( s ) );

        return templateResolver;
    }
}
