Question:

if the string is "Hello Technologies", the numeric PIN will be 8.

Explanation:

Length of the word "Hello" = 5

Length of the word "Technologies" = 12

Let us add all the lengths to get the Total Length = 5+12=17

Therefore, the single-digit numeric PIN = 8


Program:

import java.util.*;
public class WordCount{

    public static void main(String[] args) {

        String input = "Hello Technologies";
        String[] words = input.split(" ");
        int totalLength = 0;
        for (String word : words) {
            totalLength += word.length();
        }
        int pin = SingleDigit(totalLength);
        System.out.println("The numeric PIN is: " + pin);
    }

     public static int SingleDigit(int number) {
        while (number >= 10) {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            number = sum;
        }

        return number;
    }
}
