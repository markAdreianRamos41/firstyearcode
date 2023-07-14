import java.awt.Color;
import java.awt.Font;
import javax.swing.*;


public class Main extends JFrame{
	
	JLabel songListLabel = new JLabel("SONG LIST");
	
	JTable shoeListTable;
	JScrollPane scrollPane;
	
	
	//Column data for the table
	String[] column = {"Track No.", "Song Title", "Artist Name", "Date Released", "Album name"};


	//Collection of shoes with relevant information 
	String[][] data = {
			{"1", "Rock Your Body", "Justin Timberlake", "2002", "Justified"},
			{"2", "Pa'lla Voy", "Marc Anthony", "2022", "N/A"},
			{"3", "The Nights", "Avicii", "2014", "The Days / Nights EP"},
			{"4", "Roses", "OutKast", "2003", "Speakerboxxx/The Love Below"},
			{"5", "Boogie Wonderland", "Earth, Wind & Fire", "1979",  "N/A"},
			{"6", "Hallelujah", "Pentatonix", "2016", "N/A"},
			{"7", "Rock and Roll All Nite", "Kiss", "1975", "N/A"},
			{"8", "Bad Romance", "Lady Gaga", "2009", "N/A"},
			{"9", "First of the Year", "Skrillex", "2011", "N/A"},
			{"10", "I Write Sins Not Tragedies", "Panic! At The Disco", "2005", "N/A"},
			{"11", "Unspeakable", "Ace of Base", "2002", "N/A"},
			{"12", "Feed Your Head", "Paul Kalkbrenner ", "2015", "N/A"},
			{"13", "Brown Baby", "Billy Paul", "1972", "N/A"},
			{"14", "The Real Slim Shady", "Eminem", "2000", "N/A"},
			{"15", "Life Of The Party", "Kanye West", "2021", "N/A"},
			
	};	
	
	Main(){
		
		//Inserting label for different components
		//Shoes List
		songListLabel.setBounds(28, 36, 200, 26);
		songListLabel.setFont(new Font("Inter", Font.BOLD, 30));

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
		add(songListLabel);
		
		add(scrollPane);
		
		setVisible(true);
		
	}
	

	public static void main(String[] args) {
		new Main();
	}

}
