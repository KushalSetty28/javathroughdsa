package ijk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class SocialCircleFinder {
	public static void main(String[] args) {
		Map<String,List<String>> search = new HashMap<>();
		search.put("Shreedhar", Arrays.asList("Kushal"));
		search.put("Kushal", Arrays.asList("Subbu","Srujan"));
		search.put("Srujan",Arrays.asList("Harsha"));
		search.put("Subhash", Arrays.asList("Venkatesh"));
		search.put("Venkatesh",Arrays.asList("Subhash"));
		search.put("Nithya", new ArrayList<>());
		 System.out.println("Recursive circle of Bob: " + findConnectedRecursive(search, "Harsha"));
		 System.out.println("Iterative circle of Eve: " + findConnectedIterative(search, "Venkatesh"));
		 System.out.println("All social circles: " + findAllSocialCircles(search));
		 
	}
	 private static String findConnectedRecursive(Map<String, List<String>> graph, String start) {
	        Set<String> visited = new HashSet<>();
	        List<String> connected = new ArrayList<>();
	        dfsRecursive(start, graph, visited, connected);
	        return connected.toString();
	    }

	    private static void dfsRecursive(String person, Map<String, List<String>> graph,
	                                     Set<String> visited, List<String> connected) {
	        if (visited.contains(person)) return;
	        visited.add(person);
	        connected.add(person);
	        for (String neighbor : graph.getOrDefault(person, Collections.emptyList())) {
	            dfsRecursive(neighbor, graph, visited, connected);
	        }
	    }

	    // 🌀 Iterative DFS
	    private static String findConnectedIterative(Map<String, List<String>> graph, String start) {
	        Set<String> visited = new HashSet<>();
	        List<String> connected = new ArrayList<>();
	        Stack<String> stack = new Stack<>();
	        stack.push(start);

	        while (!stack.isEmpty()) {
	            String person = stack.pop();
	            if (!visited.contains(person)) {
	                visited.add(person);
	                connected.add(person);
	                for (String neighbor : graph.getOrDefault(person, Collections.emptyList())) {
	                    if (!visited.contains(neighbor)) {
	                        stack.push(neighbor);
	                    }
	                }
	            }
	        }
	        return connected.toString();
	    }

	    // 🌐 All Social Circles
	    private static String findAllSocialCircles(Map<String, List<String>> graph) {
	        Set<String> visited = new HashSet<>();
	        List<List<String>> allCircles = new ArrayList<>();

	        for (String person : graph.keySet()) {
	            if (!visited.contains(person)) {
	                List<String> circle = new ArrayList<>();
	                dfsRecursive(person, graph, visited, circle);
	                allCircles.add(circle);
	            }
	        }

	        return allCircles.toString();
	    }
}