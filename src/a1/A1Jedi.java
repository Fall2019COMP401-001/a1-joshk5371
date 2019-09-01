package a1;

import java.util.Scanner;

public class A1Jedi {

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
		
		// Array for amount of customers who bought x items
		int[] c = new int[count];
		
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
			
			for (int k=0; k<items.length; k++) {
				int a=0;
				for (int m=0; m<itemName.length; m++) {
					if (items[k].equals(itemName[m])) {
						a++;
					}
				}
				c[k] += a;
			}
		}

		
		// All input parsed, so close scanner
		scan.close();
		
		for (int i=0; i<c.length; i++) {
			if (c[i]==0) {
				System.out.println("No customers bought " + items[i]);
			} else {
				System.out.println(c[i] + " customers bought " + "___ " + items[i]);
			}
		}
	}
}