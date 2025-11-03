package lab5;
import java.util.Scanner;

public class Lab05_Q2 {

    // Helper methods
     public static boolean isLowerCase(char ch) {
        int asciiCode = ch;
        // We check if the 
        return (asciiCode > 96 && asciiCode < 123);
    }

    public static boolean isLetter(char ch) {
        int asciiCode = ch;
        // We check whether the character's ascii code is between the
        // upper and lowercase letter codes
        return (asciiCode > 96 && asciiCode < 122) || asciiCode > 64 && asciiCode < 91;
    }

    public static String ceaserCipher(String text, int shift, boolean encode){
        StringBuilder sb = new StringBuilder(text);
        if(encode){
            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                
                 if(isLetter(ch)){
                    
                    int asciiCode = ch+shift;
                    char chReplace = (char)asciiCode;
                    if(!isLetter(chReplace)){
                        asciiCode-=26;
                        chReplace = (char)asciiCode;

                    }
                    String replace = "";
                    replace+= chReplace;
                    sb.replace(i, i+1, replace);

                }
            }
            return sb.toString();
        }
        else{
            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                
                 if(isLetter(ch)){
                    
                    int asciiCode = ch-shift;
                    char chReplace = (char)asciiCode;
                    if(!isLetter(chReplace)){
                        asciiCode-=26;
                        chReplace = (char)asciiCode;

                    }
                    String replace = "";
                    replace+= chReplace;
                    sb.replace(i, i+1, replace);

                }
            }
            return sb.toString();
        }
    }

    public static String atbashCipher(String text){
        StringBuilder sb = new StringBuilder(text);

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if(isLetter(ch)){
                String replace = "";
                char atbash = ' ';
                if(isLowerCase(ch)){
                    atbash = (char)('a' + ('z'-ch));
                }
                else{
                    atbash = (char)('A' + ('Z'-ch));
                }
                replace += atbash;
                sb.replace(i, i+1, replace);
            }

        }
        return sb.toString();


    }

    public static String reverseText(String text){
        StringBuilder sb = new StringBuilder(text);
        for (int i = 0; i < sb.length(); i++) {
           char ch = text.charAt(sb.length()-i-1);
           String replace = "";
           replace += ch;
           
            sb.replace(i, i+1, replace);
        }
        return sb.toString();

    }

     @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int option;
        do {

            System.out.println("=== Cipher Toolkit ===");
            System.out.println("1) Caesar Cipher");
            System.out.println("2) Atbash Cipher");
            System.out.println("3) Reverse Text");
            System.out.println("4) Exit");
            System.out.print("Select an option (1-4): ");

            option = input.nextInt();
            input.nextLine();

            if (option == 1) {

                System.out.print("Enter text: ");
                String text = input.nextLine();
                System.out.print("Enter shift amount (1-25): ");
                int shift = input.nextInt();   
                System.out.print("Type 'e' to encode 'd' to decode: ");
                input.nextLine();
                char ch = input.findInLine(".").charAt(0);
                boolean encode = false;
                if(ch == 'e'){
                    encode = true;
                }        

                String cipherText = ceaserCipher(text, shift, encode);

               System.out.println("Result: " + cipherText);
            }
            if(option == 2){
                System.out.print("Enter text: ");
                String text = input.nextLine();

                String cipherText = atbashCipher(text);
                System.out.println("Result: " + cipherText);
            }
            if(option == 3){
                System.out.print("Enter text: ");
                String text = input.nextLine();

                String reversedText = reverseText(text);
                System.out.println("Reversed text: " + reversedText);
            }

            if(option == 4){
                System.out.println("Goodbye!");

            }

        }while(option != 4);

        input.close();



    }
}
