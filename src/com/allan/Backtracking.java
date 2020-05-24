package com.allan;

// Java program to find minimum number of queens needed
// to cover a given chess board.

public class Backtracking {

    // The chessboard is represented by a 2D array.
    static boolean[][] board;

    // N x M is the dimension of the chess board.
    static int N, M;

    // The minimum number of queens required.
    // Initially, set to MAX_VAL.
    static int minCount = Integer.MAX_VALUE;

    static String layout; // Stores the best layout.

    // Driver code
    public static void main(String[] args)
    {
        N = 6;
        M = 6;
        board = new boolean[N][M];
        placeQueen(0);

        System.out.println(minCount);
        System.out.println("\nLayout: \n" + layout);
    }

    // Finds minimum count of queens needed and places them.
    static void placeQueen(int countSoFar)
    {
        int i, j;

        if (countSoFar >= minCount)

            // We've already obtained a solution with lesser or
            // same number of queens. Hence, no need to proceed.
            return;

        // Checks if there exists any unattacked cells.
        findUnattackedCell : {
            for (i = 0; i < N; ++i)
                for (j = 0; j < M; ++j)
                    if (!isAttacked(i, j))

                        // Square (i, j) is unattacked.
                        break findUnattackedCell;

            // All squares all covered. Hence, this
            // is the best solution till now.
            minCount = countSoFar;
            storeLayout();

            return;
        }

        for (i = 0; i < N; ++i)
            for (j = 0; j < M; ++j) {
                if (!isAttacked(i, j)) {

                    // Square (i, j) is unattacked.
                    // Therefore, place a queen here.
                    board[i][j] = true;

                    // Increment 'count' and proceed recursively.
                    placeQueen(countSoFar + 1);

                    // Remove this queen and attempt to
                    // find a better solution.
                    board[i][j] = false;
                }
            }
    }

    // Returns 'true' if the square (row, col) is
    // being attacked by at least one queen.
    static boolean isAttacked(int row, int col)
    {
        int i, j;

        // Check the 'col'th column for any queen.
        for (i = 0; i < N; ++i)
            if (board[i][col])
                return true;

        // Check the 'row'th row for any queen.
        for (j = 0; j < M; ++j)
            if (board[row][j])
                return true;

        // Check the diagonals for any queen.
        for (i = 0; i < Math.min(N, M); ++i)
            if (row - i >= 0 && col - i >= 0 &&
                    board[row - i][col - i])
                return true;
            else if (row - i >= 0 && col + i < M &&
                    board[row - i][col + i])
                return true;
            else if (row + i < N && col - i >= 0 &&
                    board[row + i][col - i])
                return true;
            else if (row + i < N && col + i < M &&
                    board[row + i][col + i])
                return true;

        // This square is unattacked. Hence return 'false'.
        return false;
    }

    // Stores the current layout in 'layout'
    // variable as String.
    static void storeLayout()
    {
        StringBuilder sb = new StringBuilder();
        for (boolean[] row : board) {
            for (boolean cell : row)
                sb.append(cell ? "Q " : "X ");
            sb.append("\n");
        }
        layout = sb.toString();
    }
}
