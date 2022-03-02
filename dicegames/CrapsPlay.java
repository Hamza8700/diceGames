package dicegames;

import java.util.Scanner;

public class CrapsPlay {
    private Scanner scan;
    private Die die1;
    private Die die2;

    private int comeOutRoll;
    private boolean finished;

    public CrapsPlay() {
        die1 = new Die();
        die2 = new Die();
        scan = new Scanner(System.in);
    }

    private void welcomeToGame() {
        System.out.println("Welcome to Craps Play");
    }

    private void gameOver(boolean playerWon) {
       if (playerWon == true) {
           System.out.println("You have won");
       } else {
           System.out.println("You have lost");
       }
        finished = true;
    }

    public void takeTurn() {
        die1.roll();
        die2.roll();

        int sum = die1.getFaceValue() + die2.getFaceValue();

        if (comeOutRoll == 0) { // first roll
            if (sum == 7 || sum == 11) {
                gameOver(true);
            } else if (sum == 2 || sum == 3 || sum == 12) {
                gameOver(false);
            } else {
                comeOutRoll = sum;
            }
        } else {
            if (sum == 7) {
                gameOver(false);
            } else if (sum == comeOutRoll) {
                gameOver(true);
            }
        }

        System.out.println("You rolled: " + sum + " | Dice 1: " + die1.getFaceValue() + " | Dice 2: " + die2.getFaceValue());

    }

    public void startGame() {
        welcomeToGame();

        while (!finished) {
            System.out.println("Roll dices? Type 'Yes' or 'No': ");
            String goOn = scan.nextLine();
            if (goOn.equalsIgnoreCase("No")) {
                finished = true;
            } else {
                takeTurn();
            }
        }

    }


}
