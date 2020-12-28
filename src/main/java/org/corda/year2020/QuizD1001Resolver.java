package org.corda.year2020;

import org.corda.helper.Facade;

import java.io.IOException;
import java.util.List;

public class QuizD1001Resolver {
    private final List<Long> valuesList;
    public QuizD1001Resolver(String fileName) throws IOException {
        this.valuesList = Facade.longFromFile( fileName );
    }

    public long resolve() {
        return 0;
    }
}
