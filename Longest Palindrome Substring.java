Question: Longest Palindrome Substring
 
Input:
dfffghrr

Output:
fff

Program:
import java.util.*;

public class LongestPalindromeSubstring {   
    public static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static String longestPalindrome(String str) {
        int n = str.length();
        String longPalindrome = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(str, i, j)) {
                    if (j - i + 1 > longPalindrome.length()) {
                        longPalindrome = str.substring(i, j + 1);
                    }
                }
            }
        }
        return longPalindrome;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String result = longestPalindrome(input);
        System.out.println("The longest palindrome substring is: " + result);

    }
}