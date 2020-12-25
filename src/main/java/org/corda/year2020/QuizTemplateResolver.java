package org.corda.year2020;


import org.corda.model.Numerable;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class QuizTemplateResolver<T extends Numerable> implements QuizResolver {


    private final String fileName;
    private final Function<String, List<String>> loadStringList;
    private final Predicate<T> isOk;
    private final Function<String, T> parse;
    private final Function<T, Long> dataValue;



    public QuizTemplateResolver(String fileName,
                                Predicate<T> isOk,
                                Function<String, T> parse,
                                Function<String, List<String>> loadStringList,
                                Function<T, Long> dataValue) {
        this.fileName = fileName;
        this.isOk = isOk;
        this.parse = parse;
        this.loadStringList = loadStringList;
        this.dataValue = dataValue;
    }

    public QuizTemplateResolver(String fileName,
                                Predicate<T> isOk,
                                Function<String, T> parse,
                                Function<String, List<String>> loadStringList) {
        this.fileName = fileName;
        this.isOk = isOk;
        this.parse = parse;
        this.loadStringList = loadStringList;
        this.dataValue = null;
    }

    public List<T> loadData() throws IOException {
        List<String> stringList = loadStringList.apply( fileName );
        List<T> result = parseAllLines( stringList );
        setSequence( result );

        return result;
    }


    private List<T> parseAllLines(List<String> stringList) {
        return stringList.stream()
            .map( s -> parse.apply( s ) )
            .collect( Collectors.toList() );
    }

    // add sequence numer on each value of list
    private void setSequence(List<T> result) {
        int idx = 0;
        for (T data : result) {
            if (data != null) {
                data.setSequence( idx++ );
            }
        }
    }

    @Override
    public long sum() throws IOException {
        List<T> aTList = loadData( );

        return aTList.stream()
            .filter( data -> isOk.test( data ) )
            .map( x -> dataValue.apply(x))
            .reduce(0L, Long::sum);
    }

    @Override
    public long count() throws IOException {
        List<T> aTList = loadData( );

        return aTList.stream()
            .filter( data -> isOk.test( data ) )
            .count();
    }

}
