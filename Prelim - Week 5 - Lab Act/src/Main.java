import java.util.Arrays;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Ask the user to enter the size of the array
		System.out.print("Enter the size of the array: ");
		int arraySize = input.nextInt();
		
		//Initialize a integer array with the size specified by the user
		int[] array = new int[arraySize];
		
		//Populate the array
		for(int index = 0; index < array.length; index++) {
			//Ask the user for number to be inserted in the array
			System.out.print("Enter the element for position " + index + ": ");
			int element = input.nextInt();
			
			//Insert the element to the array
			array[index] = element;
		}
		//Display the current state of the array
		System.out.println("Array values: " + Arrays.toString(array));
		System.out.println("\n========================================");
		System.out.println("========================================\n");
		
		
		//Asking user if for element to be updated
		System.out.print("Enter the element to be updated: ");
		int elementValue = input.nextInt();
		
		//boolean variable to keep track whether the specified number exist or not
		//set the default value to false
		boolean isElementExist = false;
		
		//Checking for every elements that match the user input in the array
		for(int index = 0; index < array.length; index++) {
			
			//checking if the current element match with the element value specified by the user
			int currentElementChecking = array[index];
			if(elementValue == currentElementChecking) {
				//Ask the user to enter the element value to replace the match element
				//Display also the position of the element 
				System.out.print("Enter value to replace to " + elementValue + " at position " + index + ": ");
				int newValue = input.nextInt();
				
				//Updating the array with the new value specified
				array[index] = newValue;
				
				//Change the value true meaning that the element user wants to change exist
				isElementExist = true;
			}
		}
		
		//Checking if the element does not exist notify the user
		if(!isElementExist) System.out.println("The element does not exist");
		//Display new state of the array
		System.out.println("Array values: " + Arrays.toString(array));
		System.out.println("\n========================================");
		System.out.println("========================================\n");
		
		
		//Ask the users for position of the element to be deleted
		System.out.print("Enter the index position of the element to be deleted: ");
		int indexPosition = input.nextInt();
		
		
		int arrayLength = array.length;
		int maxIndex = arrayLength - 1;
		
		//creating new container for reduced elements
		int[] updatedArray = new int[arrayLength - 1];
		
		//Checking if the position is valid input
		if (indexPosition > maxIndex) {
			System.out.println("The element position does not exist");
		}
		
		else {
			//Populating the updatedArray
			for(int index = 0, newArrayIndex = 0; index < array.length; index++) {
				//Checking if index is not equal to the position specified by the user 
				if(indexPosition != index) {
					
					//set the value for the updated array
					updatedArray[newArrayIndex] = array[index];
					
					//then increment the position to be filled in the updated array
					newArrayIndex++;
				}
				
				//if the element is equal then do nothing
				
			}
			//then set the reduced array or the updated array to the original array
			array = updatedArray;
		}
		
		//displays the result of the array
		System.out.println("Array values: " + Arrays.toString(array));
		
	}

}
