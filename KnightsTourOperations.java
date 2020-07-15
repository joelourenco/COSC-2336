/**
 * Project 2: Part II
 * 
 * File name: KnightsTourOperations.java
 * 
 * This file contains operations called by KnightsTourMain.java
 * 
 * This program attempts to solve the Knight's Tour puzzle by implementing a 2D
 * array, to represent the chess board, and constraints, the moves within the
 * board that the Knight may make. It follows a depth-first approach by making a
 * choice as to what direction to move and then onward until it either solves or
 * not. If it can not move after a certain point, it backtracks to a previous
 * point and tries again. This is the concept of backtracking.
 * 
 * This was an awesome challenge; however, it required more than my current
 * programming skills. I did augment my knowledge of using two dimensional
 * arrays, initialization, booleans, and applying problem solving logic. I
 * visualized in my head how to approach this problem; I knew arrays would have
 * to hold moves and positions. However, in order to implement it, I needed
 * help. I am grateful for all the online content I came across and discussions
 * via the Weekly Activity I had with classmates to get this to work. If I had
 * more time I would address the issue of the starting position. Thank you!
 */

public class KnightsTourOperations {

    private int boardSize; // Board size dimension parameter provided via input.
    private int[][] visitedSquare; // Array to keep track of position; it will help prevent an infinite loop.

    // Arrays that hold Row and Column positions as moves.
    // There are 8 possible moves; ex. (clockwise) 2 across, 1 up = (2,1).
    // Another example: -2 counter clockwise, and - 1 = (-2,-1).
    private int xRowMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private int yColMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

    // Constructor
    public KnightsTourOperations(int chessBoard) {
        this.boardSize = chessBoard; // Assign input for board size to boardSize.
        this.visitedSquare = new int[boardSize][boardSize]; // Double Array to hold row and col values.
        this.initializeBoard(); // This method creates the boundaries where moves are allowed.
    }

    // Initialize board with negative value since no position has yet been visited.
    private void initializeBoard() {
        for (int i = 0; i < boardSize; i++) // Loop through our rows
            for (int j = 0; j < boardSize; j++) // Loop through our columns
                this.visitedSquare[i][j] = Integer.MIN_VALUE; // Set row|col to -2^31; lowest negative int value.
    }

    // Function to solve the puzzle with the help of solvePuzzle().
    // If a solution is found, it calls printSolution() to print the board and
    // positions visited.
    public void solve(int row, int col) {
        // Starting position is input row and col, marked with a zero
        visitedSquare[row][col] = 0;
        // Call solvePuzzle method with parameters for first move, row, and col
        if (solvePuzzle(1, row, col)) {
            printSolution(); // Call function to print board and positions visited.
        } else {
            System.out.println("Sorry! I was not able to find a solution."); // If this prints, no solution was found.
        }
    }

    // Function that does the work of solving the puzzle.
    public boolean solvePuzzle(int moveCount, int x, int y) {
        // Base case of visited every position once.
        if (moveCount == boardSize * boardSize) {
            return true;
        }
        // Loop that controls the 8 available moves (combinations of x and y)
        for (int i = 0; i < xRowMove.length; ++i) {
            int nextX = x + xRowMove[i];
            int nextY = y + yColMove[i];

            // Verify if position is within boundaries of board and if it has been visited
            if (isValidMove(nextX, nextY) && visitedSquare[nextX][nextY] == Integer.MIN_VALUE) {

                visitedSquare[nextX][nextY] = moveCount;
                if (solvePuzzle(moveCount + 1, nextX, nextY)) {
                    return true;
                }

                // Backtrack: go back if it can not go forward.
                visitedSquare[nextX][nextY] = Integer.MIN_VALUE;
            }
        }
        return false;
    }

    // Function to check wether a move is within board's boundaries, or valid.
    public boolean isValidMove(int x, int y) {
        if (x < 0 || x >= boardSize || y < 0 || y >= boardSize) {
            return false; // False if x|y are less than 0 or greater than board size
        } else {
            return true; // True if x|y are within boundaries
        }
    }

    // Function to print the board and visited positions
    public void printSolution() {
        for (int i = 0; i < boardSize; i++) {
            System.out.print("\n[\t"); // Use of newline and tab to print board neatly
            for (int j = 0; j < boardSize; j++) {
                System.out.print(visitedSquare[i][j] + "\t");
            }
            System.out.print("]\n");
        }
    }

} // End of program