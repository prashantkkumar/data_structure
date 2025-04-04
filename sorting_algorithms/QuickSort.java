

import java.util.*;
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted elements in ascending order:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
	}
	
	 public static void quickSort(int[] arr, int low, int high) {
	        if (low < high) {
	            int pivotIndex = partition(arr, low, high);

	            quickSort(arr, low, pivotIndex - 1);  
	            quickSort(arr, pivotIndex + 1, high); 
	        }
	    }

	    
	    public static int partition(int[] arr, int low, int high) {
	        int pivot = arr[high]; 
	        int i = low - 1;

	        for (int j = low; j < high; j++) {
	            if (arr[j] < pivot) {
	                i++;
	                swap(arr, i, j);
	            }
	        }

	       
	        swap(arr, i + 1, high);
	        return i + 1;
	    }

	   
	    public static void swap(int[] arr, int a, int b) {
	        int temp = arr[a];
	        arr[a] = arr[b];
	        arr[b] = temp;
	    }

}
