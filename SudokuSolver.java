// By Sesilly Cruz
public class SudokuSolver implements Runnable {
	public static int side = 3;	// subsquare side
	public int dim = 9;		// dimensions of the puzzle
	public static boolean[] works;	// boolean array
	public int[][] board = new int[9][9];
	public int index = 0;		// index that we use to increment/decrement via backtracking up to 81
	private int puzzleNum;		// number updated by thread pool for output clarity
	private int numStart;		// number that thread starts with when checking

	@Override
	public void run() {
		solveBoard(board,index);
	}

	public SudokuSolver(int[][] board, int index, int num, int numStart){
		this.board = board;
		this.index = index;
		this.puzzleNum = num;
		this.numStart = numStart;
	}

	public void solveBoard(int[][] board, int index){
		if (index == 81){
			System.out.println("------------------------");
			System.out.println("Puzzle number " + (puzzleNum + 1));	// Print puzzle number
			System.out.println("Solution found:"); 			// We've made it to the board's solution
			printBoard(board);

		}			
		else{
			int x = index % 9;
			int y = index / 9;
			if (board[y][x]!= 0)			// We're on a square that's already filled
				solveBoard(board, index + 1);	// so we move on to the next one
			else{
				if (numStart == 1){
					for(int i = 1; i <= 9; i++){				// We're on an empty square, so now we proceed
						if (noSubsquareConflicts(board,y,x,i)) 		// to check all possible ways
							if (noColumnConflicts(board,y,i))  	// that don't conflict with 
								if (noRowConflicts(board,x,i)){ // other numbers on the board 							
									board[y][x] = i;	// Pick a non-conflicting number
									solveBoard(board,index + 1);// and check if we can go off of that
									board[y][x] = 0;	// Undo if the path proves to be wrong
								}
					}
				}
				if (numStart == 2){
					for(int i = 2; i <= 9; i++){				// We're on an empty square, so now we proceed
						if (noSubsquareConflicts(board,y,x,i)) 		// to check all possible ways
							if (noColumnConflicts(board,y,i))  	// that don't conflict with 
								if (noRowConflicts(board,x,i)){ // other numbers on the board 
									board[y][x] = i;	// Pick a non-conflicting number
									numStart = 1;		// and check if we can go off of that
									solveBoard(board,index + 1); // with numStart changed to 1
									board[y][x] = 0;	// Undo if the path proves to be wrong
								}
					}
				}
				if (numStart == 3){
					for(int i = 3; i <= 9; i++){				// We're on an empty square, so now we proceed
						if (noSubsquareConflicts(board,y,x,i)) 		// to check all possible ways
							if (noColumnConflicts(board,y,i))  	// that don't conflict with 
								if (noRowConflicts(board,x,i)){ // other numbers on the board 
									board[y][x] = i;	// Pick a non-conflicting number
									numStart = 1;		// and check if we can go off of that
									solveBoard(board,index + 1); // with numStart changed to 1
									board[y][x] = 0;	// Undo if the path proves to be wrong
								}
					}
				}
				if (numStart == 4){
					for(int i = 4; i <= 9; i++){				// We're on an empty square, so now we proceed
						if (noSubsquareConflicts(board,y,x,i)) 		// to check all possible ways
							if (noColumnConflicts(board,y,i))  	// that don't conflict with 
								if (noRowConflicts(board,x,i)){ // other numbers on the board 
									board[y][x] = i;	// Pick a non-conflicting number
									numStart = 1;		// and check if we can go off of that
									solveBoard(board,index + 1); // with numStart changed to 1
									board[y][x] = 0;	// Undo if the path proves to be wrong
								}
					}
				}
				if (numStart == 5){
					for(int i = 5; i <= 9; i++){				// We're on an empty square, so now we proceed
						if (noSubsquareConflicts(board,y,x,i)) 		// to check all possible ways
							if (noColumnConflicts(board,y,i))  	// that don't conflict with 
								if (noRowConflicts(board,x,i)){ // other numbers on the board 
									board[y][x] = i;	// Pick a non-conflicting number
									numStart = 1;		// and check if we can go off of that
									solveBoard(board,index + 1); // with numStart changed to 1
									board[y][x] = 0;	// Undo if the path proves to be wrong
								}
					}
				}
				if (numStart == 6){
					for(int i = 6; i <= 9; i++){				// We're on an empty square, so now we proceed
						if (noSubsquareConflicts(board,y,x,i)) 		// to check all possible ways
							if (noColumnConflicts(board,y,i))  	// that don't conflict with 
								if (noRowConflicts(board,x,i)){ // other numbers on the board 
									board[y][x] = i;	// Pick a non-conflicting number
									numStart = 1;		// and check if we can go off of that
									solveBoard(board,index + 1); // with numStart changed to 1
									board[y][x] = 0;	// Undo if the path proves to be wrong
								}
					}
				}
				if (numStart == 7){
					for(int i = 7; i <= 9; i++){				// We're on an empty square, so now we proceed
						if (noSubsquareConflicts(board,y,x,i)) 		// to check all possible ways
							if (noColumnConflicts(board,y,i))  	// that don't conflict with 
								if (noRowConflicts(board,x,i)){ // other numbers on the board 
									board[y][x] = i;	// Pick a non-conflicting number
									numStart = 1;		// and check if we can go off of that
									solveBoard(board,index + 1); // with numStart changed to 1
									board[y][x] = 0;	// Undo if the path proves to be wrong
								}
					}
				}
				if (numStart == 8){
					for(int i = 8; i <= 9; i++){				// We're on an empty square, so now we proceed
						if (noSubsquareConflicts(board,y,x,i)) 		// to check all possible ways
							if (noColumnConflicts(board,y,i))  	// that don't conflict with 
								if (noRowConflicts(board,x,i)){ // other numbers on the board 
									board[y][x] = i;	// Pick a non-conflicting number
									numStart = 1;		// with numStart changed to 1
									solveBoard(board,index + 1);// and check if we can go off of that
									board[y][x] = 0;	// Undo if the path proves to be wrong
								}
					}
				}
				if (numStart == 9){
					for(int i = 9; i <= 9; i++){				// We're on an empty square, so now we proceed
						if (noSubsquareConflicts(board,y,x,i)) 		// to check all possible ways
							if (noColumnConflicts(board,y,i))  	// that don't conflict with 
								if (noRowConflicts(board,x,i)){ // other numbers on the board 
									board[y][x] = i;	// Pick a non-conflicting number
									numStart = 1;		// and check if we can go off of that
									solveBoard(board,index + 1); // with numStart changed to 1
									board[y][x] = 0;	// Undo if the path proves to be wrong
								}
					}
				}
			}
		}
	}
	private static boolean noSubsquareConflicts(int[][] board, int col, int row, int num){	// Check the subsquares for conflicts
		int beginRow = row - (row % side); 	
		int beginCol = col - (col % side);

		for (int i = 0; i < side; i++)		
			for (int j = 0; j < side; j++)	// Check the 9 sub-squares
				if (board[beginCol + i][beginRow + j] == num)
					return false;
		return true;
	}

	private static boolean noRowConflicts(int[][] board, int row, int num){			// Check the rows for conflicts
		for (int i = 0; i < 9; i++)	// Check the 9 rows
			if (board[i][row] == num)
				return false;		
		return true;
	}

	private static boolean noColumnConflicts(int[][] board, int col, int num){		// Check the columns for conflicts
		for (int i = 0; i < 9; i++)	// Check the 9 columns
			if (board[col][i] == num)
				return false;
		return true;
	}

	public static void printBoard(int[][] board){		// The solution's been found so now
		for (int i = 0; i < board.length; i++){		// it's time to print the board
			String b = "";							
			for (int j = 0; j < board.length; j++)
				b += board[i][j] + " ";
			System.out.println(b);
		}
		System.out.println();
	}
}
