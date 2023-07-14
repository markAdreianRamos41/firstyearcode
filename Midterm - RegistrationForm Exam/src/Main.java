import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main extends JFrame{

    JLabel title = new JLabel("HOTEL REGISTRATION FORM");
    ImageIcon backgroundImage = new ImageIcon("image\\background.png");
    JPanel formContainer = new JPanel();
    JLabel imageContainer = new JLabel(backgroundImage);
    
    Color mainColor = new Color(0x3c68b1);
    Font textFieldLabelFont = new Font("Montserat", Font.ITALIC, 36);
    
    JTextField firstNameTextField = new JTextField();
    JLabel firstNameLabel = new JLabel("Firstname");
    JTextField lastNameTextField = new JTextField();
    JLabel lastNameLabel = new JLabel("Lastname");
    
    JTextField emailTextField = new JTextField();
    JLabel emailLabel = new JLabel("Email");
    JTextField phoneNumberTextField = new JTextField();
    JLabel phoneNumberLabel = new JLabel("Phone Number");
    
    JTextField arrivalDateTextField = new JTextField();
    JLabel arrivalDateLabel = new JLabel("Arival Date (mm/dd/yy)");
    JTextField arrivalTimeTextField = new JTextField();
    JLabel arrivalTimeLabel = new JLabel("Time (Hour Minutes ex. 10:00)");  
    ButtonGroup arrivalButtonGroup = new ButtonGroup();
    JRadioButton arrivalMorning = new JRadioButton("AM");
    JRadioButton arrivalEvening = new JRadioButton("PM");
    
    
    JTextField departureDateTextField = new JTextField();
    JLabel departureDateLabel = new JLabel("Departure Date (mm/dd/yy)");
    JTextField departureTimeTextField = new JTextField();
    JLabel departureTimeLabel = new JLabel("Time (Hour Minutes ex. 10:00)");    
    ButtonGroup departureButtonGroup = new ButtonGroup();
    JRadioButton departureMorning = new JRadioButton("AM");
    JRadioButton departureEvening = new JRadioButton("PM");
    
    JTextField flightNumberTextField = new JTextField();
    JLabel flightNumberLabel = new JLabel("Flight Number");
    JTextField numberOfGuestTextField = new JTextField();
    JLabel numberOfGuestLabel = new JLabel("Number of guest");
    
    
    JLabel roomTypeLabel = new JLabel("Room Type:");
    JTextArea specialRequestTextField = new JTextArea();
    JLabel specialRequestLabel = new JLabel("Special Request");
    
    JButton submitButton = new JButton("Make reservation");
    JCheckBox[] choicesCheckBox;
    Main(){
        
        //First name text field with label
        firstNameTextField.setBounds(0, 102, 283, 25);
        firstNameLabel.setBounds(0, 75, 68, 14);
        applyStyle(firstNameTextField);
        
        
        //Last name text field with label
        lastNameTextField.setBounds(316 , 102, 283, 25);
        lastNameLabel.setBounds(316 , 75, 68, 14);
        applyStyle(lastNameTextField);
        
        //Email name text field with label
        emailTextField.setBounds(0, 163, 283, 25);
        emailLabel.setBounds(0, 138, 68, 14);
        applyStyle(emailTextField);
                
                
        //Last name text field with label
        phoneNumberTextField.setBounds(316 , 163, 283, 25);
        phoneNumberLabel.setBounds(316 , 138, 100, 14);
        applyStyle(phoneNumberTextField);
        
        
        //Arrival date name text field with label
        arrivalDateTextField.setBounds(0, 229, 283, 25);
        arrivalDateLabel.setBounds(0, 205, 200, 14);
        applyStyle(arrivalDateTextField);
                        
                        
        //Arrival time text field with label
        arrivalTimeTextField.setBounds(316 , 229, 212, 25);
        arrivalTimeLabel.setBounds(316 , 205, 200, 14);
        applyStyle(arrivalTimeTextField);
        
        //Radio buttons for morning and evening on user arrival date
        arrivalMorning.setBounds(560, 210, 50, 20);
        arrivalEvening.setBounds(560,  237, 50, 20);
        arrivalButtonGroup.add(arrivalMorning);
        arrivalButtonGroup.add(arrivalEvening);
        
        applyRadioButtonStyle(arrivalMorning);
        applyRadioButtonStyle(arrivalEvening);
        
        

        //Departure date name text field with label
        departureDateTextField.setBounds(0, 283, 283, 25);
        departureDateLabel.setBounds(0, 259 , 200, 14);
        applyStyle(departureDateTextField);
                        
                        
        //Departure  time text field with label
        departureTimeTextField.setBounds(316 , 283, 212, 25);
        departureTimeLabel.setBounds(316 , 259, 200, 14);
        applyStyle(departureTimeTextField);
        
        //Radio buttons for morning and evening on user Departure  date
        departureMorning.setBounds(560, 263 , 50, 20);
        departureEvening.setBounds(560,  291, 50, 20);
        departureButtonGroup.add(departureMorning);
        departureButtonGroup.add(departureEvening);
        
        applyRadioButtonStyle(departureMorning);
        applyRadioButtonStyle(departureEvening);
        
        

        //Flight number text field with label
        flightNumberTextField.setBounds(0, 342, 283, 25);
        flightNumberLabel.setBounds(0, 315 , 150, 14);
        applyStyle(flightNumberTextField);
                                    
        //Number of guest name text field with label
        numberOfGuestTextField.setBounds(316 , 342, 283, 25);
        numberOfGuestLabel.setBounds(316 , 315, 100, 14);
        applyStyle(numberOfGuestTextField);
        
        
        //Room type number text field with label
        String[] choices = {
                
                "Standard Room (1 to 2 Person)",
                "Family Room (1 to 4 Person)",
                "Delux Room (1 to 10 Person)",
                "Suite (1 to 4 Person)",
                
        };
        int position = 402;
        //creating instance of JCheckBox from the choices above
        choicesCheckBox = new JCheckBox[choices.length];
        for(int choiceIndex = 0; choiceIndex < choices.length; choiceIndex++) {
            choicesCheckBox[choiceIndex] = new JCheckBox(choices[choiceIndex]);
            
            //styling each instance of JCheckBox
            choicesCheckBox[choiceIndex].setBackground(new Color(0xFFFFFF));
            choicesCheckBox[choiceIndex].setBounds(0, position, 200 ,18);
            
            //setting dynamic position based from the position of the first check box
            position += 22;
            
            //adding it to the frame
            formContainer.add(choicesCheckBox[choiceIndex]);
        }
        roomTypeLabel.setBounds(0, 383, 150, 14);
                                            
        //Special request text area with label
        specialRequestTextField.setBounds(316 , 402, 283, 87);
        specialRequestTextField.setBorder(BorderFactory.createLineBorder(mainColor));
        specialRequestTextField.setLineWrap(true);
        specialRequestLabel.setBounds(316 , 383, 100, 14);
    
        submitButton.setBounds(0, 512, 600, 40);
        submitButton.setBackground(mainColor);
        submitButton.setForeground(Color.WHITE);
        
        title.setFont(new Font("Montserrat", Font.BOLD, 36));
        title.setForeground(mainColor);
        title.setBounds(0, 0, 601, 39);
        
        formContainer.setBounds(81, 90, 601, 553);
        formContainer.setLayout(null);
        formContainer.setBackground(new Color(0xffffff));
        formContainer.add(title);
        
        formContainer.add(firstNameLabel);
        formContainer.add(firstNameTextField);
        formContainer.add(lastNameLabel);
        formContainer.add(lastNameTextField);
        
        formContainer.add(emailLabel);
        formContainer.add(emailTextField);
        formContainer.add(phoneNumberLabel);
        formContainer.add(phoneNumberTextField);
        
        formContainer.add(arrivalDateLabel);
        formContainer.add(arrivalDateTextField);
        formContainer.add(arrivalTimeLabel);
        formContainer.add(arrivalTimeTextField);
        formContainer.add(arrivalMorning);
        formContainer.add(arrivalEvening);
        
        formContainer.add(departureDateLabel);
        formContainer.add(departureDateTextField);
        formContainer.add(departureTimeLabel);
        formContainer.add(departureTimeTextField);
        formContainer.add(departureMorning);
        formContainer.add(departureEvening);
        
        formContainer.add(flightNumberLabel);
        formContainer.add(flightNumberTextField);
        formContainer.add(numberOfGuestLabel);
        formContainer.add(numberOfGuestTextField);
        
        formContainer.add(roomTypeLabel);
        formContainer.add(specialRequestLabel);
        formContainer.add(specialRequestTextField);
        
        formContainer.add(submitButton);
        
        
        imageContainer.setBounds(765, 0, 501, 768);
        setSize(1266, 768);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0xffffff));
        add(formContainer);
        add(imageContainer);
        
        setVisible(true);
        
        
        
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Prevent the user from submiting if the last name and the firstname is empty 
                if(firstNameTextField.getText().equals("") || lastNameTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill up the last name or the first name", "Empyt Fields", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    //Asking the a confirmation from the user before displaying the summary of the data
                    int userChoice = JOptionPane.showConfirmDialog(null, "Are you sure to submit the data you inserted?");
                    
                    
                    String fullname = firstNameTextField.getText() + " " + lastNameTextField.getText();
                    String email = emailTextField.getText();
                    String phoneNumber = phoneNumberTextField.getText();
                    String arrivalDate = arrivalDateTextField.getText();
                    String arrivalTime = arrivalTimeTextField.getText();
                    String arrival = arrivalMorning.isSelected() ? "AM" : "PM";
                    
                    String departureDate = departureDateTextField.getText();
                    String departureTime = departureTimeTextField.getText();
                    String departure = departureMorning.isSelected() ? "AM" : "PM";
                    
                    String flightNumber = flightNumberTextField.getText();
                    String numberOfGuest = numberOfGuestTextField.getText();
                    String selectedRooms = "";
                    
                    for(int i = 0; i < choicesCheckBox.length; i++) {
                        if(choicesCheckBox[i].isSelected()) {
                            selectedRooms += choicesCheckBox[i].getText() + "\n      ";
                        }
                    }
                    
                    String specialRequest = specialRequestTextField.getText();
                    
                    
                    String data = "Fullname: " + fullname + "\n"
                                + "Phone number: " + phoneNumber + "\n"
                                + "Email: " + email + "\n"
                                + "Flight Number: " + flightNumber + "\n\n"
                                + "Arrival Details:   \n        -" + arrivalDate + "\n        -" + arrivalTime + " " +  arrival + "\n\n"
                                + "Departure Details: \n        -" + departureDate + "\n        -" + departureTime + " " +  departure + "\n\n"
                                + "Rooms selected: \n      " + selectedRooms + "\n"
                                + "Special request: \n       " + specialRequest;
                                
                    if(userChoice == 0) {
                        JOptionPane.showMessageDialog(null, data);
                    }
                    
                    
                }
                
            }
            
        });
        
    }
    
    public static void main(String[] args) {
        new Main();
        
        
        
    }
    
    public void applyStyle(JTextField textField) {
        textField.setBorder(BorderFactory.createLineBorder(mainColor));
    }
    
    public void applyRadioButtonStyle(JRadioButton option) {
        option.setBackground(new Color(0xFFFFFF));
        option.setForeground(mainColor);
    }
    

}
