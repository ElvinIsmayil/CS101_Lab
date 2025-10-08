/*
 * This is a program which calculates the radius, cone, and circumference
 * of the base of the cone with the given formulas and then prints them out
 * 
 * @author Elvin Ismayil (22501036)
 * @version 08.10.2025 09:52
 */
import java.util.Scanner;

public class Lab02_Q1_Revision {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        // Ask the user to enter the volume of the cone
        System.out.print("Enter the volume of the cone: ");
        double volume = reader.nextDouble();   

        // Ask the user to enter the height of the cone
        System.out.print("Enter the height of the cone: ");
        double height = reader.nextDouble();   

        // Calculate the radius of the cone using the formula:
        // r = sqrt((3 * V) / (π * h))
        double radius = Math.sqrt((3 * volume) / (Math.PI * height));

        // Calculate the surface area of the cone using the formula:
        // A = πr(r + √(h² + r²))
        double surfaceArea = Math.PI * radius * (radius + Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)));

        // Calculate the circumference of the base of the cone using the formula:
        // C = 2πr
        double circumference = 2 * Math.PI * radius;

        // Display the radius with 1 decimal place and left-aligned text
        System.out.printf("%-50s %5.1f%n", "The radius of the cone is: ", radius);

        // Display the surface area with 1 decimal place and left-aligned text
        System.out.printf("%-50s %5.1f%n", "The surface area of the cone is: ", surfaceArea);


        // Display the circumference of the base of the cone with 1 decimal place and left-aligned text
        System.out.printf("%-50s %5.1f%n", "The circumference of the base of the cone is: ", circumference);

        // Close the Scanner to prevent memory leak
        reader.close();
    }
}
