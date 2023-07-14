import java.util.Random;
import java.util.Scanner;

//Game class
class Game {
    int systemInput;
    int userInput;
    int noOfGuesses = 0;

    // generating random numbers in default constructor
    Game() {
        Random random = new Random();
        this.systemInput = random.nextInt(100) + 1;
    }

    // method to take user guesses
    public boolean takeUserInput() {
        if (noOfGuesses < 10) {
            System.out.println("Guess the number : ");
            this.userInput = Task1.takeIntegerInput(100);
            noOfGuesses++;
            return false;
        } else {
            System.out.println("Number of attempts finished...better luck next time");
            return true;
        }
    }

    // method to check user guess status
    public boolean isCorrectGuess() {
        if (systemInput == userInput) {
            System.out.println("Congratulations,you guess the number " + systemInput + " in " + noOfGuesses + " guesses");
            switch (noOfGuesses) {
                case 1:
                    System.out.println("your score is 100");
                    break;
                case 2:
                    System.out.println("your score is 90");
                    break;
                case 3:
                    System.out.println("your score is 80");
                    break;
                case 4:
                    System.out.println("your score is 70");
                    break;
                case 5:
                    System.out.println("your score is 60");
                    break;
                case 6:
                    System.out.println("your score is 50");
                    break;
                case 7:
                    System.out.println("your score is 40");
                    break;
                case 8:
                    System.out.println("your score is 30");
                    break;
                case 9:
                    System.out.println("your score is 20");
                    break;
                case 10:
                    System.out.println("your score is 10");
                    break;
            }
            System.out.println();
            return true;
        } else if (noOfGuesses < 10 && userInput > systemInput) {
            if (userInput - systemInput > 10) {
                System.out.println("Too High");
            } else {
                System.out.println("Little High");
            }
        } else if (noOfGuesses < 10 && systemInput > userInput) {
            if (userInput - systemInput > 10) {
                System.out.println("Too Low");
            } else {
                System.out.println("Little Low");
            }
        }
        return false;
    }
}

// Main class
public class Task1 {
    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try {
                Scanner a = new Scanner(System.in);
                input = a.nextInt();
                flag = true;
                if (flag && input > limit || input < 1) {
                    System.out.println("choose the number  between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("enter only integer value");
                flag = false;
            }
        }
        ;
        return input;
    }

    // main method
    public static void main(String args[]) {
        // input for start the game
        System.out.println("1.Start the game\n 2.Exit");
        System.out.print("Enter Your Choice : ");
        int Choice = takeIntegerInput(2);
        int nextRound = 1;
        int noOfRounds = 0;
        if (Choice == 1) {
            // to check next round is there or not
            while (nextRound == 1) {
                // creating object of the Game class
                Game game = new Game();
                boolean isMatched = false;
                boolean isLimitCross = false;
                System.out.println("\nRound " + ++noOfRounds + " starts....");
                // to check correct guess and limit cross
                while (!isMatched && !isLimitCross) {
                    isLimitCross = game.takeUserInput();
                    isMatched = game.isCorrectGuess();
                }
                // input for next round
                System.out.println("\n1.Next Round 2.Exit");
                System.out.println("Enter Your Choice : ");
                nextRound = takeIntegerInput(2);
                if (nextRound != 1) {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
