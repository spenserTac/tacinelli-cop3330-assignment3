package ex43;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void create_website_template(ArrayList<String> inputs) throws Exception{
        String users_cwd = System.getProperty("user.dir") + "/src/main/java/ex43";
        // inputs = {site_name, author, js (y/n), css (y/n)}

        Files.createDirectories(Paths.get(users_cwd + "/website/" + inputs.get(0)));
        System.out.println("Created ./website/" + inputs.get(0));

        String html_output_file_name = users_cwd + "/website/" + inputs.get(0) + "/index.html";
        PrintWriter html_output_file = new PrintWriter(html_output_file_name, "UTF-8");

//        String html_string = String.format("<title>%s</title>\n<meta>%s</meta>", inputs.get(0),
//                inputs.get(1));
        html_output_file.println("<title>" + inputs.get(0) + "</title>\n<meta>" +
                inputs.get(1) + "</meta>");
        html_output_file.close();

        //<html><head><title>New Page</title></head><body><p>This is Body</p></body></html>

        System.out.printf("Created ./website/%s/index.html\n", inputs.get(0));

        if(inputs.get(2).matches("y")){
            String js_output_file_name = users_cwd + "/website/" + inputs.get(0) + "/js\n";
            //new File(js_output_file_name).mkdirs();
            Files.createDirectories(Paths.get(js_output_file_name));
            System.out.printf("Created ./website/%s/js/\n", inputs.get(0));
        }

        if(inputs.get(3).matches("y")){
            String css_output_file_name = users_cwd + "/website/" + inputs.get(0) + "/css";
            //new File(css_output_file_name).mkdirs();
            Files.createDirectories(Paths.get(css_output_file_name));
            System.out.printf("Created ./website/%s/css/", inputs.get(0));
        }
    }

    public static ArrayList<String> get_users_input_for_site(){
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> values = new ArrayList<String>();

        System.out.print("Site name: ");
        String site_name = scanner.nextLine();
        values.add(site_name);

        System.out.print("Author: ");
        String author_name = scanner.nextLine();
        values.add(author_name);

        System.out.print("Do you want a folder for JavaScript? ");
        String js_file_answer = scanner.nextLine();
        values.add(js_file_answer);

        System.out.print("Do you want a folder for CSS? ");
        String css_file_answer = scanner.nextLine();
        values.add(css_file_answer);
        
        return values;
    }

    public static void main(String[] args) throws Exception{
        // Getting input from user.
        ArrayList<String> user_input_values = get_users_input_for_site();

        // Create the file to output and display status.
        create_website_template(user_input_values);





//        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//        bw.write("<html><head><title>New Page</title></head><body><p>This is Body</p></body></html>");
//        bw.close();
    }
}
