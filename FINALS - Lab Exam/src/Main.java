import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class Main extends JFrame{

		//Component declaration
		JMenuBar menuBar;
		JMenu option1;
		boolean hasAlreadyPutData = false;
		JMenuItem item1 = new JMenuItem("Item1");
		JMenuItem item2 = new JMenuItem("Item2");



		//Table model for different data
		DefaultTableModel model = new DefaultTableModel(); //model for students inforamtions
		DefaultTableModel model2 = new DefaultTableModel(); //Model for patients information
		JLabel Label = new JLabel("NO DATA");
		
		JTable tableComponent;
		JScrollPane scrollPane;
		
		
		//Column data for the table for students
		String[] studentsColumn = {"Student No.", "Firstname", "Middle Name", "Lastname"};


		//Collection of students with relevant information 
		String[][] studentsData = {
				{"1234", "Mark Adreian ", "K", "Ramos"},
				{"2242", "Tristan Jake", "M", "Dingle"},
				{"3234", "Holly Zephyr Fawn", "G", "Apordo"},
				{"4523", "Daryle Jae", "N", "Lopez"},
				{"5324", "Aaron Xavier", "D", "Castro"},
				{"6234", "Jerick Ashle", "F", "Ramilo"},

				
		};	
		
		
		//Column data for the table for patients
		String[] patientsColumn = {"Fullname", "Phone Number", "Gender", "Birthday"};


		//Collection of patients information 
		String[][] patientsData = {
				{"Mark Adreian Ramos", "092163726372", "M", "04/01/03"},
				{"Tristan Jake Dingle","09217465987", "M", "05/02/03"},
				{"Holly Zephyr Fawn Apordo", "09217536452", "M", "06/03/03"},
				{"Daryle Jae Lopez", "09217364957", "M", "07/04/03"},
				{"Aaron Xavier Castro","09216453764", "M", "08/05/03"},
				{"Jerick Ashle Ramilo","09217633876", "M", "09/06/03"},

				
		};	
	
	
		Main(){
			// initialization
			//Menu bar setup
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
		
			JMenu option1 = new JMenu("Option1");


			//Adding menu items to menu
			option1.add(item1);
			option1.add(item2); 

			menuBar.add(option1);
			
			
			//Inserting label for different components
			//Student List
			Label.setBounds(28, 36, 200, 26);
			Label.setFont(new Font("Inter", Font.BOLD, 30));

			//JTable to display data
			tableComponent = new JTable(model); //setting default table to student
			
			//Table Styling
			tableComponent.setFont(new Font("Inter", Font.PLAIN, 15));
			tableComponent.setBackground(new Color(0x4F4F4F));
			tableComponent.setForeground(Color.white);
			tableComponent.setRowHeight(30);

			//JScrollpane serves as container for the JTable (shoeListTable)
			scrollPane = new JScrollPane();
			scrollPane.setBounds(28, 75, 544, 200);
			scrollPane.setViewportView(tableComponent);
			
			
			//JFrame basic setup
			setTitle("Finals - Week 15 - Lab Activity (Mark Adreian Ramos)");
			setSize(620, 500);
			setLocation(350, 200);
			setLayout(null);
			
			add(Label);
			add(scrollPane);
			
			
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//Displaying first set of data
			item1.addActionListener(new ActionListener() {

				
				public void actionPerformed(ActionEvent e) {
					Label.setText("STUDENTS");
					model = new DefaultTableModel();
					tableComponent.setModel(model);
					if(hasAlreadyPutData) {
						clearTableData(model2);
						setTableColumn(studentsColumn, model);
						setTableRows(studentsData, model);
					}
					else {
						
						setTableColumn(studentsColumn, model);
						setTableRows(studentsData, model);
						hasAlreadyPutData = false;
					}
					

				}
				
			});
			
			//Displaying 2nd set of data
			item2.addActionListener(new ActionListener() {

				
				public void actionPerformed(ActionEvent e) {
					clearTableData(model);
					Label.setText("PATIENTS");
					
					model2 = new DefaultTableModel();
					tableComponent.setModel(model2);
					
					setTableColumn(patientsColumn, model2);
					setTableRows(patientsData, model2);
					
					
				}
				
			});
		}
	
		public static void main(String[] args) {
			new Main();
		}
		
		//setting column data of the table
		public void setTableColumn(String[] data, DefaultTableModel model) {
			for(int i = 0; i < data.length; i++) {
				model.addColumn(data[i]);
			}
		}
		
		//setting row data of the table
		public void setTableRows(String[][] data, DefaultTableModel model) {
			for(int i = 0; i < data.length; i++) {
				model.addRow(data[i]);
			}
		}
		
		//Removing or clearing data of the table
		public void clearTableData(DefaultTableModel model) {
			Label.setText("NO DATA");
			int rowCount = model.getRowCount();
			int columnCount = tableComponent.getColumnCount();
			
		
			
			while (rowCount != 0) {
				model.removeRow(0);
				rowCount--;
			}
			
			while (columnCount != 0) {
				System.out.println(true);
				TableColumn tcol = tableComponent.getColumnModel().getColumn(0);
				
				tableComponent.removeColumn(tcol);
				tableComponent.revalidate();
				columnCount--;
			}	
		}
}
