package org.corda;

import org.corda.helper.FileHelper;
import org.corda.model.Numerable;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class Quiz<T extends Numerable, C> implements QuizResolver {
    protected QuizTemplateResolver<T> quizTemplate;
    protected C config;

    public Quiz(String fileName, C config) {
        Predicate<T> isOk = s -> checkValue( s );
        Function<String, T> parse = s -> parseInput( s );
        Function<String, List<String>> loadData = s -> loadStringList( s );
        quizTemplate = new QuizTemplateResolver<T>( fileName, isOk, parse, loadData );
        this.config = config;
    }

    // load ine by line
    private List<String> loadStringList(String fileName) {
        return FileHelper.readAllLines( fileName );
    }

    public abstract boolean checkValue(T data);

    public abstract T parseInput(String input);

    @Override
    public long resolve() throws IOException {
        return quizTemplate.resolve();
    }
}
