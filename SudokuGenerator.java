import java.util.*;
import java.text.*;
/**
*The SudokuGenerator class creates a random standard (9x9)
*Sudoku board through the use of backtracking techniques.
*/
public class SudokuGenerator{
	public static final int BOARD_WIDTH = 9;
	public static final int BOARD_HEIGHT = 9;

   public SudokuGenerator() {
   	board = new int[BOARD_WIDTH][BOARD_HEIGHT];
   }
	public int[][] nextBoard(int difficulty){	// Create board based on difficulty
		board = new int[BOARD_WIDTH][BOARD_HEIGHT];
		nextCell(0,0);
		makeHoles(difficulty);
		return board;
	}
	
	public boolean nextCell(int x, int y){		// Recursively place every number in a cell
		int nextX = x;				// Return true if board is completed legally, false if cell has no legal solutions
		int nextY = y;
		int[] toCheck = {1,2,3,4,5,6,7,8,9};
		Random r = new Random();
		int tmp = 0;
		int current = 0;
		int top = toCheck.length;

   		for(int i = top - 1; i > 0;i--)
		{
		    current = r.nextInt(i);
		    tmp = toCheck[current];
		    toCheck[current] = toCheck[i];
		    toCheck[i] = tmp;
    	}
		
		for(int i = 0; i < toCheck.length; i++){
			if(legalMove(x, y, toCheck[i])){
				board[x][y] = toCheck[i];
				if(x == 8){
					if(y == 8)
						return true;	//We're done
					else{
						nextX = 0;
						nextY = y + 1;
					}
				}
				else{
					nextX = x + 1;
				}
				if(nextCell(nextX, nextY))
					return true;
			}
		}
		board[x][y] = 0;
		return false;
	}
	
	private boolean legalMove(int x, int y, int current) {		// Determine if a number insertion is legal
		for(int i = 0; i < 9; i++) {
			if(current == board[x][i])
				return false;
		}
		for(int i = 0; i < 9; i++) {
			if(current == board[i][y])
				return false;
		}
		int cornerX = 0;
		int cornerY = 0;
		if(x > 2)
			if(x > 5)
				cornerX = 6;
			else
				cornerX = 3;
		if(y > 2)
			if(y > 5)
				cornerY = 6;
			else
				cornerY = 3;
		for(int i = cornerX; i < 10 && i < cornerX + 3;i++)
			for(int j = cornerY; j < 10 && j < cornerY + 3; j++)
				if(current == board[i][j])
					return false;
		return true;
	}
	public void makeHoles(int holesToMake){		// Given a completed board, replace a given amount of cells with blanks	
		/* Difficulty is defined as followed:
			Easy: 32+ clues (49 or fewer holes)
			Medium: 27-31 clues (50-54 holes)
			Hard: 26 or fewer clues (54+ holes)
			This is human difficulty, not algorighmically (though there is some correlation)
		*/
		double remainingSquares = 81;
		double remainingHoles = (double)holesToMake;
		
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++){
				double holeChance = remainingHoles / remainingSquares;
				if(Math.random() <= holeChance){
					board[i][j] = 0;
					remainingHoles--;
				}
				remainingSquares--;
			}
	}
	
	public void print(){						// Prints a representation of board on stdout
		System.out.println("Random pre-filled board:");
		for(int i = 0;i < 9; i++){
			for(int j = 0;j < 9; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		SudokuGenerator sg = new SudokuGenerator();
	}
	
	int[][] board;
	private int operations;
}
