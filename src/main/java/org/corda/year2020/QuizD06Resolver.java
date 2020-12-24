package org.corda.year2020;

import org.corda.helper.FileHelper;

import java.util.List;

public class QuizD06Resolver {
    private final String filename;

    public QuizD06Resolver(String fileName) {
        this.filename = fileName;
    }

    public long count() {
        return 0;
    }

    private List<String> loadLines() {
        return FileHelper.readLinesDividedByCr( filename );
    }
}

