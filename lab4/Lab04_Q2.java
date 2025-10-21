/**
 * This is a program which inputs a number
 * from user and then checks whether it is
 * palindrome or not and outputs answer accordingly
 * 
 * @author Elvin Ismayil (22501036)
 * @version 22.10.2025 00:35
 */
package lab4;

import java.util.Scanner;

public class Lab04_Q2 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);

        boolean isPalindrome = true;
        int number;

        do { 
            System.out.print("Enter a positive integer (0 to quit): ");
            number = input.nextInt();
            if(number < 0){
                System.out.println("Only positive integers are allowed.");
            }
            if(number==0){
                break;
            }

            String numberString = String.format("%d", number);
            for (int i = 0; i < numberString.length(); i++) {
               if(numberString.charAt(i) != numberString.charAt(numberString.length() - i - 1)){
                    isPalindrome = false;
                    break;
               }
                }

            if(isPalindrome){
                System.out.println(number + " is a palindrome.");
            }   
            else{
                System.out.println(number + " is not a palindrome.");
            }
            
            
        } while (number != 0);

    
    }
    
}
