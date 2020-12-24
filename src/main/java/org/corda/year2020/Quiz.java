package org.corda.year2020;

import org.corda.model.Numerable;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class Quiz<T extends Numerable, C> implements QuizResolver {
    protected QuizCounterTemplateResolver<T> quizTemplate;
    protected C config;

    public Quiz(String fileName, C config, Function<String, List<String>> readFile) {
        Predicate<T> isOk = s -> checkValue( s );
        Function<String, T> parse = s -> parseInput( s );
        // Function<String, List<String>> readFile = s -> loadStringList( s );
        quizTemplate = new QuizCounterTemplateResolver<T>( fileName, isOk, parse, readFile );
        this.config = config;
    }

    // load line by line
    /*
    private List<String> loadStringList(String fileName) {
        return FileHelper.readAllLines( fileName );
    }
    */

    public abstract boolean checkValue(T data);

    public abstract T parseInput(String input);

    @Override
    public long counter() throws IOException {
        return quizTemplate.counter();
    }
}
