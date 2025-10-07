import java.util.Scanner;

public class Lab02_Q2 {
    public static void main(String[] args) {

        // Gravitational accelerations constants at different altitudes (in m/s^2)
        final double g0 = 9.80665;
        final double g10 =  9.77594;
        final double g100 =  9.5059;
        final double g1000 =  7.32628;


        Scanner reader = new Scanner(System.in);

        // Here user is asked to input masses of 2 objects
        System.out.print("Enter the mass of the first object(kg): ");
        double mass1 = reader.nextDouble();

        System.out.print("Enter the mass of the second object(kg): ");
        double mass2 = reader.nextDouble();

        
        // We calculate weights here 
        double w1_0 = mass1 * g0;
        double w1_10 = mass1 * g10;
        double w1_100 = mass1 * g100;
        double w1_1000 = mass1 * g1000;

        double w2_0 = mass2 * g0;
        double w2_10 = mass2 * g10;
        double w2_100 = mass2 * g100;
        double w2_1000 = mass2 * g1000;

        // Print header
        System.out.printf("%n%16s%10s%10s%10s%10s%n", "", "0km", "10km", "100km", "1000km");

        // Print each object’s weights 
        System.out.printf("OBJECT ONE(%5.1fkg)%10.1f%10.1f%10.1f%10.1f%n",
                mass1, w1_0, w1_10, w1_100, w1_1000);
        System.out.printf("OBJECT TWO(%5.1fkg)%10.1f%10.1f%10.1f%10.1f%n",
                mass2, w2_0, w2_10, w2_100, w2_1000);

        reader.close();



    }
}
