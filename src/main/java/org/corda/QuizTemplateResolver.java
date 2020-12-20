package org.corda;


import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class QuizTemplateResolver<T> implements QuizResolver {


    private final String fileName;
    private Predicate<T> isOk;
    Function<String, T> parse;


    public QuizTemplateResolver(String fileName, Predicate<T> isOk, Function<String, T> parse) {
        this.fileName = fileName;
        this.isOk = isOk;
        this.parse = parse;
    }


    <T> List<T> loadData(String fileName, Function<String, T> parse) throws IOException {
        List<String> stringList = FileHelper.readAllLines( fileName );

        List<T> result = stringList.stream()
            .map( s -> parse.apply( s ) )
            .collect( Collectors.toList() );

        return result;
    }

    @Override
    public long resolve() throws IOException {
        List<T> TList = loadData( fileName, parse );

        return TList.stream()
            .filter( data -> isOk.test( data ) )
            .count();
    }


}
