
public class tester {
	public static void main(String [] args) {
		String gameOver = "\n" + 
				"   ______                        ____                 \n" + 
				"  / ____/___ _____ ___  ___     / __ \\_   _____  _____\n" + 
				" / / __/ __ `/ __ `__ \\/ _ \\   / / / / | / / _ \\/ ___/\n" + 
				"/ /_/ / /_/ / / / / / /  __/  / /_/ /| |/ /  __/ /    \n" + 
				"\\____/\\__,_/_/ /_/ /_/\\___/   \\____/ |___/\\___/_/     \n" + 
				"                                                      \n" + 
				"";
		System.out.println(gameOver);
		String[][] board = new String[9][9];
		setMine(board, 10);
		printBoard(board);
	}
	public static void printBoard(String[][] minesweeper) {
		for(int i = 0 ;i < minesweeper.length; i++) {
			for(int j = 0; j < minesweeper[i].length; j++) {
				System.out.print(minesweeper[i][j] + " ");
			}
			System.out.println("");
		}
	}
	public static void setMine(String[][] minesweeper, int numMines) {
		for(int i = 0 ;i < minesweeper.length; i++) {
			for(int j = 0; j < minesweeper[i].length; j++) {
				minesweeper[i][j] = "-";
			}
		}
		for(int i = 0; i < numMines; i++) {
			int randRow = (int)(Math.random() * ((minesweeper.length - 0)));
			int randCol = (int)(Math.random() * ((minesweeper[0].length - 0) ));
			minesweeper[randRow][randCol] = "X";
		}
	}
	
	public static void mineMiss() {
		
	}
	
	public static void mineHit() {
		
	}
}
