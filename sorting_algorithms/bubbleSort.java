
import java.util.*;



public class bubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//       sorting algo 
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number of students");
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		
		System.out.println("enter the number of students marks");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr,j,j+1);
				}
			}
		}
		
		
		System.out.print("sorting Marks are --> ");
		
		
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
	public static void swap(int arr[],int a,int b) {
		
		int t = arr[a];
		arr[a]= arr[b];
		arr[b] = t;
	}

}


