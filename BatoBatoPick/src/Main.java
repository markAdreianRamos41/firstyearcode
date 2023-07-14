import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.*;

public class Main extends JFrame {
	Random random = new Random();
	ImageIcon[] scoreImages = new ImageIcon[4];
	String[] scoreImagesPath = {
			"Assets\\Scores\\Score0.png",
			"Assets\\Scores\\Score1.png",
			"Assets\\Scores\\Score2.png",
			"Assets\\Scores\\Score3.png",
	};
	ImageIcon[] optionsImages = new ImageIcon[3];
	JLabel[] optionButtons = new JLabel[3];
	String[] optionsImagesPath = {
			"Assets\\Options\\ScissorsOption.png",
			"Assets\\Options\\PaperOption.png",
			"Assets\\Options\\RockOption.png",
	};
	ImageIcon[] playerChoiceImages = new ImageIcon[3];
	String[] playerHandGesturesPath = {
			"Assets\\HandGestures\\ScissorsPlayer.png",
			"Assets\\HandGestures\\PaperPlayer.png",
			"Assets\\HandGestures\\RockPlayer.png",
	};
	ImageIcon[] computerChoiceImages = new ImageIcon[3];
	String[] computerHandGesturesPath = {
			"Assets\\HandGestures\\ScissorsAI.png",
			"Assets\\HandGestures\\PaperAI.png",
			"Assets\\HandGestures\\RockAI.png",
	};
	ImageIcon backgroundImage = new ImageIcon("Assets\\background.png");
	ImageIcon logoImage = new ImageIcon("Assets\\Logo\\Small.png");
	ImageIcon computerLabelImage = new ImageIcon("Assets\\Labels\\ComputerLabel.png");
	ImageIcon playerLabelImage = new ImageIcon("Assets\\Labels\\PlayerLabel.png");
	ImageIcon vsLabelImage = new ImageIcon("Assets\\Labels\\vs.png");
	ImageIcon playerChoiceImage = new ImageIcon("Assets\\NoSelection.png");
	ImageIcon computerChoiceImage = new ImageIcon("Assets\\NoSelection.png");
	int playerScoreIndex = 1;
	int computerScoreIndex = 0;
	JLabel playerScore;
	JLabel computerScore;
	JLabel playerChoice;
	JLabel computerChoice;

	public Main() {
		// Computer
		// Creating new instance of hand gestures image from the paths provided in the
		// array
		for (int index = 0; index < computerHandGesturesPath.length; index++) {
			computerChoiceImages[index] = new ImageIcon(computerHandGesturesPath[index]);
		}
		// Player
		// Creating new instance of hand gestures image from the paths provided in the
		// array
		for (int index = 0; index < playerHandGesturesPath.length; index++) {
			playerChoiceImages[index] = new ImageIcon(playerHandGesturesPath[index]);
		}
		// Label for image by button clicked
		playerChoice = new JLabel(playerChoiceImage);
		playerChoice.setBounds(106, 330, 193, 153);
		computerChoice = new JLabel(computerChoiceImage);
		computerChoice.setBounds(580, 330, 193, 153);
		// Creating new instance of options image from the paths provided in the array
		for (int index = 0; index < optionsImagesPath.length; index++) {
			optionsImages[index] = new ImageIcon(optionsImagesPath[index]);
		}
		// VS label between two hands
		JLabel vsLabel = new JLabel(vsLabelImage);
		vsLabel.setBounds(381, 360, 97, 55);
		// Player Hand label
		JLabel playerHandLabel = new JLabel(playerLabelImage);
		playerHandLabel.setBounds(64, 240, 216, 47);
		// Computer Hand label
		JLabel computerHandLabel = new JLabel(computerLabelImage);
		computerHandLabel.setBounds(511, 240, 320, 47);
		// Creating new instance of scores image from the paths provided in the array
		for (int index = 0; index < scoreImagesPath.length; index++) {
			scoreImages[index] = new ImageIcon(scoreImagesPath[index]);
		}
		// Creating label for player score
		// <-- IM USING IMAGES TO DISPLAY SCORE TO SOMEHOW PRESERVE FONT TO YOUR END
		// SIR!! -->
		playerScore = new JLabel(scoreImages[0]);
		computerScore = new JLabel(scoreImages[0]);
		computerScore.setBounds(844, 32, 30, 47);
		playerScore.setBounds(844, 101, 30, 47);
		// Player Label
		JLabel playerLabel = new JLabel(playerLabelImage);
		playerLabel.setBounds(560, 101, 216, 47);
		// Computer Label
		JLabel computerLabel = new JLabel(computerLabelImage);
		computerLabel.setBounds(453, 28, 320, 47);
		// Game logo
		JLabel logo = new JLabel(logoImage);
		logo.setBounds(0, 0, 240, 200);
		JPanel gamePanel = new JPanel();
		gamePanel.setBounds(60, 30, 880, 780);
		gamePanel.setBackground(Color.red);
		gamePanel.setLayout(null);
		gamePanel.setOpaque(false);
		gamePanel.add(logo);
		gamePanel.add(playerLabel);
		gamePanel.add(computerLabel);
		gamePanel.add(playerScore);
		gamePanel.add(computerScore);
		gamePanel.add(playerHandLabel);
		gamePanel.add(computerHandLabel);
		gamePanel.add(vsLabel);
		gamePanel.add(playerChoice);
		gamePanel.add(computerChoice);
		// Creating new instance of labels options image from the paths providedin the
		// array
		int optionButtonStartPosition = 50;
		for (int index = 0; index < optionButtons.length; index++) {
			optionButtons[index] = new JLabel(optionsImages[index]);
			optionButtons[index].setBounds(optionButtonStartPosition, 580,
					198, 198);
			optionButtonStartPosition += 293;
			gamePanel.add(optionButtons[index]);
		}
		// setup the Background image of the frame
		JLabel background = new JLabel(backgroundImage);
		background.setBounds(0, 0, 1000, 1000);
		setSize(1000, 1000);
		setLocationRelativeTo(null);
		setTitle("BatoBatoPicGame Midterm - Week 10 - Lab Act (Mark AdreianRamos)");
		setResizable(false);
		setLayout(null);
		add(gamePanel);
		add(background);
		setVisible(true);
		// Adding action listener for every instance of rock paper scissors button
		for (int buttonIndex = 0; buttonIndex < optionButtons.length; buttonIndex++) {
			final int index = buttonIndex;
			optionButtons[buttonIndex].addMouseListener(new MouseAdapter() {
				int button = index;

				public void mouseClicked(MouseEvent e) {
					// Updating displayed image on the screen when a button is clicked
					int randomNumber = random.nextInt(3);
					playerChoice.setIcon(playerChoiceImages[button]);
					computerChoice.setIcon(computerChoiceImages[randomNumber]);
					updatePlayerDisplayedScore(getPlayerScore());
					repaint();
					// System.out.println("Computer random number: " +randomNumber);
					if (index == randomNumber) {
						System.out.println("Draw");
					} else {
						// Scissors vs Paper
						if (index == 0 && randomNumber == 1)
							updatePlayerStatus();
						// Paper vs Scissors
						if (index == 1 && randomNumber == 0)
							updateComputerStatus();
						// Scissors vs Rock
						if (index == 0 && randomNumber == 2)
							updateComputerStatus();
						// Rock vs Scissors
						if (index == 2 && randomNumber == 0)
							updatePlayerStatus();
						// Paper vs Rock
						if (index == 1 && randomNumber == 2)
							updatePlayerStatus();
						// Rock vs Paper
						if (index == 2 && randomNumber == 1)
							updateComputerStatus();
						boolean hasWinner = checkWinner();
						if (hasWinner)
							resetGame(playerScore,
									computerScore);
					}
				}
			});
		}
	}

