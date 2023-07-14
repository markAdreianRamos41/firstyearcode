import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;
	JComboBox<String> comboBox = new JComboBox<String>();
	JLabel label = new JLabel("Dog Breeds: ");
	JButton button = new JButton("Select Dog");
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Finals Activity #1 (Mark Adreian K. Ramos)");
		setContentPane(contentPane);
		
		setLayout(null);
		comboBox.setBounds(150, 100, 200, 30);
		comboBox.addItem("Select a dog breed");
		comboBox.addItem("Golden Retrievers");
		comboBox.addItem("German Shepherd");
		comboBox.addItem("Poodles");
		comboBox.addItem("Bulldogs");
		comboBox.addItem("Rottweilers");
		comboBox.addItem("Beagles");
		comboBox.addItem("Dachshunds");
		comboBox.addItem("German Shorthaired Pointers");
		comboBox.addItem("American Foxhound");
		comboBox.addItem("Alaskan Malamute");
		comboBox.addItem("Afghan Hound");
		
		label.setBounds(50, 100, 200, 30);
		button.setBounds(50, 150, 300, 30);
		add(comboBox);
		add(label);
		add(button);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String selectedBreed = String.valueOf(comboBox.getSelectedItem());
				int indexSelected = comboBox.getSelectedIndex();
				
				if(indexSelected == 0) 
					JOptionPane.showMessageDialog(null, "Select a breed from the combo box",  "No breed selected", JOptionPane.WARNING_MESSAGE);
				else 
					JOptionPane.showMessageDialog(null,String.valueOf("Selected Breed: " + selectedBreed),  "Selected Breed", JOptionPane.PLAIN_MESSAGE);
			}
			
		});
	}

}
