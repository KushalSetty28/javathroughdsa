package abc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Bfstask1 {

	public static void main(String[] args) {
		Map<String,List<String>> House = new HashMap<String,List<String>>();
		House.put("Entrance",Arrays.asList("ReptilHouse","BirdSanctuary","MammalZone"));
		House.put("ReptilHouse", Arrays.asList("SnakePit"));
		House.put("BirdSanctuary", Arrays.asList("ParrotPavilion"));
		House.put("MammalZone",Arrays.asList("LionDen","ElephantEnclosure"));
		House.put("SnakePit",new ArrayList<String>());
		House.put("ParrotPavilion",new ArrayList<String>());
		House.put("LionDen",new ArrayList<String>());
		House.put("ElephantEnclosure", new ArrayList<String>());
		System.out.println("All other have no futher zones.");
		bfs(House,"Entrance");	
	}

public static void bfs(Map<String,List<String>> House, String startRoom) {
	Queue<String> queue = new LinkedList<>();
	Set<String> visited = new HashSet<>();
	
	queue.add(startRoom);
	visited.add(startRoom);
	
	while(!queue.isEmpty()) {
		String currentroom = queue.poll();
		System.out.println("Visited:"+currentroom);
		
		List<String> neighbors = House.getOrDefault(currentroom, new ArrayList<>());
        for (String neighbor : neighbors) {
        	if (!visited.contains(neighbor)) { 
				queue.add(neighbor);
				visited.add(neighbor);
			}
		}
	}
}
}





