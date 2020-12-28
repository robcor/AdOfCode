package org.corda.year2020;


import org.corda.helper.CollectionHelper;
import org.corda.helper.Facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizD1002Resolver {
    private final List<Long> valuesList;

    public QuizD1002Resolver(String fileName) throws IOException {
        this.valuesList = Facade.longFromFile( fileName );
        Collections.sort( this.valuesList );
    }

    public long resolve() {

        List<List<Long>> allCorrectList = new ArrayList<>();
        addUnique( allCorrectList, this.valuesList );
        long lastElement = CollectionHelper.lastElement( this.valuesList );

        List<Long> listIMAIN = this.valuesList;
        for (int i1 = 0; i1 < listIMAIN.size(); i1++) {

            List<Long> listIUNO = removeIx( listIMAIN, i1 );

            if (checkCorrectList( listIUNO, lastElement )) {
                addUnique( allCorrectList, listIUNO );
            }

            for (int i2 = 0 ; i2 < listIUNO.size(); i2++) {
                List<Long> listIDUE = removeIx( listIUNO, i2 );

                if (checkCorrectList( listIDUE, lastElement )) {
                    addUnique( allCorrectList, listIDUE );
                }
                for (int i3 = 0 ; i3 < listIDUE.size(); i3++) {
                    List<Long> listITRE = removeIx( listIDUE, i3 );

                    if (checkCorrectList( listITRE, lastElement )) {
                        addUnique( allCorrectList, listITRE );
                    }

                }
            }

        }


        return allCorrectList.size();
    }

    private void addUnique(List<List<Long>> allCorrectList, List<Long> listI1) {

        if (!contains(allCorrectList,listI1)) {
            allCorrectList.add( listI1 );
        }

    }

    private boolean contains(List<List<Long>> allCorrectList, List<Long> listI1) {
        for (List<Long> elList: allCorrectList) {
            if (elList.equals( listI1 ))
                return true;
        }
        return false;
    }

    private List<Long> removeIx(List<Long> origList, int i) {
        ArrayList<Long> clonedList = new ArrayList<>( origList );
        clonedList.remove( i );

        return clonedList;
    }

    public boolean checkCorrectList(List<Long> list, long lastValue) {
        long formerValue = 0;

        if (CollectionHelper.lastElement( list ) != lastValue)
            return false;

        for (long value : list) {
            long delta = value - formerValue;
            formerValue = value;

            if (delta > 3)
                return false;
        }

        return true;
    }
}
