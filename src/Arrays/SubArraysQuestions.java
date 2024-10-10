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
				break;
			}
			
			if(map.containsKey(currentSum - sum)) {
				start = map.get(currentSum - sum) + 1;
				end = i;
				break;
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
	
	
	public static void longestSubArrayWithTargetSum(int arr[], int sum) {
		
		int start = 0;
		int end = -1;
		int currentSum = 0;
		int maxLength = (end-start) + 1;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i<arr.length; i++) {
			
			currentSum += arr[i];
			
			if(currentSum - sum == 0) {
				start = 0;
				end = i;
				maxLength = (end-start) + 1;
			}
			
			if(map.containsKey(currentSum - sum)) {
				start = map.get(currentSum-sum) + 1;
				end = i;
				maxLength = Math.max(maxLength, (end-start) + 1);
			} else {
				map.put(currentSum, i);
			}
		}
		
		if(end == -1) {
			System.out.println("SubArray with target sum Not Found!");
			return;
		}
		
		if(maxLength == ((end-start) + 1)) {
			
			System.out.println("Longest Sub Array with Target Sum is: ");
			
			for(int i = start; i<=end; i++) {
				System.out.print(arr[i] + " ");
			}
		}
		
	}
	
	
	public static void findAllSubArraysWithTargetSum(int arr[], int sum) {
		
		int start = 0;
		int end = -1;
		int currentSum = 0;
		List<List<Integer>> allSubArrays = new ArrayList<>();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i<arr.length; i++) {
			
			currentSum += arr[i];
			
			if(currentSum - sum == 0) {
				start = 0;
				end = i;
				List<Integer> subArray = new ArrayList<>();
				int idx = start;
				while(idx<=end) {
					subArray.add(arr[idx]);
					idx++;
				}
				
				allSubArrays.add(subArray);
			}
			
			if(map.containsKey(currentSum-sum)) {
				start = map.get(currentSum - sum) + 1;
				end = i;
				List<Integer> subArray = new ArrayList<>();
				int idx = start;
				while(idx<=end) {
					subArray.add(arr[idx]);
					idx++;
				}
				allSubArrays.add(subArray);
			}
			
			map.put(currentSum, i);
		}
		
		if(end == -1) {
			System.out.println("SubArray with target sum Not Found!");
			return;
		} else {
			System.out.println("All sub arrays with target sum are");
			
			for(List<Integer> subArray: allSubArrays) {
				System.out.println(subArray);
			}
		}
	}
	
	public static void largestSumSubArrayKadaneAlgo(int arr[]) {
		
		int start = 0;
		int tempStart = 0;
		int end = -1;
		int currentSum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		for(int i = 0; i<arr.length; i++) {
			
			currentSum += arr[i];
			
			if(currentSum > maxSum) {
				maxSum = currentSum;
				start = tempStart;
				end = i;
			}
			
			if(currentSum < 0) {
				currentSum = 0;
				tempStart = i + 1;
			}
		}
		
		if(maxSum == Integer.MIN_VALUE) {
			System.out.println("No valid subarray found.");
		} else { 
			System.out.println("The largest sum subarray is:");
	        for (int i = start; i <= end; i++) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println("\nMaximum sum: " + maxSum);
		}
		
	}
	
	
	public static void subArrayWithEqualZerosAndOnes(int arr[]) {
		
		int start = 0;
		int end = -1;
		int currentSum = 0;
		int tempStart = 0;
		int maxLength = (end - start) + 1;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == 0) {
				arr[i] = -1;
			}
		}
		
		for(int i = 0; i<arr.length; i++) {
			
			currentSum += arr[i];
			
			if(currentSum == 0) {
				start = tempStart;
				end = i;
				maxLength = (end-start) + 1;
			}
			
			if(map.containsKey(currentSum)) {
				start = map.get(currentSum) + 1;
				end = i;
				maxLength = (end-start) + 1;
			} else {
				map.put(currentSum, i);
			}
		}
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == -1) {
				arr[i] = 0;
			}
		}
		
		if(maxLength != (end-start)+1) {
			System.out.println("No such subArray found!");
			return;
		} else {
			System.out.println("SubArray containing equal number of 1's and 0's is:\n");
			System.out.println("Start: " + start);
			System.out.println("End: " + end);
			List<Integer> subArr = new ArrayList<>();
			for(int i = start; i<=end; i++) {
				subArr.add(arr[i]);
			}
			
			System.out.println(subArr);
		}	
	}
	

	public static void main(String[] args) {
		
		int arr[] = {10,15,-5, 15, 10, 5};
		
		printAllSubArrays(arr);
		System.out.println("\n");
		subArrayWithTargetSum(arr, 5);
		System.out.println("\n");
		longestSubArrayWithTargetSum(arr,0);
		System.out.println("\n");
		findAllSubArraysWithTargetSum(arr,20);
		System.out.println("\n");
		largestSumSubArrayKadaneAlgo(arr);
		
		int arr2[] = {1,1,0,1,1,0,0};
		
		subArrayWithEqualZerosAndOnes(arr2);

	}

}
