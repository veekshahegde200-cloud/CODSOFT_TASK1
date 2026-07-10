import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        char playAgain;

        System.out.println("==================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("==================================");

        do {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    System.out.println("Attempts used: " + attempts);

                    score += (maxAttempts - attempts + 1);
                    guessedCorrectly = true;
                    break;

                } else if (guess < randomNumber) {
                    System.out.println("Too Low!");

                } else {
                    System.out.println("Too High!");
                }

                System.out.println("Attempts Left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("\nYou have used all your attempts.");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.println("\nCurrent Score: " + score);

            System.out.print("\nDo you want to play another round? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n==================================");
        System.out.println("Game Over!");
        System.out.println("Final Score: " + score);
        System.out.println("Thank you for playing.");
        System.out.println("==================================");

        sc.close();
    }
}