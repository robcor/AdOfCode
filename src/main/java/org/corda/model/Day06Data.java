package org.corda.model;


import java.util.Set;

public class Day06Data extends Numerable {
    Set<String> answers;

    public Day06Data(Set<String> questionAnsweredBySomeone) {
        this.answers = questionAnsweredBySomeone;
    }

    public Set<String> getAnswers() {
        return answers;
    }
}
