package xyz;

public class ConstantTimeExample {

	public static void printFirstElement(int[] arr) {
		if(arr.length>0) {
			System.out.println("First element is "+arr[0]);
		}else {
			System.out.println("Array is empty");
		}
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		printFirstElement(arr);
	}

}
