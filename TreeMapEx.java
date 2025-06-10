package dsa;

import java.util.TreeMap;

public class TreeMapEx {
	//Treemap is part of java collections framework and it implements the map interface using a RedBlack tree it stores key value pairs and maintains the keys in sorted ordered
	public static void main(String[] args) {
		TreeMap<Integer,String> tm = new TreeMap<Integer,String>();
		tm.put(1, "kushal");
		tm.put(2, "sreedhar");
		tm.put(3, "srujan");
		tm.put(4, "kushal");
		
		System.out.println(tm);

	}
	
}