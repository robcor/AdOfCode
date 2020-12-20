package org.corda;


import org.corda.helper.FileHelper;
import org.corda.model.Numerable;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class QuizTemplateResolver<T extends Numerable> implements QuizResolver {


    private final String fileName;
    private Predicate<T> isOk;
    private Function<String, T> parse;


    public QuizTemplateResolver(String fileName, Predicate<T> isOk, Function<String, T> parse) {
        this.fileName = fileName;
        this.isOk = isOk;
        this.parse = parse;
    }


    public List<T> loadData() throws IOException {
        List<String> stringList = loadStringList(  );
        List<T> result = parseAllLines( stringList );
        setSequence( result );

        return result;
    }

    private List<String> loadStringList() throws IOException {
        return FileHelper.readAllLines( fileName );
    }

    private List<T> parseAllLines(List<String> stringList) {
        return stringList.stream()
            .map( s -> parse.apply( s ) )
            .collect( Collectors.toList() );
    }

    // add sequence numer on each value of list
    private void setSequence(List<T> result) {
        int idx = 0;
        for (T data : result) data.setSequence( idx++ );
    }

    @Override
    public long resolve() throws IOException {
        List<T> aTList = loadData( );

        return aTList.stream()
            .filter( data -> isOk.test( data ) )
            .count();
    }


}
