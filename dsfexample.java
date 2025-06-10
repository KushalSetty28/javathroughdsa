package ijk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class dsfexample {
	private Map<String,List<String>> homemap = new HashMap<String,List<String>>();
	private Set<String> visited = new HashSet<String>();
	
	public void addRoom(String room, String connectedRoom) {
		homemap.computeIfAbsent(room, _-> new ArrayList<>()).add(connectedRoom);
		homemap.computeIfAbsent(connectedRoom, _-> new ArrayList<>()).add(room);
	}
	public void dfs(String currentRoom) {
		if(visited.contains(currentRoom)) return;
	
		visited.add(currentRoom);
		System.out.println("Visited: "+currentRoom);
		
		for(String neighbor: homemap.getOrDefault(currentRoom,new ArrayList<String>())) {
			dfs(neighbor);
				 
		}
	}
	public static void main(String[] args) {
		dsfexample home = new dsfexample();
		
		home.addRoom("Living Room","Kitchen");
		home.addRoom("Living Room","Bedroom");
		home.addRoom("Bedroom","Bathroom");
		
		System.out.println("DFS Traversal starting from Living Room:");
		home.dfs("Living Room");
	}
}
 