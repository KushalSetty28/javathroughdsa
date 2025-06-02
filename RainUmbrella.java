package dsa;

import java.util.Scanner;

public class RainUmbrella {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		if(str.equals("yes")) {
			System.out.println("Take an Umbrella");
		}else {
			System.out.println("No need of an Umbrella");
		}
	}

}
