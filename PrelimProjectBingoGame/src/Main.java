import java.util.Scanner;

public class Main {
	
	static int cardListDefaultSize = 0;
	static String[][][] cardList = new String[cardListDefaultSize][5][5];  //Default setup where in no cards are inserted
	static String[][][] cardListComputer = new String[cardListDefaultSize][5][5];
	static int winnerCardIndex = 0;
	static String winner = "";
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int playerBalance = 200;
		
		boolean isGameActive = true;
		
		System.out.println(" /$$$$$$$ /$$                           \r\n"
				+ "| $$__  $|__/                           \r\n"
				+ "| $$  \\ $$/$$/$$$$$$$  /$$$$$$  /$$$$$$ \r\n"
				+ "| $$$$$$$| $| $$__  $$/$$__  $$/$$__  $$\r\n"
				+ "| $$__  $| $| $$  \\ $| $$  \\ $| $$  \\ $$\r\n"
				+ "| $$  \\ $| $| $$  | $| $$  | $| $$  | $$\r\n"
				+ "| $$$$$$$| $| $$  | $|  $$$$$$|  $$$$$$/\r\n"
				+ "|_______/|__|__/  |__/\\____  $$\\______/ \r\n"
				+ "                      /$$  \\ $$         \r\n"
				+ "                     |  $$$$$$/         \r\n"
				+ "                      \\______/ ");
		
