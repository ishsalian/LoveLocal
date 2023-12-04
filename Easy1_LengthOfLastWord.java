

import java.util.Scanner;

public class LengthOfLastWord {

    // Method to calculate the length of the last word in a string
    public static int lengthOfLastWord(String s) {
        // Step 1: Split the input string into words using whitespace as a delimiter
        String[] words = s.split("\\s+");

        // Step 2: Check if there are no words in the array
        if (words.length == 0) {
            return 0; // If no words, the length of the last word is 0
        }

        // Step 3: Return the length of the last word in the array
        return words[words.length - 1].length();
    }

    // Main method to take user input and demonstrate the functionality
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 4: Take input string from the user
        String inputStr = sc.nextLine();

        // Step 5: Call the lengthOfLastWord method with the input string
        int result = lengthOfLastWord(inputStr);

        // Step 6: Print the result
        System.out.println(result);

        // Step 7: Close the scanner to avoid resource leak
        sc.close();
    }
}

