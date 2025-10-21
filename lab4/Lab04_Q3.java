package lab4;

/**
 * This is a 3 player battleship guessing game
 * Players guess row and number in their turn and 
 * the player that earns most score wins the game
 * 
 * @author Elvin Ismayil (22501036)
 * @version 22.10.2025 00:35
 */
import java.util.Scanner;

public class Lab04_Q3 {

    public static void printFormattedGameGrid(String gameGrid) {
        String gameGridFormatted = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                char cell = gameGrid.charAt(5 * i + j);
                gameGridFormatted += cell + " ";
            }
            gameGridFormatted += "\n";
        }
        System.out.println(gameGridFormatted);
    }

    public static void printFinalStatistics(int round, int guess, int player1Point,int player2Point,int player3Point) {
        System.out.println("*********************");
        System.out.println("Game finished");
        System.out.println("Total rounds played: " + round);
        System.out.println("Total guesses: " + guess);
        System.out.println("Player1 score: " + player1Point + "ships found");
        System.out.println("Player2 score: " + player2Point + "ships found");
        System.out.println("Player3 score: " + player3Point + "ships found");

        if(player1Point > player2Point && player1Point > player3Point){
            System.out.println("Winner: Player1");
        }
        else if(player2Point > player1Point && player2Point > player3Point){
            System.out.println("Winner: Player2");
        }
         else if(player3Point > player1Point && player3Point > player2Point){
            System.out.println("Winner: Player3");

         }
        if (player1Point == player2Point || player2Point == player3Point || player3Point == player1Point) {
            System.out.println("It's a tie!");
        }
    }

    public static void main(String[] args) {

        // Variables are initialized here
        String gameGrid = "~~~~~~~~~~~~~~~~~~~~~~~~~";
        String shipGrid = "0000000000000000000000000";
        int shipCount = 5;
        int round = 1;
        int guess = 0;
        int player1Point = 0;
        int player2Point = 0;
        int player3Point = 0;
        int row = 0;
        int column = 0;

        Scanner input = new Scanner(System.in);


        // Ships are assigned to random positions here
        for (int i = 0; i < 5; i++) {
            int shipNum = (int) (Math.random() * 25);
            while (shipGrid.charAt(shipNum) == '1') {
                shipNum = (int) (Math.random() * 25);
            }

            shipGrid = shipGrid.substring(0, shipNum) + "1" + shipGrid.substring(shipNum + 1);

        }

        System.out.println(shipGrid);

        
        System.out.println("Welcome to Battleship!");
        System.out.println("The grid is 5x5. There are 5 hidden ships.\n");
        System.out.println("Initial Grid:");
        printFormattedGameGrid(gameGrid);

        while (shipCount != 0){
            System.out.println("######  Round  #" + round);

            // We cycle players here
            for (int player = 1; player <= 3; player++) {
                System.out.println("##  Player" + player + "  ##");
                System.out.println("Previous grid");
                printFormattedGameGrid(gameGrid);


                // Row input is asked here and validated 
                System.out.print("Guess row: ");
                while(!input.hasNextInt()){
                    System.out.println("Invalid guess. Try again.");
                    input.nextLine();
                    System.out.print("Guess row: ");

                }
                row = input.nextInt();
                 if(row < 0 || row > 4){
                    System.out.println("Invalid guess. Try again.");
                    player--;
                    guess++;
                    break;
                }

                // Column input is asked here and validated 
                System.out.print("Guess column: ");
                while(!input.hasNextInt()){
                    System.out.println("Invalid guess. Try again.");
                    input.nextLine();
                    System.out.print("Guess column: ");
                }
                column = input.nextInt();
                if(column < 0 || column > 4){
                    System.out.println("Invalid guess. Try again.");
                    player--;
                    guess++;
                    break;
                }

               

                    int shipPosition = 5 * row + column;
                    int guessChar = shipGrid.charAt(shipPosition);
    
    
                    // Hit
                    if (guessChar == '1') {
                        System.out.println("Hit!");
                        gameGrid = gameGrid.substring(0, shipPosition) + 'X' + gameGrid.substring(shipPosition + 1);
                        shipGrid = shipGrid.substring(0, shipPosition) + '0' + shipGrid.substring(shipPosition + 1);
                        guess++;
                        shipCount--;
                        if (player == 1) {
                            player1Point++;
                        }
                        if (player == 2) {
                            player2Point++;
                        }
                        if (player == 3) {
                            player3Point++;
                        }
                   
                    // Already guess 
                    } else if (gameGrid.charAt(shipPosition) == 'O' || gameGrid.charAt(shipPosition) == 'X') {
                        System.out.println("Already guess here!");
                        guess++;
                        player--;
    
                    }
                    // Miss 
                    else if (guessChar == '0') {
                        System.out.println("Miss!");
                        gameGrid = gameGrid.substring(0, shipPosition) + 'O' + gameGrid.substring(shipPosition + 1);
                        guess++;
                    }
                    // Invalid guess
                     else {
                        System.out.println("Invalid guess. Try again.");
                        guess++;
                        player--;
                        break;
                    }
    
                    // Print the current grid here
                    System.out.println("Current grid: ");
                    printFormattedGameGrid(gameGrid);
    
                }
                }

            // Increment the number of rounds here
            round++;

        

        // End game statistics are printed out here
        printFinalStatistics(round, guess, player1Point, player2Point, player3Point);
    }
}
