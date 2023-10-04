import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int numberOfAttempts = 10;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            int score = 0;

            System.out.println("I've selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");

            while (attempts < numberOfAttempts) {
                System.out.print("Enter your guess: ");
                if (scanner.hasNextInt()) {
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess < minRange || userGuess > maxRange) {
                        System.out.println("Your guess is out of the valid range.");
                    } else if (userGuess < targetNumber) {
                        System.out.println("Your guess is too low. Try again.");
                    } else if (userGuess > targetNumber) {
                        System.out.println("Your guess is too high. Try again.");
                    } else {
                        System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts!");
                        score = (numberOfAttempts - attempts) * 10;
                        totalScore += score;
                        System.out.println("Your score for this round: " + score);
                        break;
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); 
                }

                if (attempts == numberOfAttempts) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();

            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game over. Your total score: " + totalScore);
    }
}
