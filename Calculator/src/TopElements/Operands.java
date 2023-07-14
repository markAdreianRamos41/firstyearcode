package TopElements;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class Operands extends JPanel{
	
	
	//This class will serves as container for textField for the firstNumber and secondNumber 
	//that is to be calculated later on
	
	private static JTextField firstOperand;
	private static JTextField secondOperand;
	
	public Operands() {
	
		
		setBounds(0, 261 - 113, 425, 113);
		setLayout(null);
		setBackground(Color.blue);
		
		
		
		firstOperand = new JTextField();
		firstOperand.setBounds(0, 44, 425, 69);
		firstOperand.setFont(new Font("Acumin Variable Concept", Font.PLAIN, 69));
		firstOperand.setForeground(new Color(0x251e1d));
		firstOperand.setEditable(false);
		firstOperand.setHorizontalAlignment(SwingConstants.RIGHT);
		firstOperand.setBackground(Color.WHITE);
		firstOperand.setBorder(null);
		
		
		secondOperand = new JTextField("");
		secondOperand.setBounds(0, 0, 425, 44);
		secondOperand.setFont(new Font("Acumin Variable Concept", Font.BOLD, 31));
		secondOperand.setForeground(new Color(0xe04d29));
		secondOperand.setHorizontalAlignment(SwingConstants.RIGHT);
		secondOperand.setEditable(false);
		secondOperand.setBackground(Color.WHITE);
		secondOperand.setBorder(null);
		
		add(firstOperand);
		add(secondOperand);
		
	}
	
	
	//getters for the component for us to be able to access it on another class 
	public static JTextField getFirstOperand() {
		return firstOperand;
	}
	
	public static JTextField getSecondOperand() {
		return secondOperand;
	}

}
