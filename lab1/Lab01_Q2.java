 /* 
 * A simple program that calculates equations and
 * outputs the answers accordinglys
 *
 */
public class Lab01_Q2 {
    public static void main(String[] args) {
        // First expression
        double x = (23.2 - 7.1 / 2.2) / ((5.1 - 3.7) * (3.4 + 4.2));

        // Second expression
        double y = (35.7 * 64.1 - Math.pow(6.0, 3)) / (43 + Math.pow(5, 2));

        // Third expression
        double z = Math.pow((2.1 + 8.0), -1.0 / 3.0);
    
        System.out.println("answer1 is: " + x);
        System.out.println("answer1 is: " + y);
        System.out.println("answer1 is: " + z);
    }
}
