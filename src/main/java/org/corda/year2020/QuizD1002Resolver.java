package org.corda.year2020;


import org.corda.helper.CollectionHelper;
import org.corda.helper.Facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizD1002Resolver {
    private final List<Long> valuesList;
    private final Long adapterValue;
    private List<List<Long>> allCorrectList;

    public QuizD1002Resolver(String fileName) throws IOException {
        this.valuesList = Facade.longFromFile( fileName );
        Collections.sort( this.valuesList );

        this.adapterValue = CollectionHelper.lastElement( this.valuesList ) + 3;
        valuesList.add( this.adapterValue );

        this.allCorrectList = new ArrayList<>();

    }

    public long resolve() {


        List<Long> listIMAIN = this.valuesList;

        addUnique( listIMAIN );
        for (int i1 = 0; i1 < listIMAIN.size(); i1++) {
            List<Long> listIUNO = addRemoveN( listIMAIN, i1 );
            int b = 25;
            for (int i2 = 0; i2 < listIUNO.size(); i2++) {
                List<Long> listIDUE = addRemoveN( listIUNO, i2 );
                for (int i3 = 0; i3 < listIDUE.size(); i3++) {
                    List<Long> listITRE = addRemoveN( listIDUE, i3 );
                    int a = 2;
                }
            }
        }


        return allCorrectList.size();
    }

    public long testPerm() {


        List<Long> listIMAIN = this.valuesList;

        addUnique( listIMAIN );
        for (int i1 = 0; i1 < listIMAIN.size(); i1++) {
            List<Long> listIUNO = addRemoveNAll( listIMAIN, i1 );
            int b = 25;
            for (int i2 = 0; i2 < listIUNO.size(); i2++) {
                List<Long> listIDUE = addRemoveNAll( listIUNO, i2 );
                for (int i3 = 0; i3 < listIDUE.size(); i3++) {
                    List<Long> listITRE = addRemoveNAll( listIDUE, i3 );
                    int a = 2;
                }
            }
        }


        return allCorrectList.size();
    }

    private List<Long> addRemoveN(List<Long> outerList, int i1) {
        List<Long> innerList = removeIx( outerList, i1 );

        if (checkCorrectList( innerList, this.adapterValue )) {
            addUnique( innerList );
        }
        return innerList;
    }

    private List<Long> addRemoveNAll(List<Long> outerList, int i1) {
        List<Long> innerList = removeIx( outerList, i1 );

        this.allCorrectList.add( innerList );

        return innerList;
    }

    private void addUnique(List<Long> list) {
        if (!contains( this.allCorrectList, list )) {
            this.allCorrectList.add( list );
        }
    }

    private boolean contains(List<List<Long>> allCorrectList, List<Long> listI1) {
        for (List<Long> elList : allCorrectList) {
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

        if (CollectionHelper.lastElement( list ) != lastValue)
            return false;

        long formerValue = 0;
        for (long value : list) {
            long delta = value - formerValue;
            formerValue = value;

            if (delta > 3)
                return false;
        }

        return true;
    }
}
