package org.corda;


import org.corda.model.DayThreeData;

public class Quiz0301Resolver extends Quiz03 {
    private QuizTemplateResolver quizTemplate;


    public Quiz0301Resolver(String fileName) {
        super( fileName );
    }

    @Override
    public boolean checkValue(DayThreeData data) {
        return false;
    }
}
