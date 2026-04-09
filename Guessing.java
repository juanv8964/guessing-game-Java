import java.util.Scanner;
public class Guessing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maxAttempts = 0;
        boolean playAgain = true;
        int attempts = 0;
        boolean guessedCorrectly = false;
        int randomNumber = 0;
        int userDifficulty = 0;
        int maxNumber = 0;
        GameStats gameStats = new GameStats();
        displayInfo();
        userDifficulty = getDifficultyLevel(input);
        switch(userDifficulty){
            case 1:
                maxNumber = 20;
                maxAttempts = 5;
                break;
            case 2:
                maxNumber = 45;
                maxAttempts = 7;
                break;
            case 3:
                maxNumber = 70;
                maxAttempts = 10;
                break;
            default:
                System.out.println("Invalid difficulty level. Pick a number between 1 and 3.");
                return;
        }
        while (playAgain) {
            attempts = 0;
            guessedCorrectly = false;
            randomNumber = (int) (Math.random() * maxNumber) + 1;
        while (attempts < maxAttempts) {

            System.out.print("Enter your guess (between 1 and " + maxNumber + "): ");

            int userGuess = getValidInput(input, maxNumber);
            
            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number!");
                guessedCorrectly = true;
                break;
            }
            else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > randomNumber) {
                System.out.println("Too high! Try again."); 
            }
            attempts++;
            int difference = Math.abs(userGuess - randomNumber);
                if (difference <= 3 && difference > 0) {
                    System.out.println("very warm...");
                }
                else if (difference <= 6 && difference > 3) {
                    System.out.println("warm...");
                }
                else if (difference <= 9 && difference > 6) {
                    System.out.println("cold...");
                }
                else if (difference <= 12 && difference > 9) {
                     System.out.println("very cold...");
                }
                else if(difference <= 15 && difference > 12){ 
                    System.out.println("very very cold...");
                }
        }
        
        if (guessedCorrectly) {
            gameStats.recordWin();
        } 
        else {
            gameStats.recordLoss();
            System.out.println("Sorry, you've used all your attempts. The number was: " + randomNumber);
            }
            gameStats.printStats();
            boolean playAgainResponse = playAgain(input);
            if (!playAgainResponse) {
                playAgain = false;
            }
    }
}
public static int getDifficultyLevel(Scanner input) {
    int userdifficulty = 0;
    while(true){
        try {
            userdifficulty = input.nextInt();
            if (userdifficulty >= 1 && userdifficulty <= 3) {
                System.out.println("You selected difficulty level " + userdifficulty);
               break;
            }
            else{
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number between 1 and 3.");
            input.next();
            }
        }
    return userdifficulty;
}
public static void displayInfo(){
    System.out.println("Welcome to the Number Guessing Game!");
    System.out.println("Select difficulty level:");
    System.out.println("1. Easy (1-20)");
    System.out.println("2. Medium (1-45)");
    System.out.println("3. Hard (1-70)");
}
public static int getValidInput(Scanner input, int maxNumber) {
    int userGuess = 0;
    while (true) {
        try {
            userGuess = input.nextInt();
            if (userGuess >= 1 && userGuess <= maxNumber) {
                break;
            } else {
                System.out.println("Please enter a number between 1 and " + maxNumber + ".");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            input.next();
        }
    }
    return userGuess;
}
public static boolean playAgain(Scanner input) {
    String playAgainResponse;
    while(true) {
        System.out.print("Play again? Enter 'yes' or 'no': ");
        playAgainResponse = input.next();
        if(playAgainResponse.equalsIgnoreCase("yes")) {
            return true;
        } else if(playAgainResponse.equalsIgnoreCase("no")) {
            return false;
        } else {
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }
    }
}
}
