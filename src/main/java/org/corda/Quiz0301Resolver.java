package org.corda;


import org.corda.model.DayThreeData;

import java.util.function.Function;
import java.util.function.Predicate;

public class Quiz0301Resolver extends Quiz<DayThreeData> {
    private QuizTemplateResolver quizTemplate;


    public Quiz0301Resolver(String fileName) {
        super(fileName);

    }

    @Override
    public boolean checkValue(DayThreeData data) {
        return false;
    }

    @Override
    public DayThreeData parseInput(String input) {
        return null;
    }
}
