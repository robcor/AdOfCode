package org.corda.year2020.model;


import java.util.Set;

public class Day06Data extends Numerable {
    Set<String> answers;

    public Day06Data(Set<String> answers) {
        this.answers = answers;
    }

    public Set<String> getAnswers() {
        return answers;
    }
}
