package org.corda.year2020;

import java.io.IOException;

public interface QuizResolver {
    long count() throws IOException;
    long sum() throws IOException;
}
