Question: Left Triangle Pattern

Program:

import java.util.*;

public class LeftTrianglePattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = sc.nextInt();
         for (int i = 1; i <= row; i++) {
            for (int j = i; j < row; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();    
         }
     }
}

