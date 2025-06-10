package dsa;
import java.util.Queue;
import java.util.LinkedList;
public class QueueTask {

	public static void main(String[] args) {
		Queue<String> ice= new LinkedList<>();
		for(int i =1; i<=5; i++) {
			ice.add("ice" + i);
		}
		System.out.println("Children who are standing in Queue for icecream : "+ ice);
		String firstOut = ice.poll();
		System.out.println(firstOut);
		
		

	}

}
