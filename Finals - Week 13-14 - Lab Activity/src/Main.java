import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;


public class Main extends JFrame{
	
	JLabel shoeListLabel = new JLabel("SHOES LIST");
	JLabel shoeMetricsLabel = new JLabel("SHOES SIZE METRIC");
	JLabel shoeSizesLabel = new JLabel("SHOES SIZE LIST");
	JLabel shoeVariantsLabel = new JLabel("SHOES VARIANTS");
	
	JComboBox<Object> metricsChoices;
	JComboBox<Object> shoeSizesList;
	JList<Object> variants;
	
	JTable shoeListTable;
	JScrollPane scrollPane;
	
	
	//Column data for the table
	String[] column = {"ID", "Product Name", "Price ($)", "Quantity"};


	//Collection of shoes with relevant information 
	String[][] data = {
			{"1", "Wild Rider Layers Unisex Sneakers", "100", "4"},
			{"2", "Mercedes Kart Cat-X Tech Unisex Sneakers", "120", "4"},
			{"3", "Jako Slip-On Men's Shoes", "170", "4"},
			{"4", "PUMA Serve Pro Lite Unisex shoes", "160", "4"},
			{"5", "Electron E Unisex Shoes", "130", "4"},
			{"6", "one8 Virat Kohli Basket Classice Unisex Sneakers", "120", "4"},
			{"7", "Caracal SoftFoam+Sneakers", "100", "4"},
			{"8", "Mirage Mox Brightly Packed Shoes", "130", "4"},
			{"9", "Future Rider Play On Unisex Sneakers", "200", "4"},
			{"10", "Anzarun Lite Unisex Sneakers", "140", "4"},
			{"11", "Pacer Next Cage Shoes", "200", "4"},
			{"12", "Rebound Lay-Up Lo SoftFoam+Mesh Shoes", "200", "4"},
			{"13", "one8 Virat Kohli Basket Classic Unisex Sneakers", "140", "4"},
			{"14", "PUMA x 1DER Columbus Men's Shoes", "130", "4"},
			{"15", "BMW M Motorsport City Rider Sneakers", "170", "4"},
			{"16", "Jamming FUSEFIT Evolution Shoes", "130", "4"},
			{"17", "Puma Perforated Low Men's Shoes", "140", "4"},
			{"18", "RS-X TOYS Unisex Sneakers", "170", "4"},
			{"19", "X-RAY² Ramble Unisex Shoes", "140", "4"},
			{"20", "RS-X³ Twill Air Mesh Shoes", "170", "4"},
			{"21", "Sl 20.2 Shoes", "200", "4"},
			{"22", "ZX 2K Boost 2.0 Trail Shoes", "140", "4"},
			{"23", "PREDATOR FREAK .3 FG J", "150", "4"},
			{"24", "Defiant Generation multicourt tennis shoes", "150", "4"},
			{"25", "Air Jordan XXXVI Low", "130", "4"},
			{"26", "Air Jordan XXXVI Tatum", "130", "4"},
			{"27", "Air Jordan XXXVI 'Taco Jay'", "150", "4"},
			{"28", "Air Jordan 7 Retro", "150", "4"},
			{"29", "Air Jordan 1 Utility", "200", "4"},
			{"30", "Air Jordan 6 Retro", "130", "4"},
			
			
	};
	//Shoes size metric list
	String[] shoeMetrics = {"US", "UK", "EU", "CM", "IN"};
	
	//Shoes size list based on corresponding metric system
	Double[][] shoeSizes = {
			//US
			{4.0, 4.5, 5.0, 5.5, 6.0, 6.5, 7.0, 7.5, 8.0, 8.5, 9.0, 9.5, 10.0, 10.5, 11.0, 11.5, 12.0, 13.0, 14.0, 15.0},
			//UK
			{3.0, 3.5, 4.0, 4.5, 5.0, 5.5, 6.0, 6.5, 7.0, 7.5, 8.0, 8.5, 9.0, 9.5, 10.0, 10.5, 11.0, 12.0, 13.0, 14.0, 15.0},
			//EU
			{37.0, 38.0, 39.0, 40.0, 41.0, 42.0, 43.0, 44.0, 45.0, 46.0, 47.0, 48.0, 49.0, 50.0},
			//CM
			{22.0, 23.0, 24.0, 25.0, 26.0, 27.0, 28.0, 29.0, 30.0, 31.0},
			//IN
			{9.0, 10.0, 11.0, 12.0},
	};
	
	//Collection of variants for the shoes
	String[] variantChoices = {"Candy Red", "Navy Blue", "Cyan", "Army Green"};
 	
	
	Main(){
		
		//Inserting label for different components
		//Shoes List
		shoeListLabel.setBounds(28, 36, 200, 26);
		shoeListLabel.setFont(new Font("Inter", Font.BOLD, 30));

		//Shoes Size Metric
		shoeMetricsLabel.setBounds(28, 359, 200, 15);
		shoeMetricsLabel.setFont(new Font("Inter", Font.BOLD, 15));
		
		//Shoes Size List
		shoeSizesLabel.setBounds(307, 359, 200, 15);
		shoeSizesLabel.setFont(new Font("Inter", Font.BOLD, 15));
		 
		//Shoes variants
		shoeVariantsLabel.setBounds(28, 430, 200, 15);
		shoeVariantsLabel.setFont(new Font("Inter", Font.BOLD, 15));
		
		//Components [JComboBox, JTable, JList]
		//JComboBox for different metrics
		metricsChoices = new JComboBox<Object>(shoeMetrics);
		metricsChoices.setBackground(new Color(0x4F4F4F));
		metricsChoices.setForeground(Color.white);
		metricsChoices.setBounds(28, 382, 265, 37);
		
		//JComboBox for shoes size depending on the selected metric
		shoeSizesList = new JComboBox<Object>(shoeSizes[0]);
		shoeSizesList.setBackground(new Color(0x4F4F4F));
		shoeSizesList.setForeground(Color.white);
		shoeSizesList.setBounds(307, 382, 265, 37);

		//JList for variants
		variants = new JList<Object>(variantChoices);
		variants.setBackground(new Color(0x4F4F4F));
		variants.setForeground(Color.white);
		variants.setBounds(28, 453, 544, 80);
		
		//JTable to display data
		shoeListTable = new JTable(data, column);
		shoeListTable.setFont(new Font("Inter", Font.PLAIN, 15));
		shoeListTable.setBackground(new Color(0x4F4F4F));
		shoeListTable.setForeground(Color.white);
		shoeListTable.setRowHeight(30);

		//JScrollpane serves as container for the JTable (shoeListTable)
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 75, 544, 264);
		scrollPane.setViewportView(shoeListTable);
		
		
		
		//Basic setup of JFrame
		setSize(600, 600);
		setTitle("Finals - Week 13-14 - Lab Activity (MARK ADREIAN RAMOS)");
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		//Adding components
		add(shoeSizesLabel);
		add(shoeMetricsLabel);
		add(shoeListLabel);
		add(shoeVariantsLabel);
		
		add(metricsChoices);
		add(shoeSizesList);
		add(variants);
		
		add(scrollPane);
		
		setVisible(true);
		

		//Itemlistener to update shoes size list when the selected metric is changed
		metricsChoices.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//Identifying the index of the selected metric
				int selectedMetric = metricsChoices.getSelectedIndex(); 

				//Clearing all items of the Shoes Size List
				shoeSizesList.removeAllItems();
				
				//Then adding item again to the shoesSizeList with 
				//the corresponding list of sizes based on the selected metric
				for(int i = 0; i < shoeSizes[selectedMetric].length; i++) {
					shoeSizesList.addItem(shoeSizes[selectedMetric][i]);
				}
				
				
				
			}
			
		});
	}
	

	public static void main(String[] args) {
		new Main();
	}

}
