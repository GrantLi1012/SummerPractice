package stock_and_invoice;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreTest {

	public static void main(String[] args) {

		ArrayList<Stock> products = new ArrayList<Stock>();
		products.add(new Stock("Apples", 10, 1));
		products.add(new Stock("Pears", 2, 2));
		products.add(new Stock("Books", 3, 3));
		products.add(new Stock("Glues", 12, 4));

		System.out.println(products.get(1).getPrice());

		System.out.println("Enter max orders per day: ");
		Scanner input = new Scanner(System.in);
		int maxOrder = input.nextInt();
		int orderCount = 0;
		
		double totalRevenue = 0.0;

		while (orderCount < maxOrder) {
			System.out.println("----------------new deal------------------");
			System.out.println("Enter operation code:");
			System.out.println("1 to sell\n2 to replenish\n3 to check product info\n0 to check total revenue");
			int action = input.nextInt();

			switch (action) {
			case (1):
				totalRevenue += sell(products);
				orderCount++;
				break;

			case (2):
				replenish(products);
				break;

			case (3):
				checkInfo(products);
				break;

			case (0):
				checkRevenue(totalRevenue);
				break;

			default:
				System.out.println("Invalid code.");
				break;
			}

		}
		
		System.out.println("End of the day!");
		System.out.println("Total revenue earned is: "+totalRevenue+"$");
	}

	public static double sell(ArrayList<Stock> products) {
		int product;
		int numberSold;
		int toSell;
		double costOfOrder = 0.0;
		System.out.println("Enter 1 to continue shopping, 0 to check out: ");
		Scanner sell = new Scanner(System.in);
		toSell = sell.nextInt();

		while (toSell != 0) {
			System.out.println("Enter product code: ");
			product = sell.nextInt();
			System.out.println("Enter number of product: ");
			numberSold = sell.nextInt();

			if (products.get(product).stock >= numberSold) {
				products.get(product).stock -= numberSold;
				costOfOrder += (products.get(product).getPrice()) * numberSold;

				System.out.println("Enter 1 to continue shopping, 0 to check out: ");
				toSell = sell.nextInt();
			} 
			else {
				System.out.println("Stock in shortage, unable to sell!");
				System.out.println("Enter 1 to continue shopping, 0 to check out: ");
				toSell = sell.nextInt();
			}

		}

		System.out.println("Total cost of order: " + costOfOrder);
		return costOfOrder;

	}

	public static void replenish(ArrayList<Stock> products) {
		int product;
		int numAdded;
		System.out.println("Replenishing...");
		System.out.println("Enter code of product: ");
		Scanner add = new Scanner(System.in);
		product = add.nextInt();
		System.out.println("Enter replenished number: ");
		numAdded = add.nextInt();
		
		products.get(product).stock += numAdded;
		
		System.out.println("Successfully replenished!");
		System.out.println("Current stock of "+products.get(product).getDec()+" is: "+products.get(product).stock);
		
	}

	public static void checkInfo(ArrayList<Stock> products) {
		int product;
		System.out.println("Enter code of product to check info: ");
		Scanner checkingInfo = new Scanner(System.in);
		product = checkingInfo.nextInt();
		
		System.out.println(products.get(product).showInfo());
	}

	public static void checkRevenue(double revenue) {
		System.out.println("Total revenue now is: "+revenue);
	}

}
