package dsa;
import java.util.Stack;
public class Plate {

	public static void main(String[] args) {
		Stack<Integer> plate = new Stack<Integer>();
		System.out.println("plate which are cleaned:");
		for(int i = 0; i<=5; i++) {
			plate.push(i);
		}
		System.out.println(plate);
		System.out.println("plate taken for eating" + plate.pop());
		System.out.println(plate);
	}

}
//A stack is the simple data structure the stores items in  last in first out order(lifo).
// A queue is dataStructure that works on FIFO manner