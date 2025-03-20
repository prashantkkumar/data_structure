//A peak element is an element that is greater than its neighbors. Write a program that performs Binary Search to find a peak element in an array. If there are multiple peak elements, return any one of them.
import java.util.*;
public class peakElement {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int peak = binarySearch(arr, 0, arr.length - 1);
        
        if (peak != -1) {
            System.out.println("Peak element found: " + peak );
        } else {
            System.out.println("No peak element found.");
        }
    }

    // Binary Search method to find a peak element
    public static int binarySearch(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0) {
            return -1; 
        } 
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPeak(arr, mid)) {  // Check if the current element is a peak
                return arr[mid];
            } 
            else if (mid > 0 && arr[mid] <= arr[mid - 1]) {  // Search left half
                right = mid - 1;
            } 
            else {  // Search right half
                left = mid + 1;
            }
        }
        return -1;
    }

    // Method to check if the current element is a peak
    public static boolean isPeak(int[] arr, int mid) {
        int n = arr.length;

        boolean leftCheck = (mid == 0 || arr[mid] > arr[mid - 1]); // No greater left neighbour
        boolean rightCheck = (mid == n - 1 || arr[mid] > arr[mid + 1]); // No greater right neighbour

        return leftCheck && rightCheck;
    }
}

