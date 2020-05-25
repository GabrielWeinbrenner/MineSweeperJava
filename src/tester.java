import java.util.Arrays;
import java.util.Scanner; 

public class tester {
	public static void main(String [] args) {
		String intro = "\n" + 
				"  __  __ _                                                   \n" + 
				" |  \\/  (_)                                                  \n" + 
				" | \\  / |_ _ __   ___  _____      _____  ___ _ __   ___ _ __ \n" + 
				" | |\\/| | | '_ \\ / _ \\/ __\\ \\ /\\ / / _ \\/ _ \\ '_ \\ / _ \\ '__|\n" + 
				" | |  | | | | | |  __/\\__ \\\\ V  V /  __/  __/ |_) |  __/ |   \n" + 
				" |_|  |_|_|_| |_|\\___||___/ \\_/\\_/ \\___|\\___| .__/ \\___|_|   \n" + 
				"                                            | |              \n" + 
				"                                            |_|              \n";
		String gameOver = "\n" + 
				"   _____                         ____                 \n" + 
				"  / ____|                       / __ \\                \n" + 
				" | |  __  __ _ _ __ ___   ___  | |  | |_   _____ _ __ \n" + 
				" | | |_ |/ _` | '_ ` _ \\ / _ \\ | |  | \\ \\ / / _ \\ '__|\n" + 
				" | |__| | (_| | | | | | |  __/ | |__| |\\ V /  __/ |   \n" + 
				"  \\_____|\\__,_|_| |_| |_|\\___|  \\____/  \\_/ \\___|_|   \n" + 
				"                                                      \n" + 
				"                                                      \n";
		String gameWon = "\n" + 
				"   _____                       __          __         \n" + 
				"  / ____|                      \\ \\        / /         \n" + 
				" | |  __  __ _ _ __ ___   ___   \\ \\  /\\  / /__  _ __  \n" + 
				" | | |_ |/ _` | '_ ` _ \\ / _ \\   \\ \\/  \\/ / _ \\| '_ \\ \n" + 
				" | |__| | (_| | | | | | |  __/    \\  /\\  / (_) | | | |\n" + 
				"  \\_____|\\__,_|_| |_| |_|\\___|     \\/  \\/ \\___/|_| |_|\n" + 
				"                                                      \n" + 
				"                                                      \n";
		System.out.println(intro);
		int amountOfMines = 10;
		String[][] board = new String[9][9];
		String[] mines = setMine(board, amountOfMines);
		Scanner scanner = new Scanner(System.in);

		System.out.println();
		do {
			do {
				printBoard(board);
				System.out.println("What is the row you chose? ");
				int row = scanner.nextInt() -1 ;
				System.out.println("What is the column you chose? ");
				int column = scanner.nextInt() -1 ;
				if(isMineHit(row,column,mines).equals("X")) {
					board[row][column] = "X";
					printBoard(board);
					System.out.println(gameOver);
					break;
				}else {
					board[row][column] = "O";
				}
				if(isGameWon(board, amountOfMines)) {
					System.out.println(gameWon);
					break;
				}
			}while(true);
			System.out.println("Would you like to play Again?(yes or no) ");
			String yesOrNo = scanner.next();
			if(!(yesOrNo.equals("y") || yesOrNo.equals("Y") || yesOrNo.equals("yes"))) {
				break;
			}
			board = new String[9][9];
			mines = setMine(board, amountOfMines);
		}while(true);
	}
	public static boolean isGameWon(String[][] board, int amountOfMines) {
		var count = 0;
		for(int i = 0 ;i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j].equals("X")) {
					count++;
				}
			}
		}
		if(count == amountOfMines) {
			return true;
		}
		return false;
	}
	public static void printBoard(String[][] board) {
		System.out.print("  ");
		for(int i = 1 ; i <= board.length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i = 0 ;i < board.length; i++) {
			System.out.print(i +1 + " ");
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}
	public static String[] setMine(String[][] board, int numMines) {
		for(int i = 0 ;i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = "-";
			}
		}
		String[] mines = new String[numMines];
		int count = numMines;
		do {
			int randRow = (int)(Math.random() * ((board.length - 0)));
			int randCol = (int)(Math.random() * ((board[0].length - 0) ));
			String coords = randRow+" "+randCol;
			if(!(Arrays.asList(mines).contains(coords))) {
				mines[count-1] = coords;
				count--;
			}
		}while(count > 0);
		return mines;
	}
	public static String isMineHit(int row, int col, String[] mines) {
		String coords = (row)+" "+(col);
		if(!(Arrays.asList(mines).contains(coords))) {
			return "X";
		}
		return "O";
	}
}
