package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Spenser Tacinelli
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class App {
    public static BufferedReader create_read_file() throws Exception{
        String dir = System.getProperty("user.dir");
        File temp_in_file = new File(dir + "/src/main/java/ex46/exercise46_input.txt");

        BufferedReader in_file = new BufferedReader(new FileReader(temp_in_file));
        return in_file;
    }

    public static void word_frequency(BufferedReader in_file) throws Exception{
        TreeMap<String, Integer> words_freq = new TreeMap<String, Integer>();

        String current_line;
        while((current_line = in_file.readLine()) != null) {
            String[] words_in_line = current_line.split(" ");

            for(int i = 0; i < words_in_line.length; i++){
                if(words_freq.containsKey(words_in_line[i])){
                    int prev_freq = words_freq.get(words_in_line[i]);

                    words_freq.put(words_in_line[i], prev_freq+=1);
                }else{
                    words_freq.put(words_in_line[i], 1);
                }

            }
        }
       // NavigableMap<String, Integer> nmap = words_freq.;
        for(Map.Entry<String, Integer> entry : words_freq.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            System.out.printf("%s: ", key);
            for(int i = 0; i < value; i++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception{
        //Get input file
        BufferedReader in_file = create_read_file();

        //Go through each word, and find its frequency.
        word_frequency(in_file);
    }
}
