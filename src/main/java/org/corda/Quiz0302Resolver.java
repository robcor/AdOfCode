package org.corda;


import org.corda.model.DayThreeData;

public class Quiz0302Resolver extends Quiz03 {

    public Quiz0302Resolver(String fileName) {
        super( fileName );
    }

    @Override
    public boolean checkValue(DayThreeData data) {
        return false;
    }
}
