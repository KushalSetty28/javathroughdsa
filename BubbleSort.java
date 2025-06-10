package xyz;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] numbers= {3,2,5,6,1,6,7,8,9,6,4};
		System.out.println("unsorted list:");
		for(int num: numbers) {
			System.out.print(num+" ");
		}
		
		for(int i = 0; i<numbers.length-1;i++) {
			for(int j = 0; j<numbers.length-1;j++) {
				if(numbers[j]>numbers[j+1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		System.out.println("\nsorted list:");
		for(int num: numbers) {
			System.out.print(num+" ");
		}
	}

}
