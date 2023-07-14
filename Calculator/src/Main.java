import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
	
	private int FRAME_WIDTH = 488;
	private int FRAME_HEIGHT = 780;
	

	private JPanel contentPane;
	private JPanel outerTopContainer;
	private JPanel outerBottomContainer;
	
	//This class will serves as parent container for all the top elements
	InnerTopContainer innerTopContainer = new InnerTopContainer();
	
	//This class will serves as parent container for all the bottom elements
	InnerBottomContainer innerBottomContainer = new InnerBottomContainer();

	
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
	
	
	public Main() {
		//Basic setup of JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FRAME_WIDTH , FRAME_HEIGHT);
		setLocationRelativeTo(null);
		setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		
		
		//This will serves as container for the top section of the GUI
		int OUTER_TOP_CONTAINER_HEIGHT = 322;
		outerTopContainer = new JPanel();
		outerTopContainer.setBounds(0, 0, FRAME_WIDTH, OUTER_TOP_CONTAINER_HEIGHT);
		outerTopContainer.setBackground(Color.WHITE);
		outerTopContainer.setLayout(null);
		outerTopContainer.add(innerTopContainer);
		
		
		//This will serves as container for the bottom section of the GUI
		int OUTER_BOTTOM_CONTAINER_HEIGHT =  457;
		outerBottomContainer = new JPanel();
		outerBottomContainer.setBounds(0, OUTER_TOP_CONTAINER_HEIGHT, FRAME_WIDTH, OUTER_BOTTOM_CONTAINER_HEIGHT);
		outerBottomContainer.setBackground(new Color(0x251e1d));
		outerBottomContainer.setLayout(null);
		outerBottomContainer.add(innerBottomContainer);
		
		contentPane.add(outerTopContainer);
		contentPane.add(outerBottomContainer);
		
		setResizable(false);
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
	}

}
