package org.corda.helper;


import java.util.Collections;
import java.util.List;

public class CollectionHelper {
    private CollectionHelper() {
        throw new IllegalStateException( "Utility class" );
    }

    public static <T> T lastElement(List<T> list) {
        return list.get( list.size() - 1 );
    }

    public static <T> T firstElement(List<T> list) {
        return list.get( 0 );
    }

    public static long smallestElement(List<Long> sumList) {
        Collections.sort( sumList );
        return firstElement( sumList );
    }

    public static long largerElement(List<Long> sumList) {
        Collections.sort( sumList );
        return lastElement( sumList );
    }
}
