package dicegames;

import java.util.Scanner;

// Opgave 1.11)

public class PlayPairOfDice {

    private Scanner scan = new Scanner(System.in);

    private PairOfDices dices = new PairOfDices();

    private void welcomeToGame() {
        System.out.println("Velkommen til spillet dicegames.PairOfDices");
    }

    private void gameOver() {
        int sameFaceRolls = dices.getSameFaceCount();
        int highestFaceRolls = dices.getHighestFaceSum();
        int oneRolls = dices.getNumberOfOneRolls();
        int twoRolls = dices.getNumberOfTwoRolls();
        int threeRolls = dices.getNumberOfThreeRolls();
        int fourRolls = dices.getNumberOfFourRolls();
        int fiveRolls = dices.getNumberOfFiveRolls();
        int sixRolls = dices.getNumberOfSixRolls();

        System.out.println("Same Face Rolls: " + sameFaceRolls);
        System.out.println("Highest Face Rolls: " + highestFaceRolls);
        System.out.println("Total One Rolls: " + oneRolls);
        System.out.println("Total Two Rolls: " + twoRolls);
        System.out.println("Total Three Rolls: " + threeRolls);
        System.out.println("Total Four Rolls: " + fourRolls);
        System.out.println("Total Five Rolls: " + fiveRolls);
        System.out.println("Total Six Rolls: " + sixRolls);

        dices.resetPairOfDices();
        scan.close();
    }

    private void takeTurn() {
        dices.rollBothDices();
        int roll = dices.sumOfDices();
        System.out.println("Du har kastet: " + roll);
    }

    public void startGame() {
        welcomeToGame();

        boolean finished = false;

        while (!finished) {
            System.out.println("Vil du kaste en terning? Angiv Ja eller Nej: ");
            String goOn = scan.nextLine();
            if (goOn.equalsIgnoreCase("Nej")) {
                finished = true;
            } else {
                takeTurn();
            }
        }
        gameOver();
    }
}
