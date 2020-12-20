import org.corda.QuizD0201Resolver;
import org.corda.QuizTemplateResolver;
import org.corda.model.DayThreeData;
import org.corda.model.DayTwoData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class QuizTemplateResolverTest {

    @Test
    void loadData() throws Exception {
        QuizTemplateResolver<DayThreeData> resolver = makeDummyTemplateResolver();

        List<DayThreeData> dataList = resolver.loadData();
        
        assertEquals(  6, dataList.size());
        assertEquals(  "200", dataList.get( 5 ).getInput());
        assertEquals(  5, dataList.get( 5 ).getSequence());

    }

    private QuizTemplateResolver<DayThreeData> makeDummyTemplateResolver() {
        Predicate<DayThreeData> isOk = s -> false;
        Function<String, DayThreeData> parse = s -> new DayThreeData( s );
        QuizTemplateResolver<DayThreeData> templateResolver = new QuizTemplateResolver<DayThreeData>(
            "testNumberList.txt",
            isOk,
            parse );

        return templateResolver;
    }
}
