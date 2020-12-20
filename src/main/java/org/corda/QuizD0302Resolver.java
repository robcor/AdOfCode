package org.corda;


import org.corda.model.DayThreeData;

public class QuizD0302Resolver extends QuizD03 {

    public QuizD0302Resolver(String fileName) {
        super( fileName );
    }

    @Override
    public boolean checkValue(DayThreeData data) {
        return false;
    }
}
