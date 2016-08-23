package DoubleHashing;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Search {
	
	private final static int DATA_SIZE = 900;										// Declare a constant for table size
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		HashMapping hashMap = new HashMapping();
		long startTime, endTime, executionTime;
		
		generateData(hashMap);														// Generate data and add the data into the hash table
		
		System.out.print("Enter item key: ");										// Prompt user to input a key for searching
		int searchKey = sc.nextInt();
		
		while (searchKey != -1) {
		
			startTime = System.nanoTime();												// Get the start time of the search
			String searchValue = hashMap.get(searchKey);									// Search the key inside the hash table
			endTime = System.nanoTime();												// Get the end time of the search
			executionTime = endTime - startTime;										// Get the execution time (i.e. endTime - startTime)
			
			if (searchValue != null) {													// If the search is successful
				/* prints output of the search */
				System.out.println("Search Successful");
				System.out.println("Your item key is = " + searchKey);
				System.out.println("Yout item value is = " + searchValue);
				System.out.println("Number of Comparisons = " + HashMapping.counter + " comparisons.");
				System.out.println("Execution time = " + executionTime + " ns");
			}
			else {																		// If the search is unsuccessful
				/* prints the output of the search */
				System.out.println("Search Unsuccessful");
				System.out.println("Number of Comparisons = " + HashMapping.counter + " comparisons.");
				System.out.println("Execution time = " + executionTime + " ns");
			}
			
			System.out.print("\nEnter item key: ");										// Prompt user to input a key for searching
			searchKey = sc.nextInt();
		}
		System.out.println("terminating");
	
	}																				// End Main
	
	/* generateData method to generate a set of data */
	public static void generateData(HashMapping hashMap) throws IOException {
		FileReader fr = new FileReader("text.txt");
		BufferedReader br = new BufferedReader (fr);
		Random rand = new Random();
		int dataCounter = 0;
		
		while (dataCounter < DATA_SIZE) {											// Generate data as much as DATA_SIZE
			int key = rand.nextInt(20000000) + 80000000;							// Generate an 8-digit number starting with 8 or 9
			System.out.print(key);												// Print the data that is generated
			String name=br.readLine();
			System.out.println("\t : " + name);
			if(hashMap.addItem(key, name) == 1) {									// Add the data into the hash table
				dataCounter++;
			}
		}
	}																				// End generateData
}
