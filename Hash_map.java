package dsa;

import java.util.HashMap;

public class Hash_map {

	public static void main(String[] args) {
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		hm.put( "Sreedhar" , 1);
		hm.put( "Kushal", 2);
		hm.put( "Mohan", 3);
		hm.put( "Krishna", 4);
		hm.put( "Srujan", 5);
		System.out.println("original: "+hm );
		hm.remove("Krishna");
		System.out.println("updated: "+hm);
		if (hm.containsKey("Kushal")) {
            int value = hm.remove("Kushal"); // Remove old key and get value
            hm.put("Shakeeb", value); // Insert with new key
        }
		System.out.println("updated2:"+hm);
		System.out.println(hm.containsKey("Shakeeb"));    // Output: true
        System.out.println(hm.containsKey("Kushal"));

	}

}
 