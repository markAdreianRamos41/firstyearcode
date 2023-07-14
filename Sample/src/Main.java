
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class finalexam {
	
	//DECLARATION 
	
	JFrame frame;
	JMenuBar menubar;
	JMenuItem NEW;
	JMenuItem EXIT_1;
	JMenuItem Class1;
	JMenuItem Class2;
	JMenu FILE;
	JMenu STUDENT_PROFILE;
	JSeparator SEPERATOR_1;
	JSeparator SEPERATOR_2;
	JMenuItem EXIT_2;
	DefaultTableModel TableModel;
	JTable Table;
	JLabel Label;
	JScrollPane scrollPane;
	
	
	private void displayClass1Information() {
		TableModel.setRowCount(0);
		TableModel.setColumnIdentifiers(new String[]{"Name", "Sex", "Age"});
		String[] names = {"DIEGO", "ANA", "SALBE"};
		String[] sex = {"M", "F", "M"};
		String[] age = {"18", "19", "21"};
		for (int i = 0; i < names.length; i++) {
		String name = names[i];
		String sexs = sex[i];
		String ages = age[i];
		TableModel.addRow(new String[]{name, sexs, ages});
		}
		}
	
	private void displayClass2Information() {
		TableModel.setRowCount(0);
		TableModel.setColumnIdentifiers(new String[]{"Name", "Sex", "Age"});
		String[] names = {"JUAN", "MARIA", "PEDRO"};
		String[] sex = {"M", "F", "M"};
		String[] age = {"18", "18", "21"};
		for (int i = 0; i < names.length; i++) {
		String name = names[i];
		String sexs = sex[i];
		String ages = age[i];
		TableModel.addRow(new String[]{name, sexs, ages});
		}
	}
	
	public finalexam() {
		
		// INITIALIZATION
			
			
			
		frame = new JFrame("FINAL EXAM");
		menubar = new JMenuBar();
		FILE = new JMenu("FILE");
		NEW = new JMenuItem("NEW");
	    STUDENT_PROFILE = new JMenu("STUDENT PROFILE");
		SEPERATOR_1 = new JSeparator();
		EXIT_1 = new JMenuItem("EXIT");
		Class1 = new JMenuItem("CLASS1");
		Class2 = new JMenuItem("CLASS2");
		
		TableModel = new DefaultTableModel();
		Table = new JTable(TableModel);
		
		SEPERATOR_2 = new JSeparator();
		EXIT_2 = new JMenuItem("EXIT");
		Label = new JLabel();
	
		scrollPane = new JScrollPane();
		
		//ADDING ITEM AND SEPERAOTR FOR FILE
		FILE.add(NEW);
		FILE.add(STUDENT_PROFILE);
		FILE.add(SEPERATOR_1);
		FILE.add(EXIT_1);
	
		//ADDING ITEM AND SEPERATOR FOR RECENT FILE
		STUDENT_PROFILE.add(Class1);
		STUDENT_PROFILE.add(Class2);
		STUDENT_PROFILE.add(SEPERATOR_2);
		STUDENT_PROFILE.add(EXIT_2);
	
		// JMenu
		menubar.add(FILE);
	
		// Adding the components of menu bar
		frame.setJMenuBar(menubar);
		Label = new JLabel();
		scrollPane.setBounds(28, 75, 544, 200);
		scrollPane.setViewportView(Table);
	
		// layout of frame
	
		frame.setBounds(100, 100, 759, 451);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		// LISTENER FOR JMENUITEM OF FILE
		frame.add(scrollPane);
	
		//CLASS_1 Menu Item
		Class1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayClass1Information();
				Label.setText("CLASS 1");
			}
		});
	
		//CLASS_2 Menu Item
		Class2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayClass2Information();
				Label.setText("CLASS 2");
			}
		});
		
		EXIT_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "AYAW MO NA?", "SIGURADO KABA?",JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "BAKIT KA BABALIK");
					System.exit(0);
				}
			}
		});
					
		// LISTENER FOR JMENU OF STUDENT PROFILE
					
		EXIT_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "AYAW MO NA?", "DI NGA?", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "GINAGAWA MO DITO");
					System.exit(0);
				}
			}
		});
	}
		
	public static void main(String[] args) {
		new finalexam();
		}
	}