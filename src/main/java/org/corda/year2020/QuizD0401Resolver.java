package org.corda;

import org.corda.model.Day04Data;

public class QuizD0401Resolver extends QuizD04 {

    public QuizD0401Resolver(String fileName) {
        super( fileName );
    }

    @Override
    public boolean checkValue(Day04Data data) {


        if (data == null) {
            return false;
        }

        if (data.getByr() != null &&
            data.getEcl() != null &&
            data.getEyr() != null &&
            data.getHcl() != null &&
            data.getHgt() != null &&
            data.getIyr() != null &&
            data.getPid() != null
        ) {
            return true;
        } else {
            return false;
        }
    }

}
