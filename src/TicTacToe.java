public class TicTacToe {
    public char[][] board;
    public char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initilizeBoard();
    }

    private void initilizeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println('\n');
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean placeMark(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (board[row][col] == '-') {
                board[row][col] = currentPlayer;
                return true;
            }
        }
        return false;
    }

    public boolean checkWinner() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-' && board[i][1] != '-' && board[i][2] != '-') {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-' && board[1][j] != '-' && board[2][j] != '-') {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return true;
        }
        return false;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }
}
