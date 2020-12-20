package org.corda;

import org.corda.model.DayThreeData;

import java.io.IOException;

public abstract class Quiz<T> implements QuizResolver {
    protected QuizTemplateResolver<T> quizTemplate;

    protected abstract boolean checkValue(T data);

    protected abstract DayThreeData parseInput(String input);

    @Override
    public long resolve() throws IOException {
        return quizTemplate.resolve();
    }
}
