import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DiceGame {
    private static final int NUM_DICE = 5;
    private static final int MAX_ROLLS = 3;
    private static final Random random = new Random();

    public static void main(String[] args) {
        int[] player1Dice = new int[NUM_DICE];
        int[] player2Dice = new int[NUM_DICE];

        System.out.println("Player 1's turn:");
        int player1Score = playTurn(player1Dice);
        System.out.println("Player 1's final dice: " + Arrays.toString(player1Dice));
        System.out.println("Player 1's score: " + player1Score);

        System.out.println("\nPlayer 2's turn:");
        int player2Score = playTurn(player2Dice);
        System.out.println("Player 2's final dice: " + Arrays.toString(player2Dice));
        System.out.println("Player 2's score: " + player2Score);

        if (player1Score > player2Score) {
            System.out.println("\nPlayer 1 wins!");
        } else if (player2Score > player1Score) {
            System.out.println("\nPlayer 2 wins!");
        } else {
            System.out.println("\nIt's a tie!");
        }
    }

    private static int playTurn(int[] dice) {
        Scanner scanner = new Scanner(System.in);
        for (int roll = 1; roll <= MAX_ROLLS; roll++) {
            rollDice(dice);
            Arrays.sort(dice);
            System.out.println("Roll " + roll + ": " + Arrays.toString(dice));
            if (roll < MAX_ROLLS) {
                System.out.print("Enter the indices of dice to re-roll (comma-separated, or 'none'): ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("none")) {
                    break;
                }
                reRollDice(dice, input);
            }
        }
        return calculateScore(dice);
    }

    private static void rollDice(int[] dice) {
        for (int i = 0; i < dice.length; i++) {
            dice[i] = random.nextInt(6) + 1;
        }
    }

    private static void reRollDice(int[] dice, String input) {
        String[] indices = input.split(",");
        for (String index : indices) {
            int i = Integer.parseInt(index.trim());
            if (i >= 0 && i < dice.length) {
                dice[i] = random.nextInt(6) + 1;
            }
        }
    }

    private static int calculateScore(int[] dice) {
        int score = 0;
        for (int die : dice) {
            score += die;
        }
        return score;
    }
}