		while(isGameActive) {
			System.out.println("Let's Play Bingo!");
			System.out.println("Player Balance: P" + playerBalance);
			System.out.println("Please select an operation: ");
			System.out.println("A. Play Bingo");
			System.out.println("B. Buy a bingo card.");
			System.out.println("C. See your cards.");
			System.out.println("D. Exit game");
			
			System.out.print("Operation: ");
			String userInput = input.next().toUpperCase();
			
			switch(userInput) {
				case "A":
					boolean hasWinner = false;
					boolean isPlayerWinner = false;
					boolean isComputerWinner = false;
					if (cardList.length == 0) {
						System.out.println("\n==============================================");
						System.out.println("No cards found! Please buy a bingo card first");
						System.out.println("==============================================\n");
					}
					else {
						while(!hasWinner) {
//							System.out.print("Player: ");
							boolean[] playerStatus = checkWinner(cardList, "player");
//							System.out.print("Computer: ");
							boolean[] computerStatus = checkWinner(cardListComputer, "computer");
							
							isPlayerWinner = checkStatus(playerStatus);
							isComputerWinner = checkStatus(computerStatus);
							
//							System.out.println("Player status: " + isPlayerWinner);
//							System.out.println("Computer status: " + isComputerWinner);
							

							if(isPlayerWinner && isComputerWinner) {
								winner = "draw";
								break;
							}
							else if(isPlayerWinner) {
								winner = "player";
								break;
							}
							else if (isComputerWinner) {
								winner = "computer";
								break;
							} 
							else {
//								System.out.println("Proceed to draw?: ");
//								String askDraw = input.next();
								int hostDrawnNumber = drawNumber();
								System.out.println("\nDrawn Number: " + hostDrawnNumber);
								markAllCards(hostDrawnNumber);
									
								for(int cardPosition = 0; cardPosition < cardList.length; cardPosition++) {
									System.out.println("===================================");
									System.out.println("Player Card " + (cardPosition + 1));
									displayCard(cardList[cardPosition]);
									
									
								}	
								
								for(int cardPosition = 0; cardPosition < cardList.length; cardPosition++) {
									System.out.println("===================================");
									System.out.println("Computer Card " + (cardPosition + 1));
									displayCardComputer(cardListComputer[cardPosition]);
									System.out.println("===================================");
									
									
								}	
								
								
								
								
							}
								
						}
						
						if(winner.equals("player")) {
							int winnings = cardList.length * 100;
							playerBalance += winnings;
							System.out.println("\n=============");
							System.out.println("BINGO YOU WIN");
							System.out.println("=============\n");

							
							System.out.println("===========WINNING CARD===========");
							System.out.println("Player Card " + (winnerCardIndex + 1));
							displayCard(cardList[winnerCardIndex]);
							System.out.println("===========WINNING CARD============");
					
								
						}
							
					
						
						if(winner.equals("computer")) {
							System.out.println("\n===================");
							System.out.println("BINGO COMPUTER WINS");
							System.out.println("===================\n");
							
							System.out.println("===========WINNING CARD===========");
							System.out.println("Computer Card " + (winnerCardIndex + 1));
							displayCard(cardListComputer[winnerCardIndex]);
							System.out.println("===========WINNING CARD============");
						}
						
						if(winner.equals("draw")) {
							playerBalance += 100;
							System.out.println("==========");
							System.out.println("BINGO DRAW");
							System.out.println("==========\n");
							
						}
						
						
						cardListDefaultSize = 0;
						cardList = new String[cardListDefaultSize][5][5];
						cardListComputer = new String[cardListDefaultSize][5][5];
						
					}
					
					
					
					
					break;
				case "B":
					if(playerBalance < 50) {
						System.out.println("\n========================");
						System.out.println("Sorry not enough balance");
						System.out.println("========================\n");
					}
					else {
						System.out.println("\n==========================================");
						System.out.println("New card has been added to your card list");
						cardList = updateCardList(cardList);
						System.out.println("==========================================\n");
						
						playerBalance -= 50;
						
					}
					break;
				case "C":
					
					if(cardList.length == 0) {
						System.out.println("\n===============================");
						System.out.println("You have no cards at the moment");
						System.out.println("===============================\n");
						
					}
					else {
						System.out.println("\nHere is your card list");
						for(int cardPosition = 0; cardPosition < cardList.length; cardPosition++) {
							System.out.println("=================");
							System.out.println("Card" + (cardPosition + 1));
							displayCard(cardList[cardPosition]);
							System.out.println("=================\n");
						}
					}
					
					break;
				case "D":
						isGameActive = false;
						System.out.println(" _______ _                 _                                ___              \r\n"
								+ "(_______) |               | |                              / __)             \r\n"
								+ "    _   | |__  _____ ____ | |  _    _   _  ___  _   _    _| |__ ___   ____   \r\n"
								+ "   | |  |  _ \\(____ |  _ \\| |_/ )  | | | |/ _ \\| | | |  (_   __) _ \\ / ___)  \r\n"
								+ "   | |  | | | / ___ | | | |  _ (   | |_| | |_| | |_| |    | | | |_| | |      \r\n"
								+ "   |_|  |_| |_\\_____|_| |_|_| \\_)   \\__  |\\___/|____/     |_|  \\___/|_|      \r\n"
								+ "                                   (____/                                    \r\n"
								+ "       _              _                                                      \r\n"
								+ "      | |            (_)                                                     \r\n"
								+ " ____ | | _____ _   _ _ ____   ____                                          \r\n"
								+ "|  _ \\| |(____ | | | | |  _ \\ / _  |                                         \r\n"
								+ "| |_| | |/ ___ | |_| | | | | ( (_| |                                         \r\n"
								+ "|  __/ \\_)_____|\\__  |_|_| |_|\\___ |                                         \r\n"
								+ "|_|            (____/        (_____|    ");
					break;
				default:
					System.out.println("Invalid Input!");
			}
			
			
			
			
		}
		
		
			
		
	}
	
	// ======================== CREATING CARD AND UPDATING CARD LIST ========================
	public static String[][][] updateCardList(String[][][] prevCardList) {
		
		
		String[][] newCard = createCard();
		String[][] newCardComputer = createCard();
		
		displayCard(newCard);
		
		cardListDefaultSize += 1;
		
		String[][][] cardList = new String[cardListDefaultSize][5][5]; //Creating new cardList with size of the prevCardList + 1
		String[][][] newCardListComputer = new String[prevCardList.length + 1][5][5];
		
		//then populating the cards to the new card list and inserting the newly created card
		for(int cardPosition = 0; cardPosition < cardList.length; cardPosition++) {
			if (cardPosition < prevCardList.length) {
				cardList[cardPosition] = prevCardList[cardPosition];
				newCardListComputer[cardPosition] = cardListComputer[cardPosition];
			}
			else {
				cardList[cardPosition] = newCard;
				newCardListComputer[cardPosition] = newCardComputer;
			}
		}
		
		cardListComputer = newCardListComputer;
		return cardList;

	}
	
	public static String[][] createCard() {
		
		String[][] card = new String[5][5]; 		 //Container for the card in String data type
		int cardCenterPosition = (card.length / 2);  //Dynamically identifying the index of the center cell of the card
		int[][] cardDetails = new int[5][5];		 //Record for numbers to be put in the card.
				
		//Population the card columns with specific range
		for(int row = 0; row < card.length; row++) {
			for(int column = 0; column < card[row].length; column++) {
				
				int randomNumber = generateRandomNumber(column);  //Generating a range of random number for a specific column
				boolean isItemExist = isItemAlreadyExist(column, randomNumber, cardDetails); //checking whether the number already exist in the column
				
				//Prevent columns to have duplicated values
				while(isItemExist) {
					randomNumber =  generateRandomNumber(column);
					isItemExist = isItemAlreadyExist(column, randomNumber, cardDetails);
				}
				
				
				cardDetails[row][column] = randomNumber; //Used to keep track of numbers inserted in the card to prevent duplication.
				
				
				if(row == cardCenterPosition && column == cardCenterPosition) card[row][column] = "free";
				else card[row][column] = String.valueOf(randomNumber);
				
				
			}
		}
		
		return card;
	}
	
	public static void displayCard(String[][]card) {
		System.out.println("B\tI\tN\tG\tO");
		for(int row = 0; row < card.length; row++) {
			for(int column = 0; column < card[row].length; column++) {
				System.out.print(card[row][column] + "\t");
			}		
			System.out.println();
		}
	}
	
	public static boolean isItemAlreadyExist(int columnNumber, int item, int[][] cardDetails) {
		boolean isAlreadyExisted = false; 
		
		//Checking if the item for a specific column is repeated or not
		for(int row = 0; row < cardDetails.length; row++) {
			for(int column = 0; column < cardDetails[row].length; column++) {
				if(column == columnNumber) {
					int itemChecking = cardDetails[row][column];
					if(item == itemChecking) {
						isAlreadyExisted = true;
						break;
					}
				}	
			}
		}
		
		return isAlreadyExisted;
	}

	public static int generateRandomNumber(int column) {
		//generating range of random number for a specific column;
		
		// column == 4 => letter O column => range = 61 - 75
		// column == 3 => letter G column => range = 46 - 60
		// column == 2 => letter N column => range = 45 - 31
		// column == 1 => letter I column => range = 16 - 30
		// column == 0 => letter B column => range = 1 - 15
		
		int randomNumber = 0;
		if(column == 4)  randomNumber = (int)Math.floor(Math.random() * (75 - 61 + 1) + 61);
		if(column == 3)  randomNumber = (int)Math.floor(Math.random() * (60 - 46 + 1) + 46);
		if(column == 2)  randomNumber = (int)Math.floor(Math.random() * (45 - 31 + 1) + 31);
		if(column == 1)  randomNumber = (int)Math.floor(Math.random() * (30 - 16 + 1) + 16);
		if(column == 0)  randomNumber = (int)Math.floor(Math.random() * (15 - 1 + 1) + 1);
		
		return randomNumber;
	}
	// ======================== CREATING CARD AND UPDATING CARD LIST ========================
	
	// ======================== PLAYING BINGO ========================
	public static int drawNumber() {
		int randomNumber = (int)Math.floor(Math.random() * (75 - 1 + 1) + 1);
		return randomNumber;
	}
	
	public static void markAllCards(int randomNumber) {
		
		//Setting the column number based from the value of random number
		int cardColumnNumber = 0;
		if(randomNumber >= 61)  cardColumnNumber = 4;
		else if(randomNumber >= 46)  cardColumnNumber = 3;
		else if(randomNumber >= 31)  cardColumnNumber = 2;
		else if(randomNumber >= 16)  cardColumnNumber = 1;
		else if(randomNumber >= 1)  cardColumnNumber = 0;
	
		
		//Iterating the card list
		//represent the whole card
		for(int card = 0; card < cardList.length; card++) { 
			//represent the row of the card
			for(int cardRow = 0; cardRow < cardList[card].length; cardRow++) { 
				//represent the column of the card
				for(int cardColumn = 0; cardColumn < cardList[card][cardRow].length; cardColumn++) {
					if(cardColumnNumber == cardColumn) {
						//cross out the card if the number matches the column and the value
						if (String.valueOf(randomNumber).equals(cardList[card][cardRow][cardColumn])) {
							cardList[card][cardRow][cardColumn] = "x";
							
						}
						
						if (String.valueOf(randomNumber).equals(cardListComputer[card][cardRow][cardColumn])) {
							cardListComputer[card][cardRow][cardColumn] = "x";
							
						}
					}
				}
			}
		}
	}
	
	public static boolean[] checkWinner(String[][][] cardList, String playingAs) {
		int[][][] winningCombinations = {
				//Horizontal Combinations
				{{0, 0},{0, 1},{0, 2},{0, 3},{0, 4}},
				{{1, 0},{1, 1},{1, 2},{1, 3},{1, 4}},
				{{2, 0},{2, 1},{2, 2},{2, 3},{2, 4}},
				{{3, 0},{3, 1},{3, 2},{3, 3},{3, 4}},
				{{4, 0},{4, 1},{4, 2},{4, 3},{4, 4}},
				
				//Vertical Combinations
				{{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}},
				{{0, 1}, {1, 1}, {2, 1}, {3, 1}, {4, 1}},
				{{0, 2}, {1, 2}, {2, 2}, {3, 2}, {4, 2}},
				{{0, 3}, {1, 3}, {2, 3}, {3, 3}, {4, 3}},
				{{0, 4}, {1, 4}, {2, 4}, {3, 4}, {4, 4}},
				
				//Diagonal Combination
				{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}},
				{{0, 4}, {1, 3}, {2, 2}, {3, 1}, {4, 0}},
					
		};
		boolean isMatchCombination = false;
		boolean[] isConditionMet = new boolean[5];
		for(int combination = 0; combination < winningCombinations.length; combination++) {
			
			for(int positions = 0; positions < winningCombinations[combination].length; positions++) {
				
				int rowPosition = winningCombinations[combination][positions][0];
				int columnPosition = winningCombinations[combination][positions][1];
				
				isMatchCombination = checkCombination(rowPosition, columnPosition, playingAs);
				isConditionMet[positions] = isMatchCombination;
				
			}		
			
			
			for(int condition = 0; condition < isConditionMet.length; condition++) {
				if(isConditionMet[condition] == false) {
					isMatchCombination = false;
					break;
				}
				else {
					isMatchCombination = true;
				}
			}
			
			if(isMatchCombination) break;
			
		}
		
