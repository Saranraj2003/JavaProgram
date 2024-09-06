Question:

Smallest digit in input1 = 3521 is 1
Largest digit in input2 = 2452 is 5
Largest digit in input3 = 1352 is 5
input4 = 38
So, PIN = (1 * 5 * 5) + 38 = 63

PROGRAM:

import java.util.*;
public class GeneratePin {

    public static int findPIN(int input1, int input2, int input3, int input4) {
        int smallestInput1 = 0, largestInput2 = 0, largestInput3 = 0;


        if (input1 >= 1000 && input1 <= 9999) {
            int unitDigit1 = input1 % 10;
            int u1 = input1 / 10;
            int tenDigit1 = u1 % 10;
            int t1 = u1 / 10;
            int hundredDigit1 = t1 % 10;
            int thousandDigit1 = t1 / 10;

            int minimum1 = Math.min(unitDigit1, tenDigit1);
            int minimum2 = Math.min(hundredDigit1, thousandDigit1);
            smallestInput1 = Math.min(minimum1, minimum2);
        }

        if (input2 >= 1000 && input2 <= 9999) {
            int unitDigit2 = input2 % 10;
            int u2 = input2 / 10;
            int tenDigit2 = u2 % 10;
            int t2 = u2 / 10;
            int hundredDigit2 = t2 % 10;
            int thousandDigit2 = t2 / 10;

            int maximum1 = Math.max(unitDigit2, tenDigit2);
            int maximum2 = Math.max(hundredDigit2, thousandDigit2);
            largestInput2 = Math.max(maximum1, maximum2);
        }


        if (input3 >= 1000 && input3 <= 9999) {
            int unitDigit3 = input3 % 10;
            int u3 = input3 / 10;
            int tenDigit3 = u3 % 10;
            int t3 = u3 / 10;
            int hundredDigit3 = t3 % 10;
            int thousandDigit3 = t3 / 10;

            int maximum3 = Math.max(unitDigit3, tenDigit3);
            int maximum4 = Math.max(hundredDigit3, thousandDigit3);
            largestInput3 = Math.max(maximum3, maximum4);
        }
        int a = smallestInput1 * largestInput2 * largestInput3;
        int PIN = a + input4;

        return PIN;
    }

    public static void main(String[] args) {
        int input1 = 3521;
        int input2 = 2452;
        int input3 = 1352;
        int input4 = 38;

        int pin = findPIN(input1, input2, input3, input4);
        System.out.println("The PIN is: " + pin); 
    }
}
