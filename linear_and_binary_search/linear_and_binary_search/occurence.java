//Given a sorted array and a target element, write a program that uses Binary Search to find the first and last occurrence of the target element in the array. If the element is not found, return -1.

import java.util.*;
public class occurence {
    public static void main(String[] args) {
        int[] sortedArray = {2, 4, 4, 4, 6, 8, 10};
        int target = 4;

        int firstIndex = findFirstOccurrence(sortedArray, target);
        int lastIndex = findLastOccurrence(sortedArray, target);

        System.out.println("First occurrence of " + target + " is at index: " + firstIndex);
        System.out.println("Last occurrence of " + target + " is at index: " + lastIndex);
    }

    // to find firstOccurence
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid; // Potential answer found
                right = mid - 1; // Continue searching in the left half
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // to find last occurence
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid; // Potential answer found
                left = mid + 1; // Continue searching in the right half
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

}
