Question:
Write the program to replace all EVEN elements by 0 and Odd by 1 in One Dimensional Array.

Sample Input :
5
6 4 3 1 2

Sample Output :
Before Replacement of value 0 and 1:6 4 3 1 2
After Replacement of value 0 and 1:0 0 1 1 0

Program:

import java.util.*;

public class ReplaceEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Before Replacement of value 0 and 1: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            if (arr[i] % 2 == 0) {
                arr[i] = 0; 
            } else {
                arr[i] = 1; 
            }
        }

        System.out.print("After Replacement of value 0 and 1: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}