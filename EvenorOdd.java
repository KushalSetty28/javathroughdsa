package dsa;
import java.util.Scanner;

public class EvenorOdd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
	    int num = sc.nextInt();
	   		sc.close();
	    if (num % 2 == 0) {
	    	System.out.println(num + " is even.");
	    	
	    } else {
	    	System.out.println(num + " is odd.");
	    	}
	    }
	}
 