import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.script.ScriptException;
import java.util.Random;


public class Main extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1; 
	private JLabel lblNewLabel_1_2_1;
	private JLabel lblNewLabel_1_2_2;
	private JLabel lblNewLabel_1_2_3;
	private JLabel lblNewLabel_1_2_4;
	private JRadioButton rdbtnEasy;
	private JRadioButton rdbtnAverage;
	private JRadioButton rdbtnDifficult;
	private JButton btnStart; 
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JTextField textField1;
	private JButton btnNewButton_2;
	private JButton returnButton;

	private JTextField textField2;
	private JButton btnNewButton_3;
	int currentQuestionNumber = 1;
	int playerScore = 0;
	Random random = new Random();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	

	/**
	 * Create the frame.
	 */
	
	
	public int findIndex(char operand) {
		char[] operandOrder = {'-', '+', '/', '*'};
		int index = 0;
		
		for(int i = 0; i < operandOrder.length; i++) {
			if(operand == operandOrder[i]) index = i;
		}
		return index;
	}
	
	public double getResult(String question) {
		char[] questionData = question.toCharArray(); 
		
		char operand = questionData[1];
		double firstNumber = Double.parseDouble(String.valueOf(questionData[0]));
		double secondNumber = Double.parseDouble(String.valueOf(questionData[2]));
		double result = 0;
		
		if(operand == '+') result = firstNumber + secondNumber;
		if(operand == '-') result = firstNumber - secondNumber;
		if(operand == '*') result = firstNumber * secondNumber;
		if(operand == '/') result = firstNumber / secondNumber;
		double roundedResult = Math.round(result);
		System.out.println(roundedResult);
		return roundedResult;
		
	}
	public double getResultDifficult(String question) {
		char[] questionData = question.toCharArray(); 
		
		char operand = questionData[1];
		double firstNumber = Double.parseDouble(String.valueOf(questionData[0]));
		double secondNumber = Double.parseDouble(String.valueOf(questionData[2]));
		double result = 0;
		
		if(operand == '+') result = firstNumber + secondNumber;
		if(operand == '-') result = firstNumber - secondNumber;
		if(operand == '*') result = firstNumber * secondNumber;
		if(operand == '/') result = firstNumber / secondNumber;
		double roundedResult = Math.round(result);
		System.out.println(roundedResult);
		return roundedResult;
		
	}
	public double getResultAverage(String question) {
		char[] questionData = question.toCharArray(); 
		
		char firstOperand = questionData[1];
		char secondOperand = questionData[3];
		double firstNumber = Double.parseDouble(String.valueOf(questionData[0]));
		double secondNumber = Double.parseDouble(String.valueOf(questionData[2]));
		double thirdNumber = Double.parseDouble(String.valueOf(questionData[4]));
		
		

		int indexFirst = findIndex(firstOperand);
		int indexSecond = findIndex(secondOperand);
		
		double totalResult = 0;
		double initialResult = 0;
	
		if(indexFirst < indexSecond) {
			
			if(secondOperand == '+') initialResult = secondNumber + thirdNumber;
			if(secondOperand == '-') initialResult = secondNumber - thirdNumber;
			if(secondOperand == '*') initialResult = secondNumber * thirdNumber;
			if(secondOperand == '/') initialResult = secondNumber / thirdNumber;
			
		}
		
		else if (indexSecond < indexFirst) {
			if(firstOperand == '+') initialResult = firstNumber + secondNumber;
			if(firstOperand == '-') initialResult = firstNumber - secondNumber;
			if(firstOperand == '*') initialResult = firstNumber * secondNumber;
			if(firstOperand == '/') initialResult = firstNumber / secondNumber;
		}
		else {
			
			if(firstOperand == '+') totalResult = firstNumber + secondNumber + thirdNumber;
			if(firstOperand == '-') totalResult = firstNumber - secondNumber - thirdNumber;
			if(firstOperand == '*') totalResult = firstNumber * secondNumber * thirdNumber;
			if(firstOperand == '/') totalResult = firstNumber / secondNumber / thirdNumber;
		}
		
		
		
		if(indexFirst < indexSecond) {
			if(firstOperand == '+')  totalResult = firstNumber + initialResult;
			if(firstOperand == '-')  totalResult = firstNumber - initialResult;
			if(firstOperand == '*')  totalResult = firstNumber * initialResult;
			if(firstOperand == '/')  totalResult = firstNumber / initialResult;
			
			
		}
		
		else if (indexSecond < indexFirst) {
			if(secondOperand == '+')  totalResult = initialResult + thirdNumber;
			if(secondOperand == '-')  totalResult = initialResult - thirdNumber;
			if(secondOperand == '*')  totalResult = initialResult * thirdNumber;
			if(secondOperand == '/')  totalResult = initialResult / thirdNumber;
		}
		
		
		System.out.println("Initial Result: " + initialResult);
		System.out.println("Total Result: " + totalResult);
		
		
		double roundedResult = Math.round(totalResult);
		return roundedResult;
		
	}
	
	public String generateQuestion() {
		String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
		String[] operands = {"+", "-", "/", "*"};
		int randomIndexFirst = random.nextInt(numbers.length);
		int randomIndexSecond = random.nextInt(numbers.length);
		int randomIndexOperand = random.nextInt(operands.length);	
		String question = numbers[randomIndexFirst] + operands[randomIndexOperand] + numbers[randomIndexSecond];
		
		return question;
	}

	public String generateQuestionAverage() {
		String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
		String[] operands = {"+", "-", "/", "*"};
		int randomIndexFirst = random.nextInt(numbers.length);
		int randomIndexSecond = random.nextInt(numbers.length);
		int randomIndexThird = random.nextInt(numbers.length);
		int randomIndexOperand = random.nextInt(operands.length);	
		int randomIndexOperand2 = random.nextInt(operands.length);	
		String question = numbers[randomIndexFirst] + operands[randomIndexOperand] + numbers[randomIndexSecond] + operands[randomIndexOperand2] + numbers[randomIndexThird];
		return question;
	}
	
	public String generateQuestionDifficult() {
		String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
		String[] operands = {"+", "-", "/", "*"};
		int randomIndexFirst = random.nextInt(numbers.length);
		int randomIndexSecond = random.nextInt(numbers.length);
		int randomIndexThird = random.nextInt(numbers.length);
		int randomIndexFourth = random.nextInt(numbers.length);
		int randomIndexOperand = random.nextInt(operands.length);	
		int randomIndexOperand2 = random.nextInt(operands.length);	
		int randomIndexOperand3 = random.nextInt(operands.length);
		String question = numbers[randomIndexFirst] + operands[randomIndexOperand] + numbers[randomIndexSecond] + operands[randomIndexOperand2] + numbers[randomIndexThird] + operands[randomIndexOperand3] + numbers[randomIndexFourth];
		return question;
	}

