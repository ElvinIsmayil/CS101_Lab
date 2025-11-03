package lab5;

import java.util.Scanner;

public class Lab05_Q1 {
    // Helper methods
    public static char toLower(char ch) {
        int asciiCode = ch;
        if (!(asciiCode > 64 && asciiCode < 91)) {
            return ch;
        }
        int lowerChAsciiCode = asciiCode + 32;
        char lowerCharacter = (char) lowerChAsciiCode;
        return lowerCharacter;
    }

    public static boolean isLetter(char ch) {
        int asciiCode = ch;
        return ((asciiCode > 96 && asciiCode < 122) || asciiCode > 64 && asciiCode < 91);
       
    }

    public static boolean isDigit(char ch) {
        int asciiCode = ch;
        return(asciiCode > 47 && asciiCode < 58);
    }

    public static boolean isWhiteSpace(char ch) {
        int asciiCode = ch;
        return (asciiCode == 32 || asciiCode == 9 || asciiCode == 10);
          
    }

    public static String wordToLowerCaseWithoutWhiteSpace(String str) {
        String word = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isWhiteSpace(ch)) {
                continue;
            }
            char lowerCh = toLower(ch);
            word += lowerCh;
        }
        return word;
    }

    public static String wordToLowerCase(String str) {
        String word = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            char lowerCh = toLower(ch);
            word += lowerCh;
        }
        return word;
    }

    // String analysis
    public static boolean isPalindrome(String str) {

        String word = wordToLowerCaseWithoutWhiteSpace(str);
        boolean isPalindrome = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }

    public static boolean areAnagrams(String str1, String str2) {
        String word1 = wordToLowerCaseWithoutWhiteSpace(str1);
        String word2 = wordToLowerCaseWithoutWhiteSpace(str2);

        // If words have different lengths then they are not anagrams
        if (word1.length() != word2.length()) {
            return false;
        }

        for (int i = 0; i < word1.length(); i++) {
            // If the second word does not have the specified character
            // then they are not anagrams
            if (word2.indexOf(word1.charAt(i)) == -1) {
                return false;
            }
        }
        return true;

    }

    public static int wordCount(String str) {
        // Word count is initialized as 1 for single word inputs
        int wordCount = 1;
        for (int i = 0; i < str.length(); i++) {
            if (isWhiteSpace(str.charAt(i))) {
                wordCount++;
            }

        }
        return wordCount;
    }

    //String manipulation
    public static String slugify(String str) {
        // First we make the string all lowercase letters
        String str1 = wordToLowerCase(str);
        StringBuilder sb = new StringBuilder(str1);

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            // If the character is a special symbol then it should be deleted
            if (!(isLetter(ch) || isDigit(ch) || isWhiteSpace(ch))) {
                sb.deleteCharAt(i);
                i--;
                
            } else if(isWhiteSpace(ch)){
                sb.replace(i, i+1, "-");
            }
            
        }
        return sb.toString();
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int option;
        do {

            System.out.println("=== Text Toolkit ===");
            System.out.println("1) Check Palindrome");
            System.out.println("2) Check Anagrams");
            System.out.println("3) Word Count");
            System.out.println("4) Slugify");
            System.out.println("5) Exit");
            System.out.print("Select an option (1-5): ");

            option = input.nextInt();
            input.nextLine();

            if (option == 1) {

                System.out.print("Enter the text to check palindrome: ");
                String text = input.nextLine();
                boolean isPalindrome = isPalindrome(text);

                if (isPalindrome) {
                    System.out.println('"' + text + '"' + " is a palindrome.");
                } else {
                    System.out.println('"' + text + '"' + " is not a palindrome.");

                }
            }

            if (option == 2) {
                System.out.print("Enter first string: ");
                String string1 = input.nextLine();
                System.out.print("Enter second string: ");
                String string2 = input.nextLine();

                boolean areAnagrams = areAnagrams(string1, string2);

                if (areAnagrams) {
                    System.out.println('"' + string1 + '"' + " and " + '"' + string2 + '"' + " are anagrams.");
                } else {
                    System.out.println('"' + string1 + '"' + " and " + '"' + string2 + '"' + " are not anagrams.");
                }
            }

            if (option == 3) {
                System.out.print("Enter text to count words: ");
                String text = input.nextLine();

                int wordCount = wordCount(text);
                System.out.println("Word count: " + wordCount);

            }

            if (option == 4) {
                System.out.print("Enter text to slugify: ");
                String text = input.nextLine();
                String sluggedText = slugify(text);

                System.out.println("Slug: " + sluggedText);

            }

            if (option == 5) {
                System.out.println("Goodbye!");
            }

        } while (option != 5);

        input.close();
    }
}
