package ex45;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static BufferedReader create_read_file() throws Exception{
        String dir = System.getProperty("user.dir");
        File temp_in_file = new File(dir + "/src/main/java/ex45/exercise45_input.txt");

        BufferedReader in_file = new BufferedReader(new FileReader(temp_in_file));
        return in_file;
    }

    public static void replace_word(BufferedReader in_file) throws Exception{
        ArrayList<String> words = new ArrayList<>();
        String current_line;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of output file: ");
        String output_f_name = scanner.nextLine();

        String dir = System.getProperty("user.dir");
        PrintWriter writer = new PrintWriter(dir + "/src/main/java/ex45/" +
                output_f_name + ".txt", "UTF-8");

        while((current_line = in_file.readLine()) != null){
            String[] words_in_line = current_line.split(" ");

            for(String wordd: words_in_line){
                //System.out.println("-- " + wordd + " --");
            }

            for(int i = 0; i < words_in_line.length; i++){
                //System.out.printf("- %s -\n", words_in_line[i]);
                if(words_in_line[i].matches(".*utilize.*")){ //   \^
                    words_in_line[i] = "use";
                }
            }



            String new_line = "";
            for(int l = 0; l < words_in_line.length; l++){
                new_line += " " + words_in_line[l];
            }

                writer.printf("%s\n", new_line);
                System.out.printf("%s\n", new_line);

        }

        writer.close();
        in_file.close();
    }

    public static void main(String[] args) throws Exception{
        // Get input file.
        BufferedReader in_file = create_read_file();

        // Go through each word, for each instance of 'utilize',
        // it'll be replaced with 'use'.
        replace_word(in_file);
    }
}
