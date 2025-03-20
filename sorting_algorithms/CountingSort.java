

import java.util.*;
public class CountingSort {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        System.out.print("Enter the number of elements: ");
	        int n = sc.nextInt();

	        int arr[] = new int[n];
	        System.out.println("Enter the elements:");
	        for (int i = 0; i < n; i++) {
	            arr[i] = sc.nextInt();
	        }

	        countingSort(arr);

	        System.out.println("Sorted elements in ascending order:");
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }

	}
	
	
	public static void countingSort(int[] arr) {
        int n = arr.length;

        
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

       
        int[] count = new int[max + 1];

        
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

}
