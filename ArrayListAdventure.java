package xyz;
import java.util.ArrayList;

public class ArrayListAdventure {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Nobitha");
		al.add("Doremoan");
		al.add("Chota Bheem");
		al.add("raju");
		al.add("Ben Ten");
		System.out.println(al);
		System.out.println(al.remove(3));
		System.out.println(al);
		System.out.println(al.removeLast());
		al.set(2, "Kushal");
		System.out.println(al);//set means -replace
	}

}
