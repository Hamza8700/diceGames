package dicegames;

import java.util.Scanner;

public class Pig {
    private Scanner scan;
    private Die die;

    private boolean finished;
    private int PlyOnePoints;
    private int PlyTwoPoints;
    private int winCondition = 100;

    public Pig() {
        die = new Die();
        scan = new Scanner(System.in);
    }

    private void welcomeToGame() {
        System.out.println("Welcome to PIG/100 Dice Game");
    }

    private void gameOver() {
        System.out.println("PIG/100 Game Over");
        scan.close();
    }

    public void takeTurn(int plyNumber) {
        int currentPoints = 0;
        while (!finished) {
            int dieFaceValue = 0;
            if (plyNumber == 1) {
                System.out.println("Player One's Turn");
            } else if (plyNumber == 2) {
                System.out.println("Player Two's Turn");
            }
            System.out.println("Roll: 'r' or Stop: 's'");
            String input = scan.nextLine();
            while (input.equalsIgnoreCase("r") || dieFaceValue != 1) {
                die.roll();
                dieFaceValue = die.getFaceValue();
                System.out.println("You rolled: " + dieFaceValue);
                if (dieFaceValue == 1) {
                    if (plyNumber == 1) {
                        System.out.println("You lose your turn, your current score is: " + PlyOnePoints);
                        plyNumber = 2;
                    } else if (plyNumber == 2) {
                        System.out.println("You lose your turn, your current score is: " + PlyTwoPoints);
                        plyNumber = 1;
                    }
                    currentPoints = 0;
                    break;
                } else {
                    currentPoints += dieFaceValue;
                    System.out.println("Turn score: "+currentPoints);
                    System.out.println("Roll: 'r' or Stop: 's'");
                    input = scan.nextLine();
                    if (input.equalsIgnoreCase("s")) {
                        if (plyNumber == 1) {
                            plyNumber = 2;
                        } else if (plyNumber == 2) {
                            plyNumber = 1;
                        }
                        break;
                    }
                }
            }

            // Calculate Points:
            if (plyNumber == 1) {
                PlyOnePoints += currentPoints;
                System.out.println("Player 1 Score: " + PlyOnePoints);
            } else if (plyNumber == 2) {
                PlyTwoPoints += currentPoints;
                System.out.println("Player 2 Score: " + PlyTwoPoints);
            }
            currentPoints = 0;

            // Check Win Conditions:
            if (PlyOnePoints >= winCondition) {
                System.out.println("Player 1 Won the Game!");
                finished = true;
                gameOver();
            } else if (PlyTwoPoints >= winCondition) {
                System.out.println("Player 2 Won the Game!");
                finished = true;
                gameOver();
            }
        }
    }

    public void startGame() {
        welcomeToGame();
        System.out.println("Enter amount of points to win the game");
        String points = scan.nextLine();
        winCondition = Integer.parseInt(points);
        System.out.println("First player to reach "+winCondition+ " points, wins the game! Good luck!");
        takeTurn(1);
    }
}
