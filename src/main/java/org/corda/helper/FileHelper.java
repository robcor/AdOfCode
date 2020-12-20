package org.corda.helper;


import org.corda.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;


public class FileHelper {

    private FileHelper() {
        throw new IllegalStateException( "Utility class" );
    }

    public static InputStream getInputStream(String fileName) {
        String addRoot = "/" + fileName;
        InputStream stream = Main.class.getResourceAsStream( addRoot );

        return stream;
    }

    public static List<String> readAllLines(String fileName) throws IOException {
        try (InputStream resource = getInputStream( fileName )) {
            if (resource == null)
                throw new IOException( "'" + fileName + "'"+ ": file not found" );

            List<String> stringList =
                new BufferedReader(
                    new InputStreamReader( resource, StandardCharsets.UTF_8 ) )
                    .lines()
                    .collect( Collectors.toList() );

            return stringList;
        }
    }
}
