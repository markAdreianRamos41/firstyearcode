import java.awt.Color;
import TopElements.Header;
import javax.swing.JPanel; 
import TopElements.Operands;


public class InnerTopContainer extends JPanel {
	
	public Header header = new Header();
	public Operands firstOperand = new Operands();
	
	
	
	public InnerTopContainer() {
		setBounds(25, 30, 425, 261);
		setBackground(Color.WHITE);
		setLayout(null);
//		setOpaque(false);
		header.setBounds(0, 0, 425, 30);
		add(header);
		add(firstOperand);
		
		
	}

}
