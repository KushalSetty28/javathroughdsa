package xyz;

import java.util.TreeSet;

public class TreeSetTask1 {

	public static void main(String[] args) {
		TreeSet<Integer> TS = new TreeSet<Integer>();
		TS.add(5002);
		TS.add(4998);
		TS.add(5005);
		TS.add(4999);
		TS.add(5001);
		System.out.println(TS);
		System.out.println(TS.first());
		System.out.println(TS.higher(4999));
		System.out.println(TS.lower(5000));
		System.out.println(TS.last());
		
		
	}

}
