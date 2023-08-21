package org.example.application;


import java.io.*;

public class WriteText {
    public void write(String path,String text){

        try(BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(path,true) )) {

            bufferedWriter.write(text);
            bufferedWriter.newLine();
            bufferedWriter.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
