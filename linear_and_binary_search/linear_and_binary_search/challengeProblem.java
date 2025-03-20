//You are given a list of integers. Write a program that uses Linear Search to find the first missing positive integer in the list and Binary Search to find the index of a given target number.

import java.util.Arrays;

public class challengeProblem {
 public static void main(String[] args) {
    int[] nums = {3, 4, -1, 1};
        int target = 4;

        int missingPositive = findFirstMissingPositive(nums.clone());
        System.out.println("The first missing positive integer is: " + missingPositive);

        Arrays.sort(nums);

        int index = binarySearch(nums, target);
        System.out.println("The index of target " + target + " is: " + index);
 }  
 
 // to find first missing integer .
 public static int findFirstMissingPositive(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
        while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
            // Swap nums[i] with the number at its correct position
            int temp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = temp;
        }
    }

    // Find the first index where the value is not index + 1
    for (int i = 0; i < n; i++) {
        if (nums[i] != i + 1) {
            return i + 1;
        }
    }
    return n + 1;
}

// to perform binary serach
 public static int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return -1; 
}

}