public Main() throws ScriptException {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Downloads\\quiz.png"));
		setTitle("QUIZ GAME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(10, 0, 564, 550);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1_2_4 = new JLabel("quiz");
		lblNewLabel_1_2_4.setForeground(Color.WHITE);
		lblNewLabel_1_2_4.setFont(new Font("Magneto", Font.BOLD, 110));
		lblNewLabel_1_2_4.setBounds(140, 130, 561, 120);
		panel.add(lblNewLabel_1_2_4);
		
		lblNewLabel_1_2 = new JLabel("MATH");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Magneto", Font.BOLD, 99));
		lblNewLabel_1_2.setBounds(70, 50, 561, 120);
		panel.add(lblNewLabel_1_2);
		
		lblNewLabel_1 = new JLabel("MATH");
		lblNewLabel_1.setFont(new Font("Magneto", Font.BOLD, 99));
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(78, 50, 777, 120);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_1_1 = new JLabel("MATH");
		lblNewLabel_1_1.setForeground(new Color(204, 51, 0));
		lblNewLabel_1_1.setFont(new Font("Magneto", Font.BOLD, 99));
		lblNewLabel_1_1.setBounds(89, 50, 612, 120);
		panel.add(lblNewLabel_1_1);
		
		lblNewLabel_1_2_2 = new JLabel("quiz");
		lblNewLabel_1_2_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_2_2.setFont(new Font("Magneto", Font.BOLD, 110));
		lblNewLabel_1_2_2.setBounds(148, 130, 561, 120);
		panel.add(lblNewLabel_1_2_2);
		
		lblNewLabel_1_2_1 = new JLabel("quiz");
		lblNewLabel_1_2_1.setForeground(new Color(204, 51, 0));
		lblNewLabel_1_2_1.setFont(new Font("Magneto", Font.BOLD, 110));
		lblNewLabel_1_2_1.setBounds(159, 130, 561, 120);
		panel.add(lblNewLabel_1_2_1);
		
		lblNewLabel_1_2_3 = new JLabel("quiz");
		lblNewLabel_1_2_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_2_3.setFont(new Font("Magneto", Font.BOLD, 110));
		lblNewLabel_1_2_3.setBounds(148, 130, 561, 120);
		panel.add(lblNewLabel_1_2_3);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 9));
		lblNewLabel.setBounds(225, 428, 161, 14);
		panel.add(lblNewLabel);
		
		rdbtnEasy = new JRadioButton("EASY");
		rdbtnEasy.setForeground(Color.WHITE);
		rdbtnEasy.setBackground(Color.RED);
		rdbtnEasy.setFont(new Font("Tahoma", Font.BOLD, 30));
		rdbtnEasy.setBounds(215, 232, 269, 78);
		panel.add(rdbtnEasy);
		
		rdbtnAverage = new JRadioButton("AVERAGE");
		rdbtnAverage.setForeground(Color.WHITE);
		rdbtnAverage.setFont(new Font("Tahoma", Font.BOLD, 30));
		rdbtnAverage.setBackground(Color.RED);
		rdbtnAverage.setBounds(188, 290, 269, 73);
		panel.add(rdbtnAverage);
		
		rdbtnDifficult = new JRadioButton("DIFFICULT");
		rdbtnDifficult.setForeground(Color.WHITE);
		rdbtnDifficult.setFont(new Font("Tahoma", Font.BOLD, 30));
		rdbtnDifficult.setBackground(Color.RED);
		rdbtnDifficult.setBounds(176, 342, 269, 68);
		panel.add(rdbtnDifficult);
		
		ButtonGroup difficulty = new ButtonGroup();
		difficulty.add(rdbtnEasy);
		difficulty.add(rdbtnAverage);
		difficulty.add(rdbtnDifficult);
		
		btnStart = new JButton("START");
		
		
	
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if(rdbtnEasy.isSelected()){
				///////////
				
 				lblNewLabel_3.setText(generateQuestion());
 				
 				
 				
				lblNewLabel_3.setVisible(true);
				lblNewLabel.setVisible(false);
				rdbtnEasy.setVisible(false);
				rdbtnAverage.setVisible(false);
				rdbtnDifficult.setVisible(false);
				lblNewLabel_1_2_3.setVisible(false);
				lblNewLabel_1_2_1.setVisible(false);
				lblNewLabel_1_2_2.setVisible(false);
				lblNewLabel_1_1.setVisible(false);
				lblNewLabel_1.setVisible(false);
				lblNewLabel_1_2.setVisible(false);
				lblNewLabel_1_2_4.setVisible(false);
				btnStart.setVisible(false);
				lblNewLabel_2.setVisible(true);
				textField.setVisible(true);
				lblNewLabel_4.setVisible(true);
				btnNewButton_1.setVisible(true);
				
				
			}else{
				lblNewLabel.setText("SELECT DIFFICULTY");
				
			}
			
			if(rdbtnAverage.isSelected()){
				
				lblNewLabel_3.setText(generateQuestionAverage());
 				
				lblNewLabel_3.setVisible(true);
				lblNewLabel.setVisible(false);
				rdbtnEasy.setVisible(false);
				rdbtnAverage.setVisible(false);
				rdbtnDifficult.setVisible(false);
				lblNewLabel_1_2_3.setVisible(false);
				lblNewLabel_1_2_1.setVisible(false);
				lblNewLabel_1_2_2.setVisible(false);
				lblNewLabel_1_1.setVisible(false);
				lblNewLabel_1.setVisible(false);
				lblNewLabel_1_2.setVisible(false);
				lblNewLabel_1_2_4.setVisible(false);
				btnStart.setVisible(false);
				lblNewLabel_2.setVisible(true);
				textField.setVisible(true);
				lblNewLabel_4.setVisible(true);
				btnNewButton_2.setVisible(true);
			}else{
				lblNewLabel.setText("SELECT DIFFICULTY");
				
			}
			
			if(rdbtnDifficult.isSelected()){
				
				lblNewLabel_3.setText(generateQuestionDifficult());
				lblNewLabel_3.setVisible(true);
				lblNewLabel.setVisible(false);
				rdbtnEasy.setVisible(false);
				rdbtnAverage.setVisible(false);
				rdbtnDifficult.setVisible(false);
				lblNewLabel_1_2_3.setVisible(false);
				lblNewLabel_1_2_1.setVisible(false);
				lblNewLabel_1_2_2.setVisible(false);
				lblNewLabel_1_1.setVisible(false);
				lblNewLabel_1.setVisible(false);
				lblNewLabel_1_2.setVisible(false);
				lblNewLabel_1_2_4.setVisible(false);
				btnStart.setVisible(false);
				lblNewLabel_2.setVisible(true);
				textField.setVisible(true);
				lblNewLabel_4.setVisible(true);
				btnNewButton_3.setVisible(true);
				
			}else{
				lblNewLabel.setText("SELECT DIFFICULTY");
				
			}
			
			}
		});
		btnStart.setBackground(Color.WHITE);
		btnStart.setForeground(Color.RED);
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnStart.setBounds(212, 453, 125, 43);
		panel.add(btnStart);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVisible(false);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 80));
		lblNewLabel_2.setBounds(317, 90, 125, 129);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setVisible(false);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 80));
		lblNewLabel_3.setBounds(215, 90, 300, 200);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		lblNewLabel_4.setVisible(false);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 80));
		lblNewLabel_4.setBounds(121, 90, 103, 129);
		panel.add(lblNewLabel_4);
				
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField.setVisible(false);
		textField.setBounds(121, 261, 324, 49);
		panel.add(textField);
		textField.setColumns(10);
		
		textField1 = new JTextField();
		textField1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField1.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField1.setVisible(false);
		textField1.setBounds(121, 261, 324, 49);
		panel.add(textField1);
		textField1.setColumns(10);
		
		returnButton = new JButton("Return");
		returnButton.setVisible(false);
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		returnButton.setForeground(Color.RED);
		returnButton.setBackground(Color.WHITE);
		returnButton.setBounds(225, 363, 126, 43);
		panel.add(returnButton);
		
		
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(true);
				rdbtnEasy.setVisible(true);
				rdbtnAverage.setVisible(true);
				rdbtnDifficult.setVisible(true);
				lblNewLabel_1_2_3.setVisible(true);
				lblNewLabel_1_2_1.setVisible(true);
				lblNewLabel_1_2_2.setVisible(true);
				lblNewLabel_1_1.setVisible(true);
				lblNewLabel_1.setVisible(true);
				lblNewLabel_1_2.setVisible(true);
				lblNewLabel_1_2_4.setVisible(true);
				btnStart.setVisible(true);
				returnButton.setVisible(false);
				lblNewLabel_3.setVisible(false);
				lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 80));
			}

		
			
			
		});
		
		btnNewButton_1 = new JButton("SUBMIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
				double result = getResult(lblNewLabel_3.getText());
				Double userInput = Double.parseDouble(textField.getText());
				
				if(currentQuestionNumber == 5) {
					lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 30));
					if(result == userInput) {
						playerScore++;
						
						lblNewLabel_3.setText("Score: " + playerScore + "/5");
					}
					btnNewButton_2.setVisible(false);
					returnButton.setVisible(true);
					lblNewLabel_3.setText("Score: " + playerScore + "/5");
					textField.setVisible(false);
					
				}
				
				else if(result == userInput) {
					lblNewLabel_3.setText(generateQuestion());
					currentQuestionNumber++;
					playerScore++;
					
				}
				else {
					lblNewLabel_3.setText(generateQuestion());
					currentQuestionNumber++;
				}
				
				
				System.out.println("Player Score: " + playerScore);
				
				
			}
		});
		btnNewButton_1.setVisible(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(225, 363, 126, 43);
		panel.add(btnNewButton_1);
		
		//Button 2
		btnNewButton_2 = new JButton("SUBMIT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double result = getResultAverage(lblNewLabel_3.getText());
				Double userInput = Double.parseDouble(textField.getText());
			
				if(currentQuestionNumber == 5) {
					lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 30));
					if(result == userInput) {
						playerScore++;
						
						lblNewLabel_3.setText("Score: " + playerScore + "/5");
					}
					btnNewButton_2.setVisible(false);
					returnButton.setVisible(true);
					lblNewLabel_3.setText("Score: " + playerScore + "/5");
					textField.setVisible(false);
					
				}
				
				else if(result == userInput) {
					lblNewLabel_3.setText(generateQuestionAverage());
					currentQuestionNumber++;
					playerScore++;
					
				}
				else {
					lblNewLabel_3.setText(generateQuestionAverage());
					currentQuestionNumber++;
				}
				
				
				System.out.println("Player Score: " + playerScore);
				
			}
		});
		btnNewButton_2.setVisible(false);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(225, 363, 126, 43);
		panel.add(btnNewButton_2);
		
		
		textField2 = new JTextField();
		textField2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField2.setFont(new Font("Tahoma", Font.BOLD, 40));
		textField2.setVisible(false);
		textField2.setBounds(121, 261, 324, 49);
		panel.add(textField2);
		textField2.setColumns(10);
		
		btnNewButton_3 = new JButton("SUBMIT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double result = getResultDifficult(lblNewLabel_3.getText());
				Double userInput = Double.parseDouble(textField.getText());
			
				if(currentQuestionNumber == 5) {
					lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 30));
					if(result == userInput) {
						playerScore++;
						
						lblNewLabel_3.setText("Score: " + playerScore + "/5");
					}
					btnNewButton_2.setVisible(false);
					returnButton.setVisible(true);
					lblNewLabel_3.setText("Score: " + playerScore + "/5");
					textField.setVisible(false);
					
				}
				
				else if(result == userInput) {
					lblNewLabel_3.setText(generateQuestionAverage());
					currentQuestionNumber++;
					playerScore++;
					
				}
				else {
					lblNewLabel_3.setText(generateQuestionAverage());
					currentQuestionNumber++;
				}
				
				
				System.out.println("Player Score: " + playerScore);
				
				
			}
		});
		btnNewButton_3.setVisible(false);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(225, 363, 126, 43);
		panel.add(btnNewButton_3);
		
		
	}
}


