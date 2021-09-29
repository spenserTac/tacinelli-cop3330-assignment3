package ex41;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;


public class App {
    public static BufferedReader create_read_file() throws Exception{
        String dir = System.getProperty("user.dir");
        File temp_in_file = new File(dir + "/src/main/java/ex41/exercise41_input.txt");

        BufferedReader in_file = new BufferedReader(new FileReader(temp_in_file));
        return in_file;
    }

    public static ArrayList<String[]> list_of_name(BufferedReader file) throws Exception{
        ArrayList<String[]> names = new ArrayList<>();

        String name;
        while((name = file.readLine()) != null){
            String[] split_name = name.split(",");    // {"first", "last"}

            names.add(split_name);

        }

        int n = names.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                //System.out.println("-- " + names.get(j)[1] + " < " + names.get(j + 1)[1]);
                if (names.get(j)[0].compareTo(names.get(j + 1)[0]) > 0) // first should be before
                {

                    // swap arr[j+1] and arr[j]
                    String[] temp = names.get(j);
                    names.set(j, names.get(j + 1));// = names.get(j+1);
                    names.set(j + 1, temp);
                }
            }
        }
        return names;
    }



    public static void main(String[] args) throws Exception{
        // Getting and creating the read file.
        BufferedReader in_file = create_read_file();

        // Creating a list of the names and sorting them.
        ArrayList<String[]> names = list_of_name(in_file);

        System.out.printf("Total of %d name\n-----------------\n", names.size());

        String dir = System.getProperty("user.dir");

        PrintWriter writer = new PrintWriter(dir + "/src/main/java/ex41/exercise41_output.txt", "UTF-8");

        writer.println("Total of " + names.size() + " names\n-----------------");

        for(int i = 0; i < names.size(); i++){
            String new_name = names.get(i)[0] + ", " + names.get(i)[1];
            writer.println(new_name);
        }

        writer.close();
        in_file.close();
    }
}
