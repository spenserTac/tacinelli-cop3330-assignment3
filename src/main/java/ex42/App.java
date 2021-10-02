package ex42;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class App {
    public static BufferedReader create_read_file() throws Exception{
        String dir = System.getProperty("user.dir");
        File temp_in_file = new File(dir + "/src/main/java/ex42/exercise42_input.txt");

        BufferedReader in_file = new BufferedReader(new FileReader(temp_in_file));
        return in_file;
    }

    public static void parse_data(BufferedReader in_file) throws Exception{
        System.out.printf("%-9s %-9s %-9s\n--------------------------\n", "Last", "First", "Salary");
        String current_line;
        while((current_line = in_file.readLine()) != null){
            String[] words_in_line = current_line.split(",");

            System.out.printf("%-9s %-9s %-9s\n", words_in_line[0], words_in_line[1],
                    words_in_line[2]);

        }
    }

    public static void main(String[] args) throws Exception{
        // Get in data file
        BufferedReader in_file = create_read_file();

        // Parse the data and display.
        parse_data(in_file);
    }
}
