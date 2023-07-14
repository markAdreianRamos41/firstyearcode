import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

public class Main extends JFrame{
	
	//Component declaration
	JMenuBar menu;
	JMenu option1;
	JMenu option2;
	JMenuItem item1;
	JMenu subMenu;
	JMenuItem subItem1;
	JMenuItem subItem2;
	JMenuItem item3;
	JMenuItem item4;
	JSeparator separator;
	

	JMenuItem option2Item1;
	JMenuItem option2Item2;

	

	public Main() {
		// initialization
		menu = new JMenuBar();
		setJMenuBar(menu);
		
		// JMenu
		//serves as 2 menus in menu bar
		JMenu option1 = new JMenu("Option1");
		JMenu option2 = new JMenu("Option2");
		
		//Menu items in the option1
		item1 = new JMenuItem("Item1");
		//another submenu in the option 1
		subMenu = new JMenu("SubMenu");
		//subMenu items
		subItem1 = new JMenuItem("SubItem1");
		subItem2 = new JMenuItem("SubItem2");
		
		//Separator
		separator = new JSeparator();
		
		//Rest of the Item in the option 1
		item3 = new JMenuItem("Item3");
		item4 = new JMenuItem("Item4");
		
		
		//Adding menuItems to their corresponding menu
		subMenu.add(subItem1);
		subMenu.add(subItem2);	
		option1.add(item1);
		option1.add(subMenu);
		option1.add(separator);
		option1.add(item3);
		option1.add(item4);
		
		
		//Adding menuItems in the option 2
		option2Item1 = new JMenuItem("OP2 Item 1");
		option2Item2 = new JMenuItem("OP2 Item 2");
		
		
		//Adding items to the option 2
		option2.add(option2Item1);
		option2.add(option2Item2);
		
		
		menu.add(option1);
		menu.add(option2);



		

		// Basic setup for JFrame
		setTitle("Finals - Week 15 - Lab Activity (Mark Adreian Ramos)");
		setSize(500, 250);
		setLocation(350, 200);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//storing all menu items into single array
		JMenuItem[] menuBarItems = {item1, item3, item4, subItem1, subItem2, option2Item1, option2Item2};
		
		//from the array above I'm using a loop above to add action listener
		for(int i = 0; i < menuBarItems.length; i++) {
			final int index = i;
			menuBarItems[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//Display a prompt whenever a item is clicked
					JOptionPane.showMessageDialog(null, "You selected " + menuBarItems[index].getText());
					
				}
				
			});
		}

	}

	

	


	public static void main(String[] args) {
		new Main();

	}

}