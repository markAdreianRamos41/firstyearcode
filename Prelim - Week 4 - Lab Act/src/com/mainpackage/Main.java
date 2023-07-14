package com.mainpackage;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Ask the user to enter the number of students
		System.out.print("Enter the number of students: ");
		int numberOfStudents = input.nextInt(); 
		//Declaring a variable for the number of periods and seat works.
		int numberOfPeriod = 3;
		int numberOfSeatWork = 4;
		
		//Initializing 3D array based from the number of students and each student has a 3 periods and 4 seat works.
		int[][][] studentGrades = new int[numberOfStudents][numberOfPeriod][numberOfSeatWork];
		
		//3 layers of loop to populate the 3D array above
		for(int studentIndex = 0; studentIndex < studentGrades.length; studentIndex++) {
			
			//Displaying student number for who the grades is
			System.out.println("\nSTUDENT " + (studentIndex + 1) + ": ");
			System.out.println("===============");
			for(int periodIndex = 0; periodIndex < studentGrades[studentIndex].length; periodIndex++) {
				//Displaying what period is the 4 seat works
				System.out.println("PERIOD " + (periodIndex + 1) + " GRADES ");
				
				
				for(int seatworkIndex = 0; seatworkIndex < studentGrades[studentIndex][periodIndex].length; seatworkIndex++) {
					//Displaying every seatwork for a specific period
					System.out.print("Seatwork " + (seatworkIndex + 1)  + " : ");
					//ask the grade for that seatwork
					int grade = input.nextInt();
					//populate the array with the grade input
					studentGrades[studentIndex][periodIndex][seatworkIndex] = grade;
			
				}
				
				
			}
			
			System.out.print("===============");
		}
		
	
		
		//Displaying the populated 3D array in table format (rows and column)
		System.out.println("\n\nSUMMARY OF GRADES");
		//3 layers of loop
		for(int studentIndex = 0; studentIndex < studentGrades.length; studentIndex++) {
			//Displaying grades for a specific student
			System.out.println("Student " + (studentIndex + 1) + " Seatwork Grades are");
		
			for(int periodIndex = 0; periodIndex < studentGrades[studentIndex].length; periodIndex++) {
				//displaying every periods for the students
				System.out.print("Period: " + (periodIndex + 1) + ": ");
				
				
				for(int seatworkIndex = 0; seatworkIndex < studentGrades[studentIndex][periodIndex].length; seatworkIndex++) {
					//Displaying grade for a specific seatwork in a specific period
					System.out.print("\t" + studentGrades[studentIndex][periodIndex][seatworkIndex]);
			
				}
				//transfer next period to next line
				System.out.println();
			}
			//transfer the next student records into the next line.
			System.out.println();
		}
	
	}

}
