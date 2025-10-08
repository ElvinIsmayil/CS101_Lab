/*
 * This is a program which asks an input from the user 
 * and then outputs the information in necessary format
 * 
 * @author Elvin Ismayil (22501036)
 * @version 08.10.2025 10:00
 */
import java.util.Scanner;

public class Lab02_Q3 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
         Scanner reader = new Scanner(System.in);

        // Here we get the student info from input
        System.out.print("Enter the student information: ");
        String info = reader.nextLine();

        // Here we find the indexes of symbols
        int hash1 = info.indexOf('#');
        int slash = info.indexOf('/');
        int dash = info.indexOf('-');
        int hash2 = info.lastIndexOf('#');
        int colon = info.indexOf(':');


        // We get substrings and trim them
        String firstName = info.substring(0, hash1).trim();
        String lastName = info.substring(hash1 + 1, slash).trim();
        String department = info.substring(slash + 1, dash).trim();
        String university = info.substring(dash + 1, hash2).trim();
        String hour = info.substring(hash2 + 1, colon).trim();
        String minute = info.substring(colon + 1).trim();

        // Print out the full sentence with format
        System.out.println(firstName + " " + lastName + " registered to " +
                           university + " " + department +
                           " at " + minute + " past " + hour + ".");

        reader.close();

    }
}
