import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel; 
import BottomElements.CustomButton;

public class InnerBottomContainer extends JPanel{
	
	public InnerBottomContainer() {
		setBackground(Color.WHITE);
		setBounds(25, 27, 426, 370);
		setBackground(new Color(0x251e1d));
		setLayout(new GridLayout(5, 4, 3, 3));

		
		String[][] buttonsData = {
				{"operation" , "C"},
				{"operation" , "%"},
				{"operation" , "DEL"},
				{"operation" , "÷"},
				{"number" , "1"},
				{"number" , "2"},
				{"number" , "3"},
				{"operation" , "x"},
				{"number" , "4"},
				{"number" , "5"},
				{"number" , "6"},
				{"operation" , "—"},
				{"number" , "7"},
				{"number" , "8"},
				{"number" , "9"},
				{"operation" , "+"},
				{"number" , "00"},
				{"number" , "0"},
				{"number" , "."},
				{"operation" , "="},
				
		};
		
		for(int buttonIndex = 0; buttonIndex < buttonsData.length; buttonIndex++) {
				String buttonGroup = buttonsData[buttonIndex][0];
				String buttonLabel = buttonsData[buttonIndex][1];
				add(new CustomButton(buttonGroup, buttonLabel));
			
		}
	}	
		

}

