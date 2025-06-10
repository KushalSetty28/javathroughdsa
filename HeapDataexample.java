package xyz;

import java.util.Collection;
import java.util.PriorityQueue;

public class HeapDataexample {
	public static void main(String[] args) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        minheap.add(20);
        minheap.add(5);
        minheap.add(15);
        minheap.add(10);

        System.out.println("Min Heap output : ");
        while (!minheap.isEmpty()) {
            System.out.print(minheap.poll() + " ");
        }

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(java.util.Collections.reverseOrder());
        maxheap.add(20);
        maxheap.add(5);
        maxheap.add(15);
        maxheap.add(10);

        System.out.println("\nMax Heap output : ");
        while (!maxheap.isEmpty()) {
        	System.out.println(maxheap.poll());
        }
	}
}
       

// a heap is a special tree where numbers are like kids standing the queue
// everyone follow the rule
// Either the smallest num is always pn top in Minheap
// or the biggest num is always on top in Maxheap.