//You are given a 2D matrix where each row is sorted in ascending order, and the first element of each row is greater than the last element of the previous row. Write a program that performs Binary Search to find a target value in the matrix. If the value is found, return true. Otherwise, return false.
import java.util.*;

public class searchTarget {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target = 16;
        boolean result = searchMatrix(matrix, target);

        System.out.println("Target " + target + " found: " + result);
}


// to find element
public static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return false;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;
    int left = 0, right = rows * cols - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        int midElement = matrix[mid / cols][mid % cols];

        if (midElement == target) {
            return true; // Target found
        } else if (midElement < target) {
            left = mid + 1; // Search in the right half
        } else {
            right = mid - 1; // Search in the left half
        }
    }
    return false; // Target not found
}
}
