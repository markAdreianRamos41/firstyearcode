package BottomElements;
import TopElements.Operands;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JTextField;

public class CustomButton extends JButton{
	
	JTextField firstOperand = Operands.getFirstOperand();
	JTextField secondOperand = Operands.getSecondOperand();

	public CustomButton(String buttonGroup, String buttonLabel) {
		
		//Custom styling for the buttons according to their button group.
		if(buttonGroup.equals("operation")) {
			setBackground(new Color(0xe04d29));
			setForeground(Color.WHITE);
		}	
		
		else {
			
			setBackground(Color.WHITE);
			setForeground(new Color(0x251e1d));
		}	
		setFont(new Font("Acumin Variable Concept", Font.BOLD, 20));
		setText(buttonLabel);
		setBorder(null);	
		
		// for every instance of this button it will have the following action listener
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buttonGroup.equals("number")) {

					if (buttonLabel.equals(".")) insertDecimal();
					else insertNumber(buttonLabel);

				}
			
				if(buttonGroup.equals("operation")) {
					if(buttonLabel.equals("DEL")) deleteNumber();
					else if(buttonLabel.equals("C")) clear();
					else if(buttonLabel.equals("%")) setPercentage();
					else if(buttonLabel.equals("—")) setMinusSign();
					else if(!buttonLabel.equals("=")) setSecondOperand(buttonLabel);
					else {
						if(firstOperand.getText().contains("%")) {
							 getPercentageResult();
						}else {
							getResult();
						}
						
					}
					
				}
				
				
			}
		});
	}	 
	
	//Handles the insertion of number in when number button is clicked
	public void insertNumber(String label) {
		String operandText = firstOperand.getText();
		String currentFirstOperandText = firstOperand.getText();
		String updatedText = currentFirstOperandText + label;
		

		
		
		if((operandText.equals("0") || operandText.equals("")) && (label.equals("00") || label.equals("0"))) return;
			
	
		else {
			firstOperand.setText(updatedText);
		}
		
		if(firstOperand.getText().split("").length >= 12) {
			firstOperand.setFont(new Font("Acumin Variable Concept", Font.PLAIN, 30));
		}else {
			firstOperand.setFont(new Font("Acumin Variable Concept", Font.PLAIN, 69));
		}
		
		
	}
	
	//Handles the insertion of decimal places to the calculator GUI
	public void insertDecimal() {
		String operandText = firstOperand.getText();
		int operandLength = firstOperand.getText().split("").length;
		System.out.println(operandLength);
		
		if(operandText.contains(".")) return;
		else if(operandText.equals("")) firstOperand.setText("0.");
		else firstOperand.setText(operandText + ".");
	}
	
	//Delete a single char from the input
	public void deleteNumber() {
		char[] currentFirstOperandText = firstOperand.getText().toCharArray();
		String udatedInput = "";
		
		for(int charIndex = 0; charIndex < currentFirstOperandText.length - 1; charIndex++) {
			udatedInput += String.valueOf(currentFirstOperandText[charIndex]);
		}
		firstOperand.setText(udatedInput);
	}
	
	//Clear all inputs in the GUI
	public void clear() {
		firstOperand.setText("");
		secondOperand.setText("");
	}
	
	//Method for handling inputs and Display in GUI for using % button
	public void setPercentage() {
		String operandText = firstOperand.getText();
		
		if(operandText.equals("")) return;
		else if(operandText.contains("%")) return;
		else firstOperand.setText(operandText  + "%");
	}
	
	//Method for handling minus sign and negative signs
	public void setMinusSign() {
		String operandText = firstOperand.getText();
		String secondOperandText = secondOperand.getText();
		
		if(operandText.equals("")) firstOperand.setText("-");
		else if (!secondOperandText.equals("") && operandText.equals("")) return;
		else if (!secondOperandText.equals("") && !operandText.equals("")) displayResultUsingOperators("-");
		else {
			secondOperand.setText("- " + firstOperand.getText());
			firstOperand.setText("");
		}
	}

	//Setting the GUI display when clicking arithmetic operation
	public void setSecondOperand(String buttonLabel) {
		String operandText = firstOperand.getText();
		String secondOperandText = secondOperand.getText();
		
		if(operandText.equals("")) return;
		else if (!secondOperandText.equals("") && operandText.equals("")) return;
		else if (!secondOperandText.equals("") && !operandText.equals("")) {
			//by clicking arithmetic operation generate results and display it as a new first number input
			displayResultUsingOperators(buttonLabel);
		}
		else {
			secondOperand.setText(buttonLabel + " " + firstOperand.getText());
			firstOperand.setText("");
		}
	}

	//Getting results from arithmetic operations
	public void getResult() {
		String[] second = secondOperand.getText().split(" ");
		double firstNumber = Double.parseDouble(second[1]);
		double secondNumber = Double.parseDouble(firstOperand.getText());
		
		
			switch(second[0]) {
				case "+" :
					displayResult(firstNumber + secondNumber);
					break;
				case "-":
					
					displayResult(firstNumber - secondNumber);
					break;
				case "x":
					displayResult(firstNumber * secondNumber);
					break;
				case "÷":
					displayResult(firstNumber / secondNumber);
					break;
				
			}
		
	}
	
	
	//Displaying result to the GUI
	public void displayResult(double result) {
		
		if(String.valueOf(result).split("").length >= 12) {
			firstOperand.setFont(new Font("Acumin Variable Concept", Font.PLAIN, 30));
		}else {
			firstOperand.setFont(new Font("Acumin Variable Concept", Font.PLAIN, 69));
		}
		
		firstOperand.setText(String.valueOf(result));
		secondOperand.setText("");
		
		
	}
	
	
	//Getting result for using % button
	public void getPercentageResult() {
		String[] operands = firstOperand.getText().split("%");
		System.out.println(Arrays.toString(operands));
		
		if(operands.length == 1) {
			double operand = Double.parseDouble(String.valueOf(operands[0]));
			displayResult(operand / 100);
		}
		else {
			double first = Double.parseDouble(String.valueOf(operands[0]));
			double second = Double.parseDouble(String.valueOf(operands[1]));
			
			displayResult((first / 100) * second);
		}
	}

	
	//Method for allowing the user to continuously get result when clicking arithmetic buttons (+, - , x , /)
	public void displayResultUsingOperators(String buttonLabel) {
		String[] second = secondOperand.getText().split(" ");
		double firstNumber = Double.parseDouble(second[1]);
		double secondNumber = Double.parseDouble(firstOperand.getText());
		
		
			switch(second[0]) {
				case "+" :
					secondOperand.setText(buttonLabel + " " + String.valueOf(firstNumber + secondNumber));
					firstOperand.setText("");
					break;
				case "-":
					
					secondOperand.setText(buttonLabel + " " + String.valueOf(firstNumber - secondNumber));
					firstOperand.setText("");
					break;
				case "x":
					secondOperand.setText(buttonLabel + " " + String.valueOf(firstNumber * secondNumber));
					firstOperand.setText("");
					break;
				case "÷":
					secondOperand.setText(buttonLabel + " " + String.valueOf(firstNumber / secondNumber));
					firstOperand.setText("");
					break;
				
			}
	}

}
