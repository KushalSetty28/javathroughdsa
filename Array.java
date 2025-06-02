package dsa;

import java.util.*;

public class Array {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
	    al.add("KUSHAL");
		al.add("VAMSI");
		al.add("SRUJAN");
		System.out.println(al.get(1));
		System.out.println(al.remove(0));
		System.out.println(al);
		List<String> aa = al.reversed();
		System.out.println(aa);
		al.add("Siva");
		System.out.println(al);
		Collections.sort(al);
		System.out.println(al);
		String nameToCheck = "Harsha";
	    boolean exists = al.contains(nameToCheck);
	    System.out.println("Exists: " + exists);
	    String nameToCheckS = "SRUJAN";
	    boolean exist = al.contains(nameToCheckS);
	    System.out.println("Exist: " + exist);
	}

}
