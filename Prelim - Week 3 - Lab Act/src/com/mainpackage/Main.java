package com.mainpackage;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//initializing 2 dimension array 
		int[][] twoDimensionArray = new int[2][4];
		//defining the index of the second row
		int secondRow = 1;
		
		
		//Asking a number from the user to fill in the first row of an array
		System.out.print("Enter a number to fill in the first row: ");
		int firstRowNumber = input.nextInt();
		
		
		//Populating the 2 dimension array
		for(int index = 0; index < twoDimensionArray.length; index++) {
			
			//checking if the current index is the position of second row
			if(index == secondRow) {
				//populating the columns of the 2nd row with range of random numbers from 0 - 9
				for(int column = 0; column < twoDimensionArray[index].length; column++) {
					//creating a variable that holds the data of random number
					double randomNumber =  Math.floor(Math.random() * 9);
					
					//Accessing a specific cell in the array and set the value to the random number
					twoDimensionArray[index][column] = (int)randomNumber;
				}
			}
			
			//Otherwise or if the index is the position of first row
			else {
				//Populating the all the column of the first row based from the user input
				for(int column = 0; column < twoDimensionArray[index].length; column++) {
					
					//Accessing a specific cell in the array and set the value to the user input
					twoDimensionArray[index][column] = firstRowNumber;
				}
			}		
		}
		
		//Displaying result
		System.out.println("\nRESULT");
		System.out.println("=======");
		//iterating every row of the 2 dimension array
		for(int row = 0; row < twoDimensionArray.length; row++) {
			
			//Printing every column data of the 2 dimension array of a specific row
			for(int column = 0; column < twoDimensionArray[row].length; column++) {
				//Accessing a specific cell data and add space when printed in the console 
				System.out.print(twoDimensionArray[row][column] + " ");
			}
			
			//Transfer row into the next line
			System.out.println();
		}
		
		System.out.println("=======");
	}
}
