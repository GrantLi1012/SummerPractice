import java.util.Scanner;

public class Get_Biggest_Avg_ofArray {

	public static void main(String[] args) {

	int arraySize;
	
	System.out.println("Enter size of array:");
	Scanner input = new Scanner(System.in);
	arraySize = input.nextInt();
	
	int array[] = new int[arraySize];
	
	System.out.println("Enter elements:");
	for(int i=0;i<arraySize;i++) {
		array[i]=input.nextInt();
	}
	
	System.out.println("Biggest num in array is "+getBiggest(array,arraySize));
	System.out.println();
	System.out.printf("Avg of array is: %.2f",getAvg(array,arraySize));
		
	}
	
	
	public static int getBiggest(int array[],int size) {
		int biggest = 0;
		
		for (int i=0;i<size;i++) {
			if(array[i]>biggest) {
				biggest = array[i];
			}
			else {
				
			}
		}
		
		return biggest;
	}
	
	public static double getAvg(int array[],int size) {
		double avg = 0.0;
		double sum = 0.0;
		for(int i=0;i<size;i++) {
			sum+=array[i];
		}
		avg = sum/size;
		return avg;
	}


}