	public static void main(String[] args) {
		new Main();
	}

	// SETTERS AND GETTERS for player score
	// I use this because i can't access
	// variables from the mouse adapter since it is a different class
	public int getPlayerScore() {
		return playerScoreIndex;
	}

	public void setPlayerScore(int currentScore) {
		playerScoreIndex = currentScore;
	}

	public int getComputerScore() {
		return computerScoreIndex;
	}

	public void setComputerScore(int currentScore) {
		computerScoreIndex = currentScore;
	}

	// SETTERS AND GETTERS for player score
	// Method for updating player score
	public void updatePlayerScore() {
		int playerCurrentScore = getPlayerScore();
		setPlayerScore(playerCurrentScore + 1);
	}

	// Method for updating computer score
	public void updateComputerScore() {
		int computerCurrentScore = getComputerScore();
		setComputerScore(computerCurrentScore + 1);
	}

	// Updating the score board displayed in the frame
	// since I'm using images to display scores
	// For player score
	public void updatePlayerDisplayedScore(int index) {
		playerScore.setIcon(scoreImages[index]);
		repaint();
	}

	// For computer score
	public void updateComputerDisplayedScore(int index) {
		System.out.println(index);
		computerScore.setIcon(scoreImages[index]);
		repaint();
	}

	// I enclose the methods above so that i will not copy pasting too much code
	// Updated method for player
	public void updatePlayerStatus() {
		updatePlayerScore();
		updatePlayerDisplayedScore(getPlayerScore());
	}

	// Updated method for computer
	public void updateComputerStatus() {
		updateComputerScore();
		updateComputerDisplayedScore(getComputerScore());
	}

	// returns true if there is a winner
	public boolean checkWinner() {
		int playerScore = getPlayerScore();
		int computerScore = getComputerScore();
		if (playerScore == 3) {
			JOptionPane.showMessageDialog(null, "Player Wins!");
			return true;
		}
		if (computerScore == 3) {
			JOptionPane.showMessageDialog(null, "Computer Wins!");
			return true;
		}
		return false;
	}

	// Reset the game whenever their is a winner
	public void resetGame(JLabel playerScore, JLabel computerScore) {
		playerScoreIndex = 0;
		computerScoreIndex = 0;
		playerScore.setIcon(scoreImages[0]);
		computerScore.setIcon(scoreImages[0]);
		playerChoice.setIcon(playerChoiceImage);
		computerChoice.setIcon(computerChoiceImage);
		repaint();
	}
}