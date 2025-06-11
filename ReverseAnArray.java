package xyz;

public class ReverseAnArray {

    public static void main(String[] args) {
        String[] word = {"Kushal", "Sai", "Harsha", "Srujan"};

        int left = 0;
        int right = word.length - 1;

        // Reverse the array in-place
        while (left < right) {
            String temp = word[left];
            word[left] = word[right];
            word[right] = temp;

            left++;
            right--;
        }

        // Print the reversed array
        System.out.print("Reversed array: ");
        for (String c : word) {
            System.out.print(c + " ");
        }
    }
}