//		System.out.println(Arrays.toString(isConditionMet));		
		
		return isConditionMet;
		
	}
	
	public static boolean checkCombination(int rowPosition, int columnPosition, String playingAs) {
		
		boolean isMatchCombination = false;
		
		//represent each card in the card list
		for(int cardIndex = 0; cardIndex < cardList.length; cardIndex++) { 
			String cardCellElement = cardList[cardIndex][rowPosition][columnPosition];
			String cardCellElementComputer = cardListComputer[cardIndex][rowPosition][columnPosition];
			
			
			if(playingAs.equals("computer")) {
				if(cardCellElementComputer.contentEquals("x") || cardCellElementComputer.contentEquals("free")) {
					isMatchCombination = true;
				}
						
				else {
					
					isMatchCombination = false;
					break;
				}
			}
			

			if(playingAs.equals("player")) {
				if(cardCellElement.contentEquals("x") || cardCellElement.contentEquals("free")) {
					isMatchCombination = true;
				}
						
				else {
					
					isMatchCombination = false;
					break;
				}
			}
	
			
			winnerCardIndex = cardIndex;
		

		}

		return isMatchCombination;
		
		
	}
	
	
	public static boolean checkStatus(boolean[] isConditionMet) {
		boolean isMatchCombination = false;
		for(int condition = 0; condition < isConditionMet.length; condition++) {
			if(isConditionMet[condition] == false) {
				isMatchCombination = false;
				break;
			}
			else {
				isMatchCombination = true;
			}
		}
		
		return isMatchCombination;
	}
	// ======================== PLAYING BINGO ========================	

	public static void displayCardComputer(String[][]card) {
		System.out.println("B\tI\tN\tG\tO");
		for(int row = 0; row < card.length; row++) {
			for(int column = 0; column < card[row].length; column++) {
				System.out.print(card[row][column] + "\t");
			}		
			System.out.println();
		}
	}
}

