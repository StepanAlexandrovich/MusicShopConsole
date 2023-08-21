package org.example.application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadText {

    public List<String> readLines(String path) {
        List<String> lines = new ArrayList<>();


        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {


            String line;
            while ( (line = bufferedReader.readLine()) != null ){
                lines.add(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }

    public int lastIndex(String path) {
        List<String> lines = new ArrayList<>();

        String line = "";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {


            String buffer;

            while ( ( buffer = bufferedReader.readLine()) != null ){
                line = buffer;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String words[] = line.split(";");

        if(words.length>1){ return Integer.parseInt(words[0]); }

        return 0;
    }
}
