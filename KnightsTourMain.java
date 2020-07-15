
/**
 * Project 2: Part II
 * 
 * File name: KnightsTourMain.java
 * 
 * This program is the main() that calls upon methods on the
 * KnightsTourOperations class to attempt to solve the Knight's Tour puzzle.
 * This program requires that KnightsTourMain.java and
 * KnightsTourOperations.java are in the same directory.
 * 
 * The objective of the Knight's Tour is for the Knight to visit every square in
 * an empty chess board regardless of the starting position. This is done by depth-first 
 * search and backtracking. A depth first search creates a search tree by exploring one 
 * branch of the tree as deeply as possible. Backtracking is the concept of making 
 * a series of decisions and following it through until it works or not. You then try 
 * something else in case it does not work. Think of the classic Pacman game! 
 * 
 *  
 * 
*/

import java.util.*;

public class KnightsTourMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello! Welcome to the Knight's Tour Puzzle!" + "\n");
        System.out.println("Please enter one number for the size of the board and press enter: ");
        int size = in.nextInt();

        System.out.println("Please enter one number for the row position and press enter: ");
        int row = in.nextInt();

        System.out.println("Please enter one number for the col of the board and press enter: ");
        int col = in.nextInt();

        System.out.println("\n" + "Ok! The board size is now " + size + " x " + size + "." + "\n");
        System.out.println("Knight will start from row " + row + ", column " + col + "." + "\n");
        System.out.println("Let's solve the puzzle..." + "\n");

        // This is here just to give an effect that the program is thinking!
        try {
            Thread.sleep(2000); // Sleep for 2 seconds.
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        // Assigned variables for the input provider by user.
        final int chessBoard = size;
        final int rowPos = row;
        final int colPos = col;

        // Instantiate the KnightsTourOperations class.
        KnightsTourOperations knightOPS = new KnightsTourOperations(chessBoard);

        // Start time - Used below to calculate how long it took to solve the puzzle.
        long startTime = System.currentTimeMillis();
        System.out.println("Here's the solution board: " + "\n");

        // Call method solve() in KnightsTourOperations class with input parameters.
        knightOPS.solve(rowPos, colPos);

        // Subtract start and end time to give the elapsed time taken to solve puzzle.
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("\n" + "The puzzle was solved in " + timeElapsed + " ms.");

        in.close(); // Close the scanner
    }

} // End of program