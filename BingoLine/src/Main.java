import java.util.Scanner;
import java.util.Random;
public class Main {
	
	//Setting  global variables
	static Scanner input = new Scanner(System.in);
	static Random random = new Random();
	
	static String playerOneMark = "1";
	static String playerTwoMark = "2";

	public static void main(String[] args) {
		
		
		boolean isGameRunning = true;
		
		
		//Asking input to the user
		System.out.println("Bingo Line Game");
		System.out.println("A: Play the Game");
		System.out.println("B: Exit the game");
		System.out.print("Choice: ");
		
		String userChoice = input.next().toUpperCase();
		
		
		
		
		//Menu Sequence for the game
		while(isGameRunning) {
			switch(userChoice) {
				case "A": 
					playGame();
					break;
					
				case "B":
					System.out.println("Thank you for playing!");
					//ends the game
					return;
				default: 
					//Let the enter a new valid input for the menu
					System.out.print("Invalid input please try again: ");
					userChoice = input.next().toUpperCase();
					
			}
		}	
		
		

	}
	
	public static void playGame() {
		//Create a board for the game
		String[][] board = createMainBoard();
		
		//Entering names for player 1 and 2
		System.out.println("Enter name for player 1: ");
		String playerOneName = input.next();
		
		System.out.println("Enter name for player 2: ");
		String playerTwoName = input.next();
		
		
		//Random start whether player 1 or 2 is the first turn
		boolean isPlayerOneTurn = random.nextBoolean();
		//Set no winner by default 
		boolean winner = false;
		
		//while there is no winner let the user mark the board
		while(!winner) {
			if(isPlayerOneTurn) {
				
				//Asking the user to specify what column to insert
				System.out.print(playerOneName +"'s turn enter column number: " );
				int columnNumber = input.nextInt(); 
				
				//insert players mark as defined as static variable
				board = insertMark(board, playerOneMark, columnNumber);
				
				//negate the value to let the other player make a turn
				isPlayerOneTurn = !isPlayerOneTurn;
				
				displayBoard(board);
			}
			else {
				
				//insert players mark as defined as static variable
				System.out.print(playerTwoName +"'s turn enter column number: " );
				int columnNumber = input.nextInt(); 
				board = insertMark(board, playerTwoMark, columnNumber);
				
				isPlayerOneTurn = !isPlayerOneTurn;
				displayBoard(board);
			}
		}
		
	}
	
	
	public static String[][] insertMark(String[][] board, String playerMark, int columnNumber) {
		String [][] updatedBoard = new String[6][7];
		
		int lastRowInBoard = board.length - 1;
		int currentIndex = lastRowInBoard;
		
		//For the last row
		for(int column = 0; column < board[lastRowInBoard].length; column++) {
			
			// if the column number is equal to the user input
			if(column == columnNumber - 1) {
				
				//will check if the specific column is empty or not
				while(!board[lastRowInBoard][column].toLowerCase().equals("empty")) {
					//if the column is NOT empty move the column upward
					currentIndex--;
					
					//if the column is empty then break the loop
					if(board[currentIndex][column].toLowerCase().equals("empty")) {
						break;
					}
				}
				
				//set player mark to the empty column
				board[currentIndex][column]= playerMark;
				break;
				
			}
		
			
		}
		
		updatedBoard =  board;
		return  updatedBoard;
	}
	
	public static String[][] createMainBoard(){
		int rows = 6;
		int columns = 7;
		
		// creates a board with 6 rows and 7 columns
		
		String[][] board = new String[rows][columns];
		for(int row = 0; row < board.length; row++) {
			for(int column = 0; column < board[row].length; column++) {
				
				//then set each cell to "Empty"
				board[row][column] = "Empty";
			}

		}
		
		return board;
	}
	
	public static void displayBoard(String[][] board) {
		
		//Display the current status of the board to the screen
		System.out.println("\nGAME BOADRD: ");
		for(int row = 0; row < board.length; row++) {
			for(int column = 0; column < board[row].length; column++) {
				System.out.print("" + board[row][column] + "\t");
			}
			System.out.println();
		}
		
	}
	
	

}
