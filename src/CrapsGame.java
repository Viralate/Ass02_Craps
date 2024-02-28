import java.util.Random;
import java.util.Scanner;

public class CrapsGame {

    //declare random 
    private static final Random randomNumbers = new Random();

    public static void main(String[] args) {
        //initiate scanner and declare play again string
        Scanner input = new Scanner(System.in);
        String playAgain = "yes";

        // logic for play again loop
        while (playAgain.equalsIgnoreCase("yes")) {
            int sumOfDice = rollDice();
            //logic for game
            switch (sumOfDice) {
                case 7:
                case 11:
                    System.out.println("You won with a natural!");
                    break;
                case 2:
                case 3:
                case 12:
                    System.out.println("Craps! You lose.");
                    break;
                default:
                //set points
                    int point = sumOfDice;
                    System.out.println("Point is (set to) " + point);
                    sumOfDice = 0;
                    while (sumOfDice != 7 && sumOfDice != point) {
                        sumOfDice = rollDice();
                        if (sumOfDice == point) {
                            System.out.println("Made point and won!");
                        } else if (sumOfDice == 7) {
                            System.out.println("Got a seven and lost.");
                        } else {
                            System.out.println("Trying for point");
                        }
                    }
                    break;
                }
                //prompt user to play again
                System.out.print("Play again? (yes/no): ");
                playAgain = input.nextLine();
            }
        }
        // logic for results and displaying rolls
        private static int rollDice() {
            int die1 = 1 + randomNumbers.nextInt(6);
            int die2 = 1 + randomNumbers.nextInt(6);
            int sum = die1 + die2;
            System.out.printf("Player Rolled %d + %d = %d%n", die1,die2,sum);
            return sum;
        }
}
    



