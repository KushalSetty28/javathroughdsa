package xyz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendsGraph {

	public static void main(String[] args) {
		Map<String, List<String>> graph = new HashMap<>();
		graph.put("Kushal", Arrays.asList("Shreedhar"));
		graph.put("Shreedhar", Arrays.asList("Kushsl","Srujan"));
		graph.put("Srujan", Arrays.asList("Shreedhar"));
		
		for(String person: graph.keySet()) {
			System.out.println(person+ " is friend of " + graph.get(person));
		}
		
		

	}

}
