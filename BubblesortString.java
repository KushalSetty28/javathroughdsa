package xyz;

public class BubblesortString {

    public static void main(String[] args) {
        String[] words = {"banana", "apple", "grape", "orange"};

        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (words[j].compareTo(words[j + 1]) > 0) {
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }

        // Print sorted array just once
        System.out.println("Sorted strings:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
