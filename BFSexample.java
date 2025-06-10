package abc;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
public class BFSexample {

	public static void main(String[] args) {
		Map<String, List<String>> house = new HashMap<String,List<String>>();
		//Breadth First Search
		//it means exploring a graph, level by level checking all your closest friends first then the others.
		house.put("Living Room",Arrays.asList("Kitchen","Bedroom","StudyRoom"));
		
		house.put("Kitchen", Arrays.asList("Bathroom"));
		
		house.put("Bedroom", Arrays.asList("Balcony"));
		
		house.put("StudyRoom",new ArrayList<String>());
	
		house.put("Bathroom",new ArrayList<String>());

		house.put("Balcony",new ArrayList<String>());
		
		System.out.println("Exploring the house using BFS starting from living room ");
		bfs(house,"Living Room");
	}
public static void bfs(Map<String, List<String>> house, String startRoom) {
	Queue<String> queue = new LinkedList<>();
	Set<String> Visited = new HashSet<>();
	
	queue.add(startRoom);
	Visited.add(startRoom);
	
	while(!queue.isEmpty()) {
		String currentRoom = queue.poll();
		System.out.println("Visited: "+currentRoom);
		
		for(String neighbor : house.get(currentRoom)) {
			if(!Visited.contains(neighbor)) {
				queue.add(neighbor);
				Visited.add(neighbor);
			}
		}
	}
}

}

