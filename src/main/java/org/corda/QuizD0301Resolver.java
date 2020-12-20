package org.corda;


import org.corda.model.DayThreeData;

public class QuizD0301Resolver extends QuizD03 {
    private QuizTemplateResolver quizTemplate;


    public QuizD0301Resolver(String fileName) {
        super( fileName );
    }

    @Override
    public boolean checkValue(DayThreeData data) {
        return false;
    }
}
