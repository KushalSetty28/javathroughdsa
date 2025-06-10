package dsa;

import java.util.TreeMap;

public class TreeeMap {

	public static void main(String[] args) {
		TreeMap<String, Integer> tm= new TreeMap<String, Integer>();
		tm.put("kushal", 91);
		tm.put("puneeth", 90);
		tm.put("saketh", 89);
		
		String search ="kushal";
		
		if (tm.containsKey(search)) {
	           System.out.println(search + "'s marks: " + tm.get(search));
	       } else {
	           System.out.println(search + " not found.");
	       }


		System.out.println("All student marks: " +tm);

	}

}
