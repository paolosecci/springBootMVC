package com.shelf.book;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileRenderer {

    public FileRenderer(){

    }

    public String renderContent(String htmlFile) {
        try {
            // If you are using maven then your files
            // will be in a folder called resources.
            // getResource() gets that folder
            // and any files you specify.
            System.out.println("rendering template: Cabo");

            URL url = getClass().getResource(htmlFile);
            System.out.println("got file: Veracruz");
            System.out.println(url);
            // Return a String which has all
            // the contents of the file.
            Path path = Paths.get(url.toURI());
            System.out.println("got the path: CDMX");
            return new String(Files.readAllBytes(path), Charset.defaultCharset());
        } catch (IOException | URISyntaxException e) {
            return "Error Code: Jamaica";
        }
    }
}