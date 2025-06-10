package dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class AllList {
	
	public void Array() {
		ArrayList<String> AL = new ArrayList<String>();
		AL.add("kushal");
		AL.add("puneeth");
		AL.add("saketh");
		System.out.println(AL);
	}
	
	public void Linked() {
		LinkedList<String> LL = new LinkedList<String>();
		LL.add("praveen");
		LL.add("paul");
		LL.add("Harsha");
		System.out.println(LL);
	}
	
	public void Set() {
		HashSet<String> HS = new HashSet<String>();
		HS.add("subhash");
		HS.add("Vamsi");
		HS.add("Srujan");
		System.out.println(HS);
	}
	
	public void Map() {
		HashMap<Integer, String> HM =new HashMap<Integer, String>();
		HM.put(1, "Venu");
		HM.put(2, "Riyan");
		HM.put(3, "santhosh");
		System.out.println(HM);
	}
	

	public static void main(String[] args) {
		AllList demo = new AllList();
		demo.Array();
		demo.Linked();
		demo.Set();
		demo.Map();
	}

}
