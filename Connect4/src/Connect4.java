class Connect4 {

    public char player='R';


    public Boolean isColumnFilled(char[][] board, int col) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][col] == ' ')
                return false;
        }
        return true;
    }

    public int findLastFilledPosition(char[][] board, int col) {
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][col] == ' ')
                return row;
        }
        return -1; //completely filled column
    }

    public int insertPiece(char[][] board, int col, char player) {
        if (isColumnFilled(board, col))
            return -1;
        int row = findLastFilledPosition(board, col);
        board[row][col] = player;
        return row;
    }

    public boolean checkWin(char[][] board, int row, int col, char player) {
        int count = 0;
        //check row
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == player)
                count++;
            else
                count = 0;
            if (count == 4)
                return true;
        }
        //check column
        count = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == player) {
                count++;
            } else {
                count = 0;
            }
            if (count == 4)
                return true;
        }
        //check diagonal
        count = 0;
        int i = row, j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == player)
                count++;
            else
                count = 0;
            if (count == 4)
                return true;
            i--;
            j--;
        }
        i = row;
        j = col;
        while (i < board.length && j < board[0].length) {
            if (board[i][j] == player)
                count++;
            else
                count = 0;
            if (count == 4)
                return true;
            i++;
            j++;
        }
        //check anti-diagonal
        count = 0;
        i = row;
        j = col;
        while (i >= 0 && j < board[0].length) {
            if (board[i][j] == player)
                count++;
            else
                count = 0;
            if (count == 4)
                return true;
            i--;
            j++;
        }
        i = row;
        j = col;
        while (i < board.length && j >= 0) {
            if (board[i][j] == player)
                count++;
            else
                count = 0;
            if (count == 4)
                return true;
            i++;
            j--;
        }
        return false;
    }

    public boolean isDraw(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            if (!isColumnFilled(board, i))
                return false;
        }
        return true;
    }

    private void switchPlayers() {
        if (player == 'R')
            player = 'B';
        else
            player = 'R';
    }

    public boolean playTurn(char[][] board, int col, char player) {
        if (isColumnFilled(board, col)) {
            System.out.println("Column is filled");
            return false;
        }
        int row = insertPiece(board, col, player);

        if (row != -1) {
            if (checkWin(board, row, col, player)) {
                System.out.println("Player " + player + " Wins!");
                return true;
            } else if (isDraw(board)) {
                System.out.println("Draw!");
                return true;
            } else {
                switchPlayers();
            }
        }
        return false;
    }

    public void printBoard(char[][] board) {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    System.out.print("| " + board[row][col] + " ");
                }
                System.out.println("|");
                for (int col = 0; col < board[row].length; col++) {
                    System.out.print("----");
                }
                System.out.println();
            }
            for (int col = 0; col < board[0].length; col++) {
                System.out.print("  " + col + " ");
            }
            System.out.println();
    }

}
