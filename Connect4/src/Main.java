import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connect4 connect4 = new Connect4();
        System.out.println("Welcome to Connect 4\n");
        System.out.println("Enter the number of columns and rows\n");
        Scanner scan = new Scanner(System.in);
        int cols = scan.nextInt();
        int rows = scan.nextInt();
        char[][] board = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = ' ';
            }
        }

        boolean gameEnded = false;
        while (gameEnded!=true) {
            connect4.printBoard(board);
            System.out.println("\nChoose a column, Player"+connect4.player+"\n");
            int col = scan.nextInt();
            gameEnded = connect4.playTurn(board, col, connect4.player);

        }
        connect4.printBoard(board);
    }
}