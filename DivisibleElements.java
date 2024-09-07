Question:
Write a program to create a new array from a given array with the elements divisible by a specific number and count the number of elements divisible by a specific number in an array and find the sum of value divisible by a specific number in an array .

Sample Input :
6
23 45 11 20 12 17
5

Sample Output :

The elements that are divisible by 5 is 45 20
The Count of the value that is divisible by 5 is 2
The Sum of value that is divisible by 5 is 65

Program:

import java.util.*;
public class DivisibleElements {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int count =0;
	        int sum =0;
	        int a= sc.nextInt();
	        int[] arr = new int[a];
	        for(int i=0;i<a;i++){
	            arr[i]=sc.nextInt();
	        }
	        int b= sc.nextInt();
	        System.out.printf("The elements that are divisible by %d is ",b);
	        for(int i=0;i<a;i++){
	            if(arr[i]%b==0){
	                System.out.printf("%d ", arr[i]);
	                count= count+1;
	                sum = sum+arr[i];
	                
	        }
	        }
	        System.out.printf("\nThe Count of the value that is divisible by %d is %d",b,count);
	        System.out.printf("\nThe Sum of value that is divisible by %d is %d",b,sum);
	}

}