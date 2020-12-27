package org.corda.year2020;

import org.corda.year2020.helper.FileHelper;
import org.corda.year2020.model.Day06Data;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class QuizD0601Resolver implements QuizResolver {
    private final String filename;
    private QuizTemplateResolver<Day06Data> templateResolver;

    public QuizD0601Resolver(String fileName) {
        this.filename = fileName;
        templateResolver =
            new QuizTemplateResolver<>(
                this.filename,
                isOk -> true,
                groupAnswers -> parseGroup( groupAnswers ),
                fName -> FileHelper.readLinesDividedByCr( fName ),
                data -> value( data )
            );
    }

    private Long value(Day06Data data) {
        return Long.valueOf( data.getAnswers().size() );
    }

    private Day06Data parseGroup(String groupAnswers) {

        Set<String> questionAnsweredBySomeone = new HashSet<>();
        for (int i = 0; i < groupAnswers.length(); i++) {
            char c = groupAnswers.charAt( i );
            String answer = String.valueOf( c );

            if (c != ' ') questionAnsweredBySomeone.add( answer );
        }
        return new Day06Data( questionAnsweredBySomeone );
    }

    @Override
    public long count() throws IOException {
        return templateResolver.count();
    }

    @Override
    public long sum() throws IOException {
        return templateResolver.sum();
    }

}

