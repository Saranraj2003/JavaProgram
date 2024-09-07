Write a program to check whether a given number is Neon number or not.

Note-A neon number is a number where the sum of digits of square of the number is equal to the number. The task is to check and print neon numbers in a range. sum of the digits of the square is 9. + 4 + 4) which is not equal to 12

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
        int a = sc.nextInt();
        if(a>=1 && a<=9){
            int n=a*a;
            int r=n%10;
            int s=n/10;
            int b=s+r;
            if(b==a){
                 System.out.printf("00%d is a Neon Number.",a);
             }
            else{
                 System.out.printf("000%d is not a Neon Number.",a);
             }
        }
        else{
            System.out.println("Invalid Input");
            
        }

    }
}
