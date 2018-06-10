import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import db.Database;

public class Main {
    private static final String EXIT   = "exit";
    private static final String PROMPT = "> ";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Database db = new Database();
        System.out.println("\nWelcome to use this tiny DBMS to manage YOUR data tables, HAVE FUN!\n" +
                "type 'help' if you want to know the supported functions\n" +
                "type 'exit' if you want to quit the program");
        System.out.print(PROMPT);

        String line = "";
        while ((line = in.readLine()) != null) {
            if (EXIT.equals(line)) {
                break;
            }

            if (!line.trim().isEmpty()) {
                String result = db.transact(line);
                if (result.length() > 0) {
                    System.out.println(result);
                }
            }
            System.out.print(PROMPT);
        }

        in.close();
    }
}
