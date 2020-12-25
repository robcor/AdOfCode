package org.corda.helper;


import org.corda.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
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

    public static List<String> readAllLines(String fileName) {
        try (InputStream resource = getInputStream( fileName )) {
            if (resource == null)
                throw new UncheckedIOException( "'" + fileName + "'" + ": file not found", new IOException( "wrapper" ) );

            List<String> stringList =
                new BufferedReader(
                    new InputStreamReader( resource, StandardCharsets.UTF_8 ) )
                    .lines()
                    .collect( Collectors.toList() );

            return stringList;
        } catch (IOException ioe) {
            return new ArrayList<>();
        }
    }

    public static List<String> readLinesDividedByCr(String fileName) {
        List<String> singleLines = readAllLines( fileName );
        List<String> result = new ArrayList<>();

        Iterator<String> iter = singleLines.iterator();

        String nextElement = "";
        while (iter.hasNext()) {
            String next = iter.next();
            if (next.isEmpty()) {
                result.add( nextElement.trim() );
                nextElement = "";
            } else {
                nextElement = nextElement + " " + next;
            }
        }

        if (!nextElement.isEmpty()) {
            result.add( nextElement.trim() );
        }

        return result;
    }
}
