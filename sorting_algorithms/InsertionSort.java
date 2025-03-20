

import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
//		insertion sort
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number of students");
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		
		System.out.println("enter the number of students marks");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		 for (int i = 1; i < n; i++) {
	            int key = arr[i];
	            int j = i - 1;

	            while (j >= 0 && arr[j] > key) {
	                arr[j + 1] = arr[j];
	                j--;
	            }

	            arr[j + 1] = key;
	        }

	        System.out.println("Sorted elements in ascending order:");
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }

	}

}
