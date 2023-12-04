import java.util.Scanner;

public class ShortestPalindrome {

    public static String shortestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        // Build a new string by concatenating s, a special character, and the reversed s
        String newStr = s + "#" + new StringBuilder(s).reverse().toString();

        // Compute the KMP prefix array for the new string
        int[] prefix = new int[newStr.length()];
        int j = 0;

        for (int i = 1; i < newStr.length(); i++) {
            while (j > 0 && newStr.charAt(i) != newStr.charAt(j)) {
                j = prefix[j - 1];
            }

            if (newStr.charAt(i) == newStr.charAt(j)) {
                j++;
            }

            prefix[i] = j;
        }

        // The remaining part to be added in front of s
        String remaining = s.substring(prefix[newStr.length() - 1]);
        //returning result to the main method
        return new StringBuilder(remaining).reverse().toString() + s;
    }
    
    // Main method to take user input and demonstrate the functionality
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //taking input string from user 
        String userInput = sc.nextLine();
        //calling shortestPalindrome to find the shortest palindrome and storing it into variable res
        String res = shortestPalindrome(userInput);
        System.out.println(res);
    }
}
