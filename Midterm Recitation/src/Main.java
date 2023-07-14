import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Main extends JFrame {

	private JPanel contentPane;
	ImageIcon background = new ImageIcon("Assets\\background.png");
	JLabel backgroundContainer = new JLabel(background);
	JPanel mainContainer = new JPanel();
	
	Font mainFont = new Font("Jugger Rock", Font.PLAIN, 17);
	
	JPanel selectFlavorContainer = new JPanel();
	JLabel selectFlavorLabel = new JLabel("SELECT FLAVOR");
	JPanel selectFlavorRadioContainer = new JPanel();
	JRadioButton rdoHawaiian = new JRadioButton("Hawaiian");
	JRadioButton rdoHamAndCheese = new JRadioButton("Ham and Cheese");
	JRadioButton rdoPepperoni = new JRadioButton("Pepperoni");
	ButtonGroup selectFlavor = new ButtonGroup();
	
	JPanel selectSizeContainer = new JPanel();
	JLabel selectSizeLabel = new JLabel("SELECT SIZE");
	JPanel selectSizeRadioContainer = new JPanel();
	JLabel smallPrizeLabel = new JLabel("90.00");
	JLabel mediumPrizeLabel = new JLabel("110.00");
	JLabel largePrizeLabel = new JLabel("130.00");
	JRadioButton rdoSmall = new JRadioButton("SMALL-SIZED");
	JRadioButton rdoMedium = new JRadioButton("MEDIUM-SIZED");
	JRadioButton rdoLarge = new JRadioButton("LARGE-SIZED");
	ButtonGroup selectSize = new ButtonGroup();
	
	
	JPanel selectAddOnsContainer = new JPanel();
	JLabel selectAddOnsLabel = new JLabel("SELECT ADD ONS");
	JPanel selectAddOnsRadioContainer = new JPanel();
	JCheckBox rdoPepper = new JCheckBox("Pepper");
	JCheckBox rdoOnions = new JCheckBox("Onions");
	JCheckBox rdoBlackOlives = new JCheckBox("Black Olives");
	JCheckBox rdoGreenPeppers = new JCheckBox("Green Peppers");
	JCheckBox rdoExtraCheese = new JCheckBox("Extra Cheese");

	
	JButton createOrderBtn = new JButton("CREATE ORDER");
	
	JPanel orderSummaryLabelContainer = new JPanel();
	JLabel orderSummaryLabel = new JLabel("ORDER SUMMARY");
	JTextArea orderSummaryTextArea = new JTextArea(10, 4);

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
		//FLAVOR Section
		selectFlavorLabel.setBounds(10, 8, 150, 20);
		applyStylesLabel(selectFlavorLabel); //Method for applying styles in the label of the menu
		selectFlavorContainer.setBounds(0, 0, 275, 40);
		applyStylesContainer(selectFlavorContainer); //Method for applying styles in the JPanel of the menu
		selectFlavorContainer.add(selectFlavorLabel);	
		//Setting bounds for the radio button of the menu
		rdoHawaiian.setBounds(10, 10, 200, 20);
		rdoHawaiian.setSelected(true); //Setting hawaiian as the default selected
		rdoHamAndCheese.setBounds(10, 30, 200, 20);
		rdoPepperoni.setBounds(10, 50, 200, 20);
		applyStylesRadio(rdoHawaiian); //Applying styles to the JRadioButton
		applyStylesRadio(rdoHamAndCheese); //Applying styles to the JRadioButton
		applyStylesRadio(rdoPepperoni); //Applying styles to the JRadioButton
		//Adding all the JRadio Button to a ButtonGroup
		selectFlavor.add(rdoHawaiian);
		selectFlavor.add(rdoHamAndCheese);
		selectFlavor.add(rdoPepperoni);		
		//Setting bounds to the JPanel of the JRadioButtons
		selectFlavorRadioContainer.setBounds(0, 48, 275, 85);
		selectFlavorRadioContainer.add(rdoHawaiian); //Adding JRadioButtons
		selectFlavorRadioContainer.add(rdoHamAndCheese); //Adding JRadioButtons
		selectFlavorRadioContainer.add(rdoPepperoni); //Adding JRadioButtons
		applyStylesContainer(selectFlavorRadioContainer); //method for applying styles to the JPanel of JRadioButtons
		
		
		//SIZE Section 
		//Same idea on the above section
		selectSizeLabel.setBounds(10, 8, 150, 20);
		applyStylesLabel(selectSizeLabel);
		selectSizeContainer.setBounds(0, 167, 275, 40);
		applyStylesContainer(selectSizeContainer);
		selectSizeContainer.add(selectSizeLabel);		
		rdoSmall.setBounds(10, 10, 200, 20);
		rdoSmall.setSelected(true);
		rdoMedium.setBounds(10, 30, 200, 20);
		rdoLarge.setBounds(10, 50, 200, 20);
		applyStylesRadio(rdoSmall);
		applyStylesRadio(rdoMedium);
		applyStylesRadio(rdoLarge);
		selectSize.add(rdoSmall);
		selectSize.add(rdoMedium);
		selectSize.add(rdoLarge);
		//Only DIFFERENCE
		//Label for size prices depending on the flavor selected
		smallPrizeLabel.setBounds(222, 15, 100, 16);
		smallPrizeLabel.setForeground(Color.white);
		mediumPrizeLabel.setBounds(222, 35, 100, 16);
		mediumPrizeLabel.setForeground(Color.white);
		largePrizeLabel.setBounds(222, 55, 100, 16);
		largePrizeLabel.setForeground(Color.white);	
		selectSizeRadioContainer.setBounds(0, 212, 275, 85);
		selectSizeRadioContainer.add(rdoSmall);
		selectSizeRadioContainer.add(rdoMedium);
		selectSizeRadioContainer.add(rdoLarge);	
		selectSizeRadioContainer.add(smallPrizeLabel);
		selectSizeRadioContainer.add(mediumPrizeLabel);
		selectSizeRadioContainer.add(largePrizeLabel);		
		applyStylesContainer(selectSizeRadioContainer);
		
		
		//ADD-ONS
		//Same idea on Flavor Section
		selectAddOnsLabel.setBounds(10, 8, 150, 20);
		applyStylesLabel(selectAddOnsLabel);
		selectAddOnsContainer.setBounds(0, 327, 275, 40);
		applyStylesContainer(selectAddOnsContainer);
		selectAddOnsContainer.add(selectAddOnsLabel);	
		rdoPepper.setBounds(10, 10, 200, 20);
		rdoOnions.setBounds(10, 30, 200, 20);
		rdoBlackOlives.setBounds(10, 50, 200, 20);
		rdoGreenPeppers.setBounds(10, 70, 200, 20);
		rdoExtraCheese.setBounds(10, 90, 200, 20);	
		applyStylesCheckBox(rdoPepper);
		applyStylesCheckBox(rdoOnions);
		applyStylesCheckBox(rdoBlackOlives);
		applyStylesCheckBox(rdoGreenPeppers);
		applyStylesCheckBox(rdoExtraCheese);	
		selectAddOnsRadioContainer.setBounds(0, 373, 275, 125);
		selectAddOnsRadioContainer.add(rdoPepper);
		selectAddOnsRadioContainer.add(rdoOnions);
		selectAddOnsRadioContainer.add(rdoBlackOlives);
		selectAddOnsRadioContainer.add(rdoGreenPeppers);
		selectAddOnsRadioContainer.add(rdoExtraCheese);
		applyStylesContainer(selectAddOnsRadioContainer);
	
		//Button for creating order based from the RadioButton selected
		createOrderBtn.setBounds(0, 510, 278, 52);
		createOrderBtn.setBackground(new Color(0xed2024));
		createOrderBtn.setForeground(Color.white);
		
		//Order summary section
		orderSummaryLabelContainer.setBounds(300, 0, 275, 40);
		orderSummaryLabelContainer.setBackground(Color.white);
		orderSummaryLabelContainer.setLayout(null);
		orderSummaryLabelContainer.setBorder(BorderFactory.createLineBorder(new Color(0x251d1c), 7));
		orderSummaryLabel.setBounds(10, 8, 150, 20);
		orderSummaryLabel.setFont(mainFont);
		orderSummaryLabel.setForeground(new Color(0xe24d2a));
		orderSummaryLabelContainer.add(orderSummaryLabel);
		
		orderSummaryTextArea.setBounds(300, 51, 275, 510);
		orderSummaryTextArea.setFont(new Font("Overpass", Font.BOLD, 15));
		orderSummaryTextArea.setBorder(BorderFactory.createLineBorder(new Color(0x251d1c), 7));
		
		//DANGERZONE
		//Container for all sections of radioButtons and order summary
		mainContainer.setBounds(70, 120, 643, 583);
		mainContainer.setBackground(Color.black);
		mainContainer.setOpaque(false);
		mainContainer.setLayout(null);
		mainContainer.add(selectFlavorContainer);
		mainContainer.add(selectFlavorRadioContainer);
		mainContainer.add(selectSizeContainer);
		mainContainer.add(selectSizeRadioContainer);	
		mainContainer.add(selectAddOnsContainer);
		mainContainer.add(selectAddOnsRadioContainer);
		mainContainer.add(createOrderBtn);
		mainContainer.add(orderSummaryTextArea);
		mainContainer.add(orderSummaryLabelContainer);
	
		//Background image
		backgroundContainer.setBounds(0, -30, 718, 768);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(718, 768);
		setLayout(null);
		setTitle("Pizzamiatics (Midterm Recitation)");
		setLocationRelativeTo(null);
		setBackground(Color.WHITE);
		
		//Adding background image and the main container to the frame
		add(mainContainer);
		add(backgroundContainer);
		
		
        //database like
		//data of the prices of the sizes given in the activity 
		String[][] data = {
				//HAWAIIAN Price
				{
					"90.00",  //small
					"110.00", //medium
					"130.00"  //Large
				},
				
				//HAM AND CHEESE Price
				{
					"110.00", //small
					"130.00", //medium
					"150.00", //Large
				},
				//PEPPERONI Price
				{
					"130.00", //small
					"150.00", //medium
					"170.00", //Large
				}
				
		};
		
		//Prices on add ons
		double[] addOnsPrices = {

				5.00,  //PEPPER
				10.00, //ONIONS
				15.00, //BLACK OLIVES
				20.00, //GREEN PEPPERS
				25.00  //EXTRA CHEESE

		}; 
		
		//Storing RadioButtons in a array so I can manipulate there behaviour using for loop
		//The order of radio button is same as the order of prices in data
		JRadioButton[] flavorButtons = {rdoHawaiian, rdoHamAndCheese, rdoPepperoni};
		JRadioButton[] sizeButtons = {rdoSmall, rdoMedium, rdoLarge};

		//label on the prices also in order in the data
		JLabel[] sizePriceLabel = {smallPrizeLabel, mediumPrizeLabel, largePrizeLabel}; 

		//Order of the checkbox in add ons is same on the prices in the addOnsPrices
		JCheckBox[] addOnsButton = {rdoPepper, rdoOnions, rdoBlackOlives, rdoGreenPeppers, rdoExtraCheese};
		
		
		//Adding action listener for every flavor buttons
		for(int flavorButtonIndex = 0; flavorButtonIndex < flavorButtons.length; flavorButtonIndex++) {

			//Creating a constant so i can access it inside the Actionlistener 
			final int currentIndex =  flavorButtonIndex;

			//adding action listener
			flavorButtons[flavorButtonIndex].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					//for every label in sizePriceLabel
					//set the displayed price from the data at index of clicked flavor button
					for(int priceLabelIndex = 0; priceLabelIndex < sizePriceLabel.length; priceLabelIndex++) {
						sizePriceLabel[priceLabelIndex].setText(data[currentIndex ][priceLabelIndex]);
					}
					
				}
				
			});
		}
		
		createOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String flavor = "";
				double priceSize = 0;
				String sizeDescription = "";
				double addOnsTotal = 0;
				String addOnsList = "";
				

				
				for(int i = 0; i < 3; i++) {
					//Getting the flavor
					if(flavorButtons[i].isSelected()) flavor = flavorButtons[i].getText();
					//Size description and the amount of the selected size
					if(sizeButtons[i].isSelected()) {
						//Converting string value to double
						priceSize = Double.parseDouble(sizePriceLabel[i].getText());
						sizeDescription = sizeButtons[i].getText();
					}
				}
				
				//Getting the list of selected add ons a nd total value
				for(int i = 0; i < addOnsButton.length; i++) {
					if(addOnsButton[i].isSelected()) {
						addOnsTotal += addOnsPrices[i];
						addOnsList += "\n            " + addOnsButton[i].getText();
					}
				}
				
				//Calculating the total amount of the order
				double totalPrice = addOnsTotal + priceSize;
				String summary = "PIZZA FLAVOR : " + flavor.toUpperCase()
							   + "\n\nPIZZA SIZE : " + sizeDescription.toUpperCase() 
							   + "\n\nADD ONS : " + addOnsList
							   + "\n\n\nTOTAL PRICE : " + totalPrice + " pesos";

				//Displaying the summary of the order to the text area
				orderSummaryTextArea.setText(summary);
				
			}
			
		});
		
	
	}
	

	//Methods for applying repeatitive styles
	public void applyStylesContainer(JPanel panel) {
		panel.setLayout(null);
		panel.setBackground(new Color(0xe24d2a));
		panel.setBorder(BorderFactory.createLineBorder(new Color(0x251d1c), 7));
	}
	
	public void applyStylesLabel(JLabel label) {
		label.setFont(mainFont);
		label.setForeground(Color.white);
	}
	
	public void applyStylesRadio(JRadioButton radio) {
		radio.setFont(mainFont);
		radio.setForeground(Color.white);
		radio.setBackground(new Color(0xe24d2a));
	}
	
	public void applyStylesCheckBox(JCheckBox check) {
		check.setFont(mainFont);
		check.setForeground(Color.white);
		check.setBackground(new Color(0xe24d2a));
	}

}
