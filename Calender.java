package dsa;
import java.util.Scanner;
public class Calender {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String Day = sc.nextLine().toLowerCase();
		switch(Day){
			case "Monday":
				System.out.println("learn Python");
				break;
			case "Tuesday":
				System.out.println("learn Java");
				break;
			case "wednesday":
				System.out.println("learn c++");
				break;
			case "Thrusday":
				System.out.println("learn c");
				break;
			case "Friday":
				System.out.println("learn react");
				break;
			case "Saturday":
				System.out.println("learn sql");
				break;
			case "Sunday":
				System.out.println("learn swift");
				break;
			default:
				System.out.println("");
		}
	}
}