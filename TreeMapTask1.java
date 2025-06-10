package xyz;
import java.util.TreeMap;
public class TreeMapTask1 {

	public static void main(String[] args) {
		TreeMap<String,String> tm =new TreeMap<String,String>();
		tm.put("INDIA","New Delhi");	
		tm.put("USA", "WASHINGTON");
		tm.put("GERMANY", "BERLIN");
		tm.put("JAPAN", "TOKYO");
		tm.put("INDIA", "DELHI");
		System.out.println(tm);
		System.out.println(tm.firstKey());
		System.out.println(tm.lastKey());
		System.out.println(tm.reversed());
	
	}

}
