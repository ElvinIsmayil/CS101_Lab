/*
 * This is a program which calculates the average of the student 
 * based on midterm and final exam scores
 * and then prints them out for the user
 * 
 * @author Elvin Ismayil (22501036)
 * @version 11.10.2025 20:10
 */
import java.util.Scanner;

public class Lab03_Q1 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        // Constants
        final double MIDTERM_PERCENTAGE = 0.4;
        final double FINAL_PERCENTAGE = 0.6;

        Scanner reader = new Scanner(System.in);

        System.out.print("Enter your midterm exam score: ");
        double midtermScore = reader.nextDouble();

        System.out.print("Enter your final exam score: ");
        double finalScore = reader.nextDouble();

        // We calculate the average here with the given formula
        double average = MIDTERM_PERCENTAGE * midtermScore + FINAL_PERCENTAGE * finalScore;

       
        // We determine the letter grade of the student based on the calculated average
        String letterGrade;

        if(average >= 90){
            letterGrade = "AA";
        }
        else if(average >= 85 || average < 90){
            letterGrade = "BA";
        }
        else if(average >= 80 || average < 85){
            letterGrade = "BB";
        }
        else if(average >= 75 || average < 80){
            letterGrade = "CB";
        }
        else if(average >= 70 || average < 75){
            letterGrade = "CC";
        }
        else if(average >= 60 || average < 70){
            letterGrade = "DC";
        }
        else if(average >= 50 || average < 60){
            letterGrade = "DD";
        }
        else{
            letterGrade = "FF";
        }

        // Output the average and letter grade
        String formattedAverage = String.format("%.2f", average );
        System.out.println("Your average is: " + formattedAverage);
        System.out.println("Your letter grade is: " + letterGrade);

        if(letterGrade.equals("FF")){
            System.out.println("You failed the course.");
        }
        else if(finalScore < 50){
            System.out.println("You failed the course due to insufficient final exam score.");
        }
        else{
            System.out.println("You passed the course successfully. Congratulations!");
        }

        // Close the Scanner to prevent memory leak
        reader.close();
    }
}
