package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SubArraysQuestions {
	
	
	public static void printAllSubArrays(int arr[]) {
		
		
		for(int i = 0; i<arr.length-1; i++) {
			for(int j = i; j<arr.length; j++) {
				for(int k = i; k<=j; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println("\n");
			}
		}
		
	}
	
	
	public static void subArrayWithTargetSum(int arr[], int sum) {
		
		int start = 0; 
		int end = -1;
		int currentSum = 0;
		 
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i<arr.length; i++) {
			
			currentSum += arr[i];
			
			if(currentSum - sum == 0) {
				start = 0;
				end = i;
			}
			
			if(map.containsKey(currentSum - sum)) {
				start = map.get(currentSum - sum) + 1;
				end = i;
			}
			
			map.put(currentSum, i);
		}
		
		if(end == -1) {
			System.out.println("SubArray with target sum Not Found!");
		} else {
			
			System.out.println("Sub Array with Target Sum is: ");
			
			for(int i = start; i<=end; i++) {
				System.out.println(arr[i]);
			}
		}
	}
	

	public static void main(String[] args) {
		
		int arr[] = {10,15,-5, 15, 10, 5};
		
		printAllSubArrays(arr);
		
		subArrayWithTargetSum(arr, 5);

	}

}
