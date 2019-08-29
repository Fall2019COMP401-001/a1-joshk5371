package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Counts the total number of customers
		int count = scan.nextInt();
		
		// Create an array of customers
		String[] customers = new String[count];
		
		// Loop for each customer
		for (int i=0; i<count; i++) {
		// Use charAt() for first initial of name
		String firstName = scan.next().charAt(0) + ". ";
		String lastName = scan.next();
		
		// Count the amount of groceries
		int groceryCount = scan.nextInt();
		
		String[] items = new String[groceryCount];
		
		double[] groceries = new double[groceryCount*2];
		
		// Creating an array of numbers (amount and price) for groceries
		for (int k=0; k<groceries.length; k++) {
			groceries[k] = scan.nextDouble();
			int j=k;
			if (k==0) {
			items[j] = scan.next();
			} else if (k%2==0) {
				items[j/2] = scan.next();
			}
		}



		double prices = findPrice(groceries);
		
		// Add print to customers array
		customers[i] = (firstName + lastName + ": " + String.format("%.2f", prices));
		
		}
			
		// All input parsed, so close scanner
		scan.close();
		
		// Print results
		for (int i=0;i<customers.length; i++) {
			System.out.println(customers[i]);
		}
	}
	
	static double findPrice(double[] vals) {
		
		double price = 0;
		
		for (int i=0; i<vals.length; i+=2) {
			price += vals[i] * vals[i+1];
		}
		return price;
	}
}
