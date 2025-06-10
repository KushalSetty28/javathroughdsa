package dsa;
import java.util.Scanner;
public class Palindrome {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        scanner.close();

        String reversedStr = new StringBuilder(str).reverse().toString();

        if (str.equalsIgnoreCase(reversedStr)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }

	}

}
