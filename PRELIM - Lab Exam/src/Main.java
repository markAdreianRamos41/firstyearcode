import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int maxPeriod = 3;
		int[][][] studentRecord;

		System.out.println("GRADING SYSTEM USING 3-D JAGGED ARRAY");
		System.out.print("Enter number of students: ");
		int numberOfStudents = input.nextInt();
		studentRecord = new int[numberOfStudents][maxPeriod][];
		
		//Populating the 3D Jagged array called studentRecord
		for(int student = 0; student < studentRecord.length; student++) {
			//Accessing individual periods for every student
			for(int period = 0; period < maxPeriod; period++) {
				
				//Used for displaying for who is the inputed grade is.
				int studentCount = student + 1;
				int periodCount = period + 1;
				
				//Asking for seat work count of a specific student
				System.out.println("\nSTUDENT " + studentCount + " => PERIOD " + periodCount + ": ");
				System.out.println("MAXIMUM NUMBER OF SEATWORK IS 3\n ");
				System.out.print("Enter number of seatwork: ");
				int numberOfSeatworks = input.nextInt();
				
				//preventing number of seat works to be more than 3
				while(numberOfSeatworks > 3) {
					System.out.println("\n=================================================");
					System.out.println("Maximum number for seatwork is 3 please try again");
					System.out.println("=================================================");
					System.out.println("\nSTUDENT " + studentCount + " => PERIOD " + periodCount + ": ");
					
					//Asking the user again to input the number of seatwork
					System.out.print("Enter number of seatwork: ");
					numberOfSeatworks = input.nextInt();
					
				}
				
				//creating a new instance of array with length specified by the user
				studentRecord[student][period] = new int[numberOfSeatworks];
				
				//Then populate the new instance of that array based on the user inputs
				for(int seatwork = 0; seatwork < studentRecord[student][period].length; seatwork++) {
					int seatworkCount = seatwork + 1;
					
					//Setting the value for the column values based on the user input 
					System.out.print("Enter the score for seatwork " + seatworkCount + ": ");
					int seatworkScore = input.nextInt();
					studentRecord[student][period][seatwork] = seatworkScore;
				}
			}
		}
		
		System.out.println("\nGRADE SUMMARY:");
		//Display the Result in table format
		for(int period = 0; period < maxPeriod; period++) {
			//Creating a table based on the current period
			int periodCount = period + 1;
			System.out.print("\nPeriod " + periodCount + " \tSeatwork 1" + "\tSeatwork 2" + "\tSeatwork 3");
			
			//Displaying the students number as well as the specified grades by the user
			for(int student = 0; student < studentRecord.length; student++) {
				int studentCount = student + 1;
				System.out.print("\nStudent " + studentCount);
				
				//For every student display their grades aligned with their corresponding seat work number
				for(int grade = 0; grade < studentRecord[student][period].length; grade++) {
					System.out.print(" \t\t" + studentRecord[student][period][grade]);
				}
			}
			
			//move the cursor to the next line to create separation between table of periods 
			System.out.println();
			
		}
	}
}
