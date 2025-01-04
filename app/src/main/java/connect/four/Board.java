package connect.four;

public class Board {
    private byte [][] board;

    public Board() {
        this.board = new byte[6][7];
    }

    public void printBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public byte addPiece(int column, byte player) {
        for (int i = 5; i >= 0; i--) {
            if (board[i][column] == 0) {
                board[i][column] = player;
                return checkWin(player);
            }
        }
        return -1;
    }

    public byte checkWin(byte player) {
        // Check horizontal
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col] == player && 
                    board[row][col+1] == player &&
                    board[row][col+2] == player &&
                    board[row][col+3] == player) {
                    return player;
                }
            }
        }
        // Check vertical
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 7; col++) {
                if (board[row][col] == player &&
                    board[row+1][col] == player &&
                    board[row+2][col] == player &&
                    board[row+3][col] == player) {
                    return player;
                }
            }
        }

        // Check diagonal (positive slope)
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col] == player &&
                    board[row-1][col+1] == player &&
                    board[row-2][col+2] == player &&
                    board[row-3][col+3] == player) {
                    return player;
                }
            }
        }

        // Check diagonal (negative slope)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col] == player &&
                    board[row+1][col+1] == player &&
                    board[row+2][col+2] == player &&
                    board[row+3][col+3] == player) {
                    return player;
                }
            }
        }

        //check for draw
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j] == 0) {
                    return 0;
                }
            }
        }
        return 3;
    }
}