package org.vanis.bookmarks;

import com.github.rjeschke.txtmark.Processor;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if(args.length != 1){
            System.err.println("Expecting exactly 1 argument " +
                    "containing the filename of markdown file to process");
            System.exit(-1);
        }
        String filename = args[0];
        File mdFile = new File(filename);
        if(!mdFile.exists()){
            System.err.printf("File %s does not exist!", mdFile.getAbsolutePath());
            System.exit(-2);
        }
        try{
            String result = Processor.process(mdFile);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
