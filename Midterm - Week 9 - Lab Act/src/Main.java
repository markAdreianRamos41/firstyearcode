import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Main {
	JFrame frame;
	JLabel header;
	ImageIcon[] icons = new ImageIcon[3]; //Creating multiple instance of images
	JLabel[] buttons = new JLabel[3]; 	  //Creating a placeholder for the images
	JLabel currentSelection;
	
	public Main() {
		int buttonXPosition = 60;
		
		
		String[] btnLabel = {"Image//bato.jpg", "Image//gunting.jpg", "Image//papel.jpg"}; // storing paths for the images
		
		
		frame = new JFrame("My Game");
		header = new JLabel("Midterm - Week 9 - Lab Act");
		header.setFont(new Font("Acumin Variable Concept", Font.BOLD, 15));
		header.setBounds(180, 5, 200, 100);
		
		//Creating image icon and inserting it in their corresponding JLabel
		for(int index = 0; index < buttons.length; index++) {
			icons[index] = new ImageIcon(btnLabel[index]);
	
			buttons[index] = new JLabel(icons[index]);
			
			//Setting up position for the image
			buttons[index].setBounds(buttonXPosition, 300, 150, 150);
			buttonXPosition += 160;
		}
		
		//Create a JLabel which will display the label for the clicked image 
		currentSelection = new JLabel("Click an Image");
		currentSelection.setFont(new Font("Acumin Variable Concept", Font.BOLD, 31));
		currentSelection.setBounds(150, 50, 300, 300);
		
		// Adding components to the screen
		frame.add(header);
		frame.add(buttons[0]);
		frame.add(buttons[1]);
		frame.add(buttons[2]);
		frame.add(currentSelection);
		
		frame.setSize(600,600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//MouseListener for 1st image
		buttons[0].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				currentSelection.setText("STONE Selected");
			}
		});
		
		//MouseListener for 2nd image
		buttons[1].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				currentSelection.setText("SCISSORS Selected");
			}
		});
		
		//MouseListener for 3rd image
		buttons[2].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				currentSelection.setText("PAPER Selected");
			}
		});
		
	}

	public static void main(String[] args) {
		new Main();

	}

}
