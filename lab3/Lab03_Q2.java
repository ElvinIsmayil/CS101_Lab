/*
 * This is a program which calculates the eligibilty score of the applicant 
 * based on the provided information such as age,
 * annual income, credit score, number of existing cards 
 * and monthly rent payment
 * 
 * @author Elvin Ismayil (22501036)
 * @version 11.10.2025 20:13
 */
import java.util.Scanner;

public class Lab03_Q2 {
    public static void main(String[] args) {
        // Constants
        final int BASE_ELIGIBILITY_SCORE = 100;

        Scanner reader = new Scanner(System.in);


        // User's information is collected here
        System.out.print("Enter the applicant's age: ");
        int age = reader.nextInt();

        System.out.print("Enter the applicant's annual income: ");
        int annualIncome = reader.nextInt();

        System.out.print("Enter the applicant's credit score: ");
        int creditScore = reader.nextInt();

        System.out.print("Enter the number of existing cards: ");
        int noOfExistingCards = reader.nextInt();

        System.out.print("Enter the monthly rent/mortgage payment: ");
        int monthlyRentPayment = reader.nextInt();

        int totalEligibilityScore = BASE_ELIGIBILITY_SCORE;

        // The age of applicant is used to calculate eligibility score here
        if(age > 18 || age < 25){
            totalEligibilityScore += 10;
        }
        else if(age > 26 || age < 35){
            totalEligibilityScore += 20;
        }
        else if(age > 36 || age < 50){
            totalEligibilityScore += 25;
        }
        else if(age > 51 || age < 65){
            totalEligibilityScore += 15;
        }

         // The annual income of applicant is used to calculate eligibility score here
        totalEligibilityScore += (annualIncome / 10000) * 5;


         // The credit score of applicant is used to calculate eligibility score here
        if(creditScore > 300 || creditScore < 579){
            totalEligibilityScore += 0;
        }
        else if(creditScore > 580 || creditScore < 669){
            totalEligibilityScore += 50;
        }
        else if(creditScore > 670 || creditScore < 739){
            totalEligibilityScore += 100;
        }
        else if(creditScore > 740 || creditScore < 799){
            totalEligibilityScore += 150;
        }
        else if(creditScore > 800 || creditScore < 850){
            totalEligibilityScore += 200;
        }

        // The number of existing cards of applicant is used to calculate eligibility score here
        totalEligibilityScore -= 10 * noOfExistingCards;

        // The monthly rent payment of applicant is used to calculate eligibility score here
        totalEligibilityScore -= (monthlyRentPayment / 500) * 5; 

        // Reason for not approving is determined here based on several factors
        String reason = "";

        if(age < 18){
            reason += "\nAge is below 18";
        }
        if(annualIncome < 15000){
            reason += "\nAnnual income is below $15,000";
        }
        if(creditScore < 580){
            reason += "\nCredit is below 580";
        }
        if(noOfExistingCards > 5){
            reason += "\nNumber of existing credit cards exceeds 5.";
        }
        if(totalEligibilityScore < 250){
            reason += "\nTotal eligibility score is below 250.";
        }

        if(!reason.equals("")){
            System.out.println("The applicant is not approved for the credit card. Reason: ");
            System.err.println(reason);
        }
        else{
            System.out.println("The applicant is approved for the credit card.");
        }
       
        // Close the Scanner to prevent memory leak
        reader.close();


    }
}
