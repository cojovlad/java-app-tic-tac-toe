import java.util.Scanner;

public class TicTacToeCli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        boolean gameEnded = false;

        System.out.println("Welcome to Tic-Tac-Toe!");

        while (!gameEnded) {
            game.printBoard();
            System.out.println("Player " + game.getCurrentPlayer() + ", enter your move (row and column): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (game.placeMark(row, col)) {
                if (game.checkWinner()) {
                    System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                    gameEnded = true;
                } else if (game.isBoardFull()) {
                    System.out.println("The game is a tie!");
                    gameEnded = true;
                } else {
                    game.changePlayer();
                }
            } else {
                System.out.println("This move is not valid. Try again.");
            }
        }

        game.printBoard();
        scanner.close();
    }
}
