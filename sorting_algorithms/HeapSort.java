
import java.util.*;
public class HeapSort {

	public static void main(String[] args) {
//		heap sort
		 Scanner sc = new Scanner(System.in);
	        System.out.print("Enter the number of elements: ");
	        int n = sc.nextInt();

	        int arr[] = new int[n];
	        System.out.println("Enter the elements:");
	        for (int i = 0; i < n; i++) {
	            arr[i] = sc.nextInt();
	        }

	        heapSort(arr);

	        System.out.println("Sorted elements in ascending order:");
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }

	}
	
	 public static void heapSort(int[] arr) {
	        int n = arr.length;

	        // Build a max heap
	        for (int i = n / 2 - 1; i >= 0; i--) {
	            heapify(arr, n, i);
	        }

	        // Extract elements from the heap one by one
	        for (int i = n - 1; i > 0; i--) {
	            // Move current root to end
	            swap(arr, 0, i);

	            // Heapify the reduced heap
	            heapify(arr, i, 0);
	        }
	    }
	 
	 public static void heapify(int[] arr, int n, int i) {
	        int largest = i;          // Initialize largest as root
	        int left = 2 * i + 1;     // Left child
	        int right = 2 * i + 2;    // Right child

	        
	        if (left < n && arr[left] > arr[largest]) {
	            largest = left;
	        }

	       
	        if (right < n && arr[right] > arr[largest]) {
	            largest = right;
	        }

	        
	        if (largest != i) {
	            swap(arr, i, largest);

	           
	            heapify(arr, n, largest);
	        }
	    }
	 
	 public static void swap(int[] arr, int a, int b) {
	        int temp = arr[a];
	        arr[a] = arr[b];
	        arr[b] = temp;
	    }
	


}
