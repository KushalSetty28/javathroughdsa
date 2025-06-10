package xyz;
import java.util.Map;
import java.util.HashMap;
public class GroceryBasket {

	public static void main(String[] args) {
		HashMap<String,Integer> Hm = new HashMap<String,Integer>();
		Hm.put("Carrot",24);
		Hm.put("orange", 50);
		Hm.put("Potato",30);
		Hm.put("Apple", 100);
		System.out.println("The Grocery items in the Basket" + Hm);
		int total = 0;
		for(Map.Entry<String, Integer> entry : Hm.entrySet()) {
			total += entry.getValue();
		}
		System.out.println("The total cost of grocery items:"+total);
		Hm.put("Bananna", 40);
		System.out.println("Updated List of items"+ Hm );
		int Updatedtotal =0;
		for(Map.Entry<String, Integer> s: Hm.entrySet()) {
			Updatedtotal+= s.getValue();
		}
		System.out.println("Updated items cost:"+Updatedtotal);
	}

}
