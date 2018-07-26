import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LabBonus20MyMarket {
	public static void main(String[] args) {
		HashMap<String, Double> myMarket = new HashMap<>();
		myMarket.put("apple", 0.99);
		myMarket.put("banana", 0.59);
		myMarket.put("cauliflower", 1.59);
		myMarket.put("dragonfruit", 2.19);
		myMarket.put("elderberry", 1.79);
		myMarket.put("figs", 2.09);
		myMarket.put("grapefruit", 1.99);
		myMarket.put("honeydew", 3.49);
		ArrayList<String> fruitNames = new ArrayList<String>();
		ArrayList<Double> fruitPrices = new ArrayList<Double>();

		String userFruit = "";

		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to Guenther's Market! ");
		String cont = "y";

		while (cont.equalsIgnoreCase("y")) {
			while (true) {
				System.out.printf("%-25s %-20s%n", "Item", "Price");
				System.out.println("=======================================");
				for (String variableName : myMarket.keySet()) {
					String variableKey = variableName;
					Double variableValue = myMarket.get(variableName);

					System.out.printf("%-15s %15.2f%n", variableKey, variableValue);
				}
				System.out.println();
				System.out.print("What item would you like to order? ");
				userFruit = scan.nextLine();
				userFruit = userFruit.toLowerCase();

				if (myMarket.containsKey(userFruit)) {
					System.out.print("Adding " + userFruit + " to the cart at $");
					System.out.print(myMarket.get(userFruit));
					System.out.println();
					fruitNames.add(userFruit);
					fruitPrices.add(myMarket.get(userFruit));
					break;
				} else {
					System.out.println("Sorry we don't have those. Please try again. ");
				}
			}

			System.out.print("Would you like to order anything else? (y/n) ");
			cont = scan.nextLine();
		}
		System.out.println();
		System.out.println("Alright here's what you got: ");
		System.out.println();
		for (int i = 0; i < fruitNames.size(); i++) {

			System.out.printf("%-15s %15.2f%n", fruitNames.get(i), fruitPrices.get(i));
		} 
		System.out.println();
		System.out.print("The average price per item was $" );
		calcAvg(fruitPrices);
		System.out.print("The most expensive item was $");
		maxPrice(fruitPrices);
		System.out.print("The least expensive item was $");
		minPrice(fruitPrices);
		System.out.println();
		System.out.println("Thank you for shopping! ");
	}
	public static void calcAvg (ArrayList<Double> arr) {
		double sum = 0.0;
		double average = 0.0;
		for(int i = 0; i < arr.size(); i++) {
			sum += arr.get(i);
		}
		average = sum / arr.size();
		System.out.printf("%.2f%n", average);
	}
	public static void maxPrice (ArrayList<Double> arr) {
		double max = 0.0;
		for(int i = 0; i < arr.size(); i++) {
			if (arr.get(i) > max) {
				max = arr.get(i);
			}
		}
		System.out.printf("%.2f%n", max);
	}
	public static void minPrice (ArrayList<Double> arr) {
		double min = arr.get(0);
		for(int i = 0; i < arr.size(); i++) {
			if (arr.get(i) < min) {
				min = arr.get(i);
			}
		}
		System.out.printf("%.2f%n", min);
	}
}
