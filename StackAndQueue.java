package dsa;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
public class StackAndQueue {

	public static void main(String[] args) {
		Stack<String> Toys = new Stack<String>();
		Queue<String> Icecream = new LinkedList<>();
		
		System.out.println("Adding toys to box:");
		Toys.push("Ball");
		Toys.push("Blocks");
		Toys.push("Puzzles");
		System.out.println("Box contain Toys: "+ Toys);
		
		System.out.println("children for icecream:");
		for(int i=1; i<=5; i++) {
		Icecream.add("ice "+i);
		}
		System.out.println("Children who are in queue:" + Icecream);
		
		
	}

}
