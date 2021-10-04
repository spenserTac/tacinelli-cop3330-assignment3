package ex44;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static JSONObject create_JSON_obj() throws Exception{
        String users_cwd = System.getProperty("user.dir") + "/src/main/java/ex44";

        Object obj = new JSONParser().parse(new FileReader(users_cwd + "/exercise44_input.json"));
        JSONObject jo = (JSONObject) obj;

        return jo;
    }

    public static String capitalize(String str) {
        if(str == null) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static void find_obj(JSONObject jo) throws Exception{
        JSONArray ja = (JSONArray) jo.get("products");

        Scanner scanner = new Scanner(System.in);
        String product_name;
        int p_found = 0;

        while(true){

            Iterator itr2 = ja.iterator();

            System.out.print("What is the product name? ");
            product_name = scanner.nextLine();

            while (itr2.hasNext()) {
                ArrayList<String> product_attr = new ArrayList<>();

                Iterator<Map.Entry> itr1 = ((Map) itr2.next()).entrySet().iterator();
                while (itr1.hasNext()) {
                    Map.Entry pair = itr1.next();
                    String new_entry = pair.getKey() + " : " + pair.getValue();
                    product_attr.add(new_entry);

                    if (pair.getValue().toString().matches(product_name)) {
                        //System.out.println("Got it");
                        System.out.println(capitalize(pair.getKey().toString()) + " : " + capitalize(pair.getValue().toString()));
                        System.out.print(capitalize(product_attr.get(1)) + "\n" + capitalize(product_attr.get(0)));
                        return;

                    }
                }

            }
            System.out.println("Sorry, that product was not found in our inventory.");
        }


    }

    public static void main(String[] args) throws Exception{
        // Creates a JSON obj based on CWD and file name.
        JSONObject jo = create_JSON_obj();

        // Loop through each entry in the JSON obj, and find the right
        // one based on the users input.
        find_obj(jo);

    }
}
