package org.corda.year2020;

import org.corda.helper.FileHelper;
import org.corda.year2020.model.Day06Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuizD0602Resolver implements QuizResolver {
    private final String filename;
    private QuizTemplateResolver<Day06Data> templateResolver;

    public QuizD0602Resolver(String fileName) {
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
        Set<String> questionAnsweredByAll = null;

        List<Set<String>> listOfAnswer = new ArrayList<>(  ) ;
        String[] userAnswerArray = groupAnswers.split(" ");

        for (int i = 0; i < userAnswerArray.length; i++) {
            String  userAnswer =  userAnswerArray[i];
            listOfAnswer.add(stringToSet( userAnswer ));
        }

        HashSet<String> startSet = new HashSet<String>( listOfAnswer.get( 0 ) );
        questionAnsweredByAll = listOfAnswer.stream().reduce(startSet, (x, y) -> {
            x.retainAll( y );
            return x;
        });

        return new Day06Data( questionAnsweredByAll );
    }

    private Set<String>  stringToSet(String userAnswer) {
        Set<String> userAswerSet = new HashSet<String>();
        for (int j = 0; j < userAnswer.length(); j++) {
            char c = userAnswer.charAt( j );
            String answer = String.valueOf( c );

            if (c != ' ') {
                userAswerSet.add( answer );
            }
        }

        return userAswerSet;
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

