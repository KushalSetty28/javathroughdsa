package xyz;

import java.util.PriorityQueue;

public class prioritytask1 {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(5);
		pq.add(2);
		pq.add(8);

		System.out.println("Sorted List : ");
		while (!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
	}
}
		
