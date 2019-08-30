package a1;

import java.util.Arrays;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		// Counts the total number of items
		int count = scan.nextInt();
		
		// Create an array for items
		String[] items = new String[count];
		
		// Create an array for item prices
		double[] itemsPrice = new double[count];
		
		// Use for loop to fill arrays
		for (int i=0; i<count; i++) {
			items[i] = scan.next();
			itemsPrice[i] = scan.nextDouble();
		}
		
		// Count the number of spenders
		int spenders = scan.nextInt();
		
		// Create an array for each spender
		String[] spendersName = new String[spenders];
		
		// Array for price paid by each spender
		double[] spenderPrice = new double[spenders];
		
		for (int i=0; i<spenders; i++) {
		// Adds each spender's name to the array
			String firstName = scan.next();
			String lastName = scan.next();
			spendersName[i] = firstName + " " + lastName;
			
			// Counts the amount of items for each person
			int itemCount = scan.nextInt();
			
			// Arrays for amount of items and item names
			double[] amount = new double[itemCount];
			String[] itemName = new String[itemCount];
			for (int j=0; j<itemCount; j++) {
				amount[j] = scan.nextInt();
				itemName[j] = scan.next();
			}
			
			// Find the prices for each spender
			for (int k=0; k<itemCount; k++) {
				for (int m=0; m<count; m++) {
					if (itemName[k].equals(items[m])) {
						spenderPrice[i] += (amount[k] * itemsPrice[m]);
					}
				}
			}
		}
		
		String biggest = findBiggest(spendersName, spenderPrice);
		String smallest = findSmallest(spendersName, spenderPrice);
		double average = findAverage(spenderPrice);
		
		// All input parsed, so close scanner
		scan.close();

		System.out.println("Biggest: " + biggest);
		System.out.println("Smallest: " + smallest);
		System.out.println("Average: " + String.format("%.2f", average));
		
		}



static double findAverage(double[] vals) {
	double average = 0;
	
	for (int i=0; i<vals.length; i++) {
		average += vals[i];
	}
	return average/vals.length;
}

static String findBiggest(String[] names, double[] prices) {
	String intBiggest = names[0];
	double bigPrice = prices[0];
	for (int i=1; i<names.length; i++) {
		if (prices[i] > bigPrice) {
			intBiggest = names[i];
			bigPrice = prices[i];
		}
	}
	return intBiggest + " (" + String.format("%.2f", bigPrice) + ")";
}

static String findSmallest(String[] names, double[] prices) {
	String intSmallest = names[0];
	double smallPrice = prices[0];
	for (int i=1; i<names.length; i++) {
		if (prices[i] < smallPrice) {
			intSmallest = names[i];
			smallPrice = prices[i];
		}
	}
	return intSmallest + " (" + String.format("%.2f", smallPrice) + ")";
}
}