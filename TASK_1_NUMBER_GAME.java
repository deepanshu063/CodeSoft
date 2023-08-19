import java.util.Scanner;
import java.util.Random;

public class TASK_1_NUMBER_GAME {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxTries = 5;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int secretNumber = random.nextInt(100) + 1;
            int tries = 0;
            boolean correctGuess = false;

            System.out.println("You have to guess number between 1 and 100. Can you guess it");

            while (tries < maxTries && !correctGuess) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                tries++;

                if (guess == secretNumber) {
                    System.out.println("Super You guessed the number in " + tries + " tries.");
                    correctGuess = true;
                    score++;
                } else if (guess < secretNumber) {
                    System.out.println("Your guess is too low,Please think grater value.");
                } else {
                    System.out.println("Your guess is too high,Please think smaller value");
                }
            }

            if (!correctGuess) {
                System.out.println("Ohh, you ran out of tries. The number was " + secretNumber + "Better luck next time.");
            }

            System.out.print("Hii,Do you want to play again? (y/n): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("y");
        }

        System.out.println("Well done, Your final score is " + score + ".");
    }
}
