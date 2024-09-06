Question:

Given a pair of positive integers m and n, write a program to smartly affix zeroes, while printing the numbers from m to n.

Input Format

Input consists of two integers.

Constraints

(m < n; 0 < m < 999; 1 < n < = 999),

Output Format

Execute the range value, and add it with affix zeros(depending on the digit's range values)

Program:

import java.util.Scanner;

public class NumberPadding {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int maxDigits = String.valueOf(n).length();

        for (int i = m; i <= n; i++) {
            // Print the number with leading zeros according to maxDigits
            System.out.printf("%0" + maxDigits + "d ", i);
        }
     }
}
