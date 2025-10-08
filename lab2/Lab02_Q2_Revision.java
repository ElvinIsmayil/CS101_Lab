/*
 * This is a program which calculates the mass
 * of the object based on the given altitude and then
 * outputs the weights in different altitudes
 * 
 * @author Elvin Ismayil (22501036)
 * @version 08.10.2025 10:07
 */
import java.util.Scanner;

public class Lab02_Q2_Revision {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        // Gravitational accelerations constants at different altitudes (in m/s^2)
        final double g0 = 9.80665;
        final double g10 = 9.77594;
        final double g100 = 9.5059;
        final double g1000 = 7.32628;

        Scanner reader = new Scanner(System.in);

        // Here user is asked to input masses of 2 objects
        System.out.print("Enter the weight of the first object at an altitude of 1000 km (Newton): ");
        double weight1 = reader.nextDouble();

        System.out.print("Enter the weight of the second object at an altitude of 1000 km (Newton): ");
        double weight2 = reader.nextDouble();

        // If we are given weigh object at an altitude of 1000 km then we need to first find the mass and then calculate weights accordingly.
        // Weight = mass * gravitational acceleration
        // Then we find mass of the object from the given formula which gives us   mass = weight / gravitational acceleration
        double mass1 = weight1 / g1000;

        double weight1AtZeroAlt = mass1 * g0;
        double weight1AtTenAlt = mass1 * g10;
        double weight1AtHundredAlt = mass1 * g100;
        double weight1AtThousandAlt = mass1 * g1000;

        double mass2 = weight2 / g1000;

        double weight2AtZeroAlt = mass2 * g0;
        double weight2AtTenAlt = mass2 * g10;
        double weight2AtHundredAlt = mass2 * g100;
        double weight2AtThousandAlt = mass2 * g1000;

        // Print header
        System.out.printf("%31s%10s%10s%10s%10s%n", "", "0km", "10km", "100km", "1000km");

        // Print each object’s weights 
        System.out.printf("%11sOBJECT ONE(%5.1f kg)%10.1f%10.1f%10.1f%10.1f \n","", mass1, weight1AtZeroAlt, weight1AtTenAlt, weight1AtHundredAlt, weight1AtThousandAlt);
        System.out.printf("%11sOBJECT TWO(%5.1f kg)%10.1f%10.1f%10.1f%10.1f ","", mass2, weight2AtZeroAlt, weight2AtTenAlt, weight2AtHundredAlt, weight2AtThousandAlt);

        reader.close();

    }
}
