package dsa;

import java.util.TreeSet;

public class TreeSetExample {
//TreeSet it is the part of java connections framework and it represents a set collection that uses a RedBlack tree. It is the type of Binary Search Tree.

	public static void main(String[] args) {
		TreeSet<Integer> numbers = new TreeSet<Integer>();
		numbers.add(50);
		numbers.add(20);
		numbers.add(40);
		numbers.add(10);
		numbers.add(30);
		numbers.add(20);
		numbers.add(60);
		System.out.println(numbers);
		System.out.println(numbers.first());
		System.out.println(numbers.higher(30));
		System.out.println(numbers.size());
	}

}
