package com.app.io;

import java.io.*;

public class TryWithResourceExample {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new StringReader("This is an example"));
            StringWriter writer = new StringWriter();) {

            writer.write(reader.readLine());
            System.out.println(writer.toString());
        }catch (IOException ex) {

        }
    }
}
