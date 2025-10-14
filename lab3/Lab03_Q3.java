/*
 * This is a simple library management system.
 * You log in as a librarian and then you can manage members and books
 * @author Elvin Ismayil (22501036)
 * @version 15.10.2025 00:19
 */

import java.util.Random;
import java.util.Scanner;


public class Lab03_Q3 {

    public static void main(String[] args) {
        // User credentials are stored here
        String username = "librarian";
        String password = "books2024";

        // list of members and books are store here
        String memberList = "JohnSmith, EmilyDavis, ZeynepDemir";
        String bookList = "ISBN9781:JavaProgramming ISBN9782:DataStructures";

        Scanner reader = new Scanner(System.in);

        // User is asked to login here
        System.out.print("Enter your username: ");
        String userUsername = reader.nextLine();

        System.out.print("Enter your password: ");
        String userPassword = reader.nextLine();

        // We check user credentials to validate here
        if (!username.equals(userUsername)) {
            System.out.println("Username not found! Goodbye!");
        } else if (!password.equals(userPassword)) { 
            System.out.println("Incorrect password! Goodbye!");
        }
        else{

        int choice;

        do {
            System.out.println("1- Add member");
            System.out.println("2- Delete member");
            System.out.println("3- Add book");
            System.out.println("4- Delete book");
            System.out.println("5- Logout");
            System.out.print("Select an operation: ");

            choice = reader.nextInt();
            reader.nextLine();
            

            

            if (choice == 1) {
                System.out.println("-- Add Member --");
                System.out.print("Enter member name: ");
                String memberName = reader.nextLine();
                if (memberList.contains(memberName)) {
                    System.out.println("This member is already in your list!");
                    System.out.println("Your memberList: " + "(" + memberList + ")");   
                } else {
                    memberList += ", " + memberName;
                    System.out.println("New member " + memberName + " is added");
                    System.out.println("Your memberList: " + "(" + memberList + ")");   

                }

            } else if (choice == 2) {

                System.out.println("-- Delete Member --");
                System.out.print("Enter member name which you want to delete: ");
                String memberName = reader.nextLine();
                if (memberList.contains(memberName)) {
                    // We first get the first and last index of member name before subtring 
                    int startIndex = memberName.indexOf(memberName);
                    int endIndex = startIndex + memberName.length();

                                                   
                    // Here we substring from beginning of the list to the first letter of the member name
                    // then we combine it with substring from the last letter to the end of the list
                    memberList = memberList.substring(0, startIndex) + memberList.substring(endIndex);
                    
                    System.out.println(memberName + " is deleted successfully from memberList!");
                    System.out.println("Your memberList: " + "(" + memberList + ")");   

                    
                } else {
                    System.out.println("You don't have any member whose name is " + memberName + "!");
                    System.out.println("Your memberList: " + "(" + memberList + ")");   
                }

            } else if (choice == 3) {

                System.out.println("-- Add Book --");
                System.out.print("Enter book name: ");
                String bookName = reader.nextLine(); 
                Random random = new Random();
                String isbn = String.format("%04d", random.nextInt(10000));
                if (bookList.contains(isbn)) {
                    System.out.println("There is a book with the ISBN " + isbn + ", you cannot add a " +
                    "new book with the same ISBN");
                    System.out.println("Your books: " + bookList);   
                }
                else{
                    bookList += isbn + ":" + bookName;
                    System.out.println("New book with ISBN " + isbn + " is added!");
                    System.out.println("Your books: " + bookList);
                }


            } else if (choice == 4) {
                System.out.println("-- Delete Book --");
                System.out.print("Enter ISBN which you want to delete: ");
                int isbn = reader.nextInt();
                String isbnText = "ISBN" + isbn;
                
                if (bookList.contains(isbnText)) {
                    int startIndex = bookList.indexOf(isbnText);
                    int endIndex = bookList.indexOf(" ");
                                                   
                    bookList = bookList.substring(0, startIndex) + bookList.substring(endIndex);

                    System.out.println("The book with the " + isbnText + "deleted successfully!");
                    System.out.println("Your books: " + bookList);
                }
                else{
                    System.out.println("You don't have any book with the ISBN " + isbn);
                    System.out.println("Your books: " + bookList);
                }
                
            }
            else if(choice == 5){
                    System.out.println("Logged out successfully!");
            }


        } while (choice != 5);

        reader.close();
    }
        }

}