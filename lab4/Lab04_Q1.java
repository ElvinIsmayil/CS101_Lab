/**
 * This is a program which asks for a height 
 * from the user and outputs triangle shape 
 * figure at that height for the user
 * 
 * @author Elvin Ismayil (22501036)
 * @version 22.10.2025 00:35
 */

package lab4;

import java.util.Scanner;

public class Lab04_Q1 {

    @SuppressWarnings({ "ConvertToTryWithResources", "resource" })
    public static void main(String[] args) {
        System.out.println("*\n*");
        // Scanner is initialized here
        Scanner input = new Scanner(System.in);


        boolean isValid = false;
        int height= 0; // Assign 0 to suppress the terminal

        while (!isValid) {
            System.out.print("Enter a valid height: ");
            height = input.nextInt();
            if (height > 0 && height < 30) {
                isValid = true;
            } else {
                System.out.println("Invalid input, try again.");
            }

        }

        int i = 0;
        while(i < height){
            int j = 2*i+1;
            int spaceCount = height-i-1;
            String blank = "";
            while(spaceCount > 0){
                blank += ' ';
                spaceCount--;
            }
            System.out.print(blank);
            while (j>0){
                System.out.print('*');
                j--;  
            }
            System.out.print("\n");
            i++;
        }

    }
}
