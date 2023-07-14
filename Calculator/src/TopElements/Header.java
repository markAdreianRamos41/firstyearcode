package TopElements;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JPanel{
	
//	This class will contain all the header elements of the calculator
	
	ImageIcon closeButtonImage;
	JLabel headerTitle;
	
	public Header() {
		
		
		headerTitle = new JLabel("ARITHMETIC CALCULATOR");
		headerTitle.setFont(new Font("Evogria", Font.PLAIN, 25));
		headerTitle.setForeground(new Color(0xe04d29));
		headerTitle.setBounds(0, -40, 300, 100);
		headerTitle.setBackground(Color.black);
		
		setBackground(Color.WHITE);
		setLayout(null);
		add(headerTitle);
		
	}
}
