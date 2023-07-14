import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;
	private JPanel elementsContainer;
	private JLabel artistDisplay;
	private JLabel artistIndexDisplay;
	private JLabel selectArtist;
	private JComboBox<String> artistList;
	private JButton selectButton;
	private JButton removeButton;
	private JLabel addArtist;
	private JTextField addArtistTextField;
	private JButton addButton;
	private JButton removeAllButton;
	private String[] artistBank = new String[0];
	
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
		setSize(600, 600);
		setTitle("Advanced GUI Controls 1 - Exercise (MARK ADREIAN RAMOS 1CS-B)");
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0xD03D0F));
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		
		
		//Display Labels
		artistDisplay = new JLabel("Artist", SwingConstants.CENTER);
		artistDisplay.setFont(new Font("Overpass", Font.BOLD, 36));
		artistDisplay.setForeground(Color.white);
		artistDisplay.setBounds(0, 70, 600, 40);
		
		artistIndexDisplay = new JLabel("Index", SwingConstants.CENTER);
		artistIndexDisplay.setFont(new Font("Overpass", Font.BOLD, 24));
		artistIndexDisplay.setForeground(Color.white);
		artistIndexDisplay.setBounds(0, 50, 398, 20);
		
		
		
			
		//Artist List
		selectArtist = new JLabel("Pick an Artist", SwingConstants.CENTER);
		selectArtist.setFont(new Font("Overpass", Font.PLAIN, 15));
		selectArtist.setForeground(Color.white);
		selectArtist.setBounds(0, 135, 398, 40);
		
		artistList = new JComboBox<String>();
		artistList.setBounds(0, 174, 398, 35);
		artistList.setSelectedIndex(-1);
		
		selectButton = new JButton("SELECT");
		selectButton.setBackground(new Color(0x25C30B));
		selectButton.setForeground(new Color(0xFFFFFF));
		selectButton.setBorder(null);
		selectButton.setBounds(0, 217, 195, 35);
		
		removeButton = new JButton("REMOVE");
		removeButton.setBackground(new Color(0x830D0D));
		removeButton.setForeground(new Color(0xFFFFFF));
		removeButton.setBorder(null);
		removeButton.setBounds(203, 217, 195, 35);
		
		
		
		//Adding artist
		addArtist = new JLabel("Add New Artist", SwingConstants.CENTER);
		addArtist.setFont(new Font("Overpass", Font.PLAIN, 15));
		addArtist.setForeground(Color.white);
		addArtist.setBounds(0, 255, 398, 40);
		
		addArtistTextField = new JTextField();
		addArtistTextField.setBounds(0, 294, 398, 40);
		
		addButton = new JButton("ADD");
		addButton.setBackground(new Color(0x25C30B));
		addButton.setForeground(new Color(0xFFFFFF));
		addButton.setBorder(null);
		addButton.setBounds(0, 342, 398, 35);
		
		removeAllButton = new JButton("REMOVE ALL ARTIST");
		removeAllButton.setBackground(new Color(0x830D0D));
		removeAllButton.setForeground(new Color(0xFFFFFF));
		removeAllButton.setBorder(null);
		removeAllButton.setBounds(0, 380, 398, 35);
		
		

		
		elementsContainer = new JPanel();
		elementsContainer.setLayout(null);
		elementsContainer.setOpaque(false);
		elementsContainer.setBounds(101, 70, 398, 415);
		
		
		
		
		//Label display
		elementsContainer.add(artistIndexDisplay);
		
		//Artist Lists
		elementsContainer.add(selectArtist);
		elementsContainer.add(artistList);
		elementsContainer.add(selectButton);
		elementsContainer.add(removeButton);
		
		//Add artist
		elementsContainer.add(addArtist);
		elementsContainer.add(addArtistTextField);
		elementsContainer.add(addButton);
		elementsContainer.add(removeAllButton);
		
		contentPane.add(artistDisplay);
		contentPane.add(elementsContainer);
		setContentPane(contentPane);
		
		
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entry = addArtistTextField.getText();
				addArtist(entry);
				addArtistTextField.setText("");
	
			}
			
		});
		
		removeAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearArtistData();
			}
			
		});
		
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displaySelectedArtist();
			}
			
		});
		
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeSelectedItem();
			}
			
		});
	}
	
	
	public void addArtist(String entry) {
	
		if(artistBank.length == 0) {
			artistBank = new String[1];
			artistBank[0] = entry;
			artistList.addItem(artistBank[0]);
			
		} else {
			
			String[] newArtistBank = new String[artistBank.length + 1];
			
			//Copying all the previous elements of bank of artist
			for(int i = 0; i < artistBank.length; i++) 
				newArtistBank[i] = artistBank[i];
			
			//Inserting the new artist to the updated list 
			newArtistBank[newArtistBank.length - 1] = entry;
			
			//updating the bank of artist value
			artistBank = newArtistBank;
			
			//insert the new items to the combobox
			artistList.addItem(entry);
		}
		
	}
	
	public void clearArtistData() {
		artistList.removeAllItems();
	}
	
	public void displaySelectedArtist() {
		int selectedDataIndex = artistList.getSelectedIndex();
		String selectedData = String.valueOf(artistList.getSelectedItem());
		artistDisplay.setText(selectedData);
		artistIndexDisplay.setText(selectedData + " index is " + selectedDataIndex);
	}
	
	public void removeSelectedItem() {
		int indexSelected = artistList.getSelectedIndex();
		String[] newArtistBank = new String[artistBank.length - 1];
		int newArtistBankIndex = 0;
		

	
		//remove the selected artist
		for(int currentIndex = 0; currentIndex < artistBank.length; currentIndex++) {
			if(indexSelected != currentIndex) {
				newArtistBank[newArtistBankIndex] = artistBank[currentIndex];
				newArtistBankIndex++;
			}
		}
		
		
		//update the value of the bank of artist
		artistBank = newArtistBank;
		//Clear the combobox
		artistList.removeAllItems();
		
		//Then insert the updated bank into the combo box
		for(int i = 0; i < artistBank.length; i++) {
			artistList.addItem(artistBank[i]);
		}
	}
	
	
}
