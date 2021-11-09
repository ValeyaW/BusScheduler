package ch.modul226.busStation.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private ConsoleReader(){
        super();
    }



    public static int readInteger(String prompt) {

        int value = 0;
        while (true) {
            try {
                System.out.println(prompt + "_>");
                value = Integer.valueOf(reader.readLine()).intValue();
                break;
            } catch (IOException ex) {
                System.out.println("*** Read Error ***");
                System.out.println("***" + ex.getMessage()) ;
                System.exit(1);
            }
            catch(NumberFormatException ex){
                System.out.println("*** Conversion Error ***, try again");
            }
        }
        return value;
    }
    public static String readString(String prompt) {

        String value = "";
        while (true) {
            try {
                System.out.println(prompt + "_>");
                value = String.valueOf(reader.readLine());
                break;
            } catch (IOException ex) {
                System.out.println("*** Read Error ***");
                System.out.println("***" + ex.getMessage()) ;
                System.exit(1);
            }
        }
        return value;
    }
}
