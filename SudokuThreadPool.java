// By Sesilly Cruz
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SudokuThreadPool{
	public static SudokuGenerator sg = new SudokuGenerator();

	/*	Generate the puzzles and set the difficulty 
 		by indicating the number of holes you want
		Easy: 32+ clues (49 or fewer holes)
		Medium: 27-31 clues (50-54 holes)
		Hard: 26 or fewer clues (54+ holes)*/	
	public static void main(String[] args){
		ExecutorService executor = Executors.newFixedThreadPool(9);
		long average = 0;
		long maximum = 0;		// keep track of average, maximum, and minimum
		long minimum = 0;

		for (int i = 0; i < 10; i++){		// For loop for how many puzzles we have 
			sg.board = sg.nextBoard(49);	// Set to easy difficulty and every puzzle			
			Runnable worker = new SudokuSolver(sg.board, 0, i, 1); // in each iteration is easy
			Runnable worker2 =  new SudokuSolver(sg.board, 0, i, 2);
			Runnable worker3 =  new SudokuSolver(sg.board, 0, i, 3);
			Runnable worker4 = new SudokuSolver(sg.board, 0, i, 4);
			Runnable worker5 =  new SudokuSolver(sg.board, 0, i, 5);
			Runnable worker6 =  new SudokuSolver(sg.board, 0, i, 6);
			Runnable worker7 = new SudokuSolver(sg.board, 0, i, 7);
			Runnable worker8 =  new SudokuSolver(sg.board, 0, i, 8);
			Runnable worker9 =  new SudokuSolver(sg.board, 0, i, 9);

			long startTime = System.nanoTime();
			executor.execute(worker);
			executor.execute(worker2);
			executor.execute(worker3);
			executor.execute(worker4);
			executor.execute(worker5);
			executor.execute(worker6);
			executor.execute(worker7);
			executor.execute(worker8);
			executor.execute(worker9);
			long endTime = System.nanoTime();

			average += endTime - startTime;
			if ((endTime - startTime) > maximum)	// find the max and min here
				maximum = endTime - startTime;
			if (minimum == 0)
				minimum = endTime - startTime;
			if ((endTime - startTime) < minimum)
				minimum = endTime - startTime;
			System.out.println((endTime - startTime) + " nanoseconds for Puzzle number " + (i+1));	// How long a puzzle

			if (i == 9){					// Print the average in a way that doesn't appear 
				average = average/10;		// between Sudoku rows
				System.out.println("Average: " + average);	
				System.out.println("Maximum: " + maximum);
				System.out.println("Minimum: " + minimum); 
			}		
		}		 		
		executor.shutdown();	
	}
}