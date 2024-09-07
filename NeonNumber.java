Write a program to check whether a given number is Neon number or not.

Note-A neon number is a number where the sum of digits of square of the number is equal to the number. The task is to check and print neon numbers in a range. sum of the digits of the square is 9. + 4 + 4) which is not equal to 12

Input Format

Input consists of Single Integer.

Constraints

Given inputs between the range of 1 to 9

Output Format

If the Conditions is true Print the Statement depends on the testcases. If the Condidtions is false Print the statement depends on the testcases. If the input is not upto the range Print the statement "Invalid Input".

Sample Input 0
6

Sample Output 0
0006 is not a Neon Number.

Sample Input 1
9

Sample Output 1
009 is a Neon Number.


Program:

import java.util.*;
public class NeonNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number < 1 || number > 9) {
            System.out.println("Invalid Input");
        } 
        else {
             int square = number * number;
             int sum = 0;
            while (square > 0) {
                int a= square % 10;
                sum = sum +a;
                square = square/ 10;
            }
             
            if (sum == number) {
                System.out.printf("00%d is a Neon Number", number);
            } else {
                System.out.printf("000%d is not a Neon Number", number);
            }
        }

    }
}
