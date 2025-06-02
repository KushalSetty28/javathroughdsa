package dsa;
import java.util.*;

public class Hash {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("KUSHAL");
        hs.add("VAMSI");
        hs.add("SRUJAN");
        hs.add("SRUJAN"); // Duplicate won't be added

        System.out.println(hs); // Prints unique elements

        String nameToCheckS = "SRUJAN";
        boolean exist = hs.contains(nameToCheckS); // Corrected variable name
        System.out.println("Exist: " + exist);
        ArrayList<String> arrayList = new ArrayList<>(hs);
        System.out.println(arrayList);

    }
} 