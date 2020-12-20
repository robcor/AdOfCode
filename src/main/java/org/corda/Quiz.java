package org.corda;

import org.corda.model.Numerable;

import java.io.IOException;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class Quiz<T extends Numerable, C> implements QuizResolver {
    protected QuizTemplateResolver<T> quizTemplate;

    public Quiz(String fileName, C config) {
        Predicate<T> isOk = s -> checkValue( s , config);
        Function<String, T> parse = s -> parseInput( s );
        quizTemplate = new QuizTemplateResolver<T>( fileName, isOk, parse);
    }

    public abstract boolean checkValue(T data, C config);

    public abstract T parseInput(String input);

    @Override
    public long resolve() throws IOException {
        return quizTemplate.resolve();
    }
}
