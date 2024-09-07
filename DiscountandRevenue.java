Question:

Revenue can be calculated as the selling price of the product times the quantity sold,

i.e. revenue = price × quantity. 
Write a program that asks the user to enter product price and quantity and then calculate the revenue. If the revenue is more than 5000 a discount is 10% offered. Program should display the discount and net revenue.

Sample Input :
2000
45

Sample Output :
The discount is Rs.9000.00
The net revenue is Rs.81000.00

Sample Input 1
3000
2

Sample Output 1
The discount is Rs.600.00
The net revenue is Rs.5400.00

Program:

import java.util.*;

public class DiscountandRevenue {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the price of the product: ");
        double price = sc.nextDouble();
        System.out.print("Enter the quantity sold: ");
        int quantity = sc.nextInt();
        double revenue = price * quantity;
        double discount = 0.0;
        if (revenue > 5000) {
            discount = revenue * 0.10; // 10% discount
        }
        double netRevenue = revenue - discount;
        System.out.printf("The discount is Rs.%.2f%n", discount);
        System.out.printf("The net revenue is Rs.%.2f%n", netRevenue);
    }
}