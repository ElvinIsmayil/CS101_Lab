/**
 * This is a program which simulates theather seat 
 * arrangement system where the user is asked to input
 * the rows and columns first and then the groups of people
 * who needs to be seated. Finally, calculations are made to
 * print out the final grid of the theater 
 * 
 * @author Elvin Ismayil (22501036)
 * @version 17.11.2025 15:48
 */

package lab6;

import java.util.Scanner;

public class Lab06_Q1 {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        // We initialize variables here
        Scanner input = new Scanner(System.in);

        // We ask the user to input the rows, colums and then the 
        // groups for these arrangement
        System.out.print("Enter number of rows: ");
        int noOfRows = input.nextInt();
        System.out.print("Enter number of columns: ");
        int noOfColumns = input.nextInt();

        char[][] theater = new char[noOfRows][noOfColumns];

        // We initialize the theater with empty seats according to the 
        // given column and row values
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                theater[i][j] = '-';
            }
        }

        System.out.print("Enter the groups for " + noOfRows + " rows " + " and " + noOfColumns + " columns: ");
        // We use nextline here to move the cursor to new line 
        input.nextLine();

        // We split the integers by comma into a new array
        String line = input.nextLine();
        String[] parts = line.split(",");
        // We validate the input so that the number of groups provided matches the noOfRows we have
        if (parts.length < noOfRows) {
            System.out.println("Error: Expected " + noOfRows + "group sizes but got " + parts.length);
            return;
        }

        int[] groups = new int[noOfRows];

        // Then we assign values from that string parts array to our
        // main groups array
        for (int i = 0; i < noOfRows; i++) {
            String number = parts[i].trim();
            int num = Integer.parseInt(number);
            if (num > noOfColumns) {
                System.out.println("Error: group size " + num + " exceeds columns " + noOfColumns + "in row " + i);
                return;
            } else {
                groups[i] = num;
            }
        }

        // Here we make calculations to make sure in each row groups
        // are allocated so that minimum spacing is maximized
        for (int r = 0; r < noOfRows; r++) {
            int k = groups[r];
            // If there is only 1 person then he can sit in the first seat 
            // of that row
            if (k == 1) {
                theater[r][0] = 'x';
            } else {
                // We make use of the given formulas to calculate the gap sizes and remainder
                int gap = (noOfColumns - 1) / (k - 1);
                // This is set 0 because we start from the first seat
                int currentPosition = 0;
                theater[r][currentPosition] = 'x';
                int remainder = (noOfColumns - 1) % (k - 1);
                for (int i = 1; i < k; i++) {
                    // We move the next person's seat according to the base gap which we calculated
                    currentPosition += gap;
                    if (remainder > 0) {
                        currentPosition++;
                        remainder--;
                    }
                    theater[r][currentPosition] = 'x';
                }
            }
        }

        // We print out the final result
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                System.out.print(theater[i][j] + " ");
            }
            System.out.println("");
        }

        input.close();
    }

}
