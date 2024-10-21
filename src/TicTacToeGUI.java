import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame implements ActionListener {
    private TicTacToe game;
    private JButton[][] buttons;

    public TicTacToeGUI() {
        game = new TicTacToe();
        buttons = new JButton[3][3];

        setTitle("Tic Tac Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("-");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j] == buttonClicked && buttons[i][j].getText().equals("-")) {
                    buttons[i][j].setText(String.valueOf(game.getCurrentPlayer()));
                    game.placeMark(i, j);

                    if (game.checkWinner()) {
                        JOptionPane.showMessageDialog(this, "Player " + game.getCurrentPlayer() + " wins!");
                        resetBoard();
                    } else if (game.isBoardFull()) {
                        JOptionPane.showMessageDialog(this, "The game is a tie!");
                        resetBoard();
                    } else {
                        game.changePlayer();
                    }
                }
            }
        }
    }

    private void resetBoard() {
        game = new TicTacToe();  // Resets the game logic
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("-");  // Resets all buttons to display "-"
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToeGUI();
    }
}