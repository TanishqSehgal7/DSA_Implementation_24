package SearchingAndSorting;

public class MergeSort {

	
	public static void mergeSort(int arr[], int start, int end) {
		
		// base case
		if(start >= end) {
			return;
		}
		
		// find mid
		int mid = (start+end)/2;
		
		
		// left part of array from start to mid-1
		mergeSort(arr, start, mid);
		
		// right part of array from mid to end
		mergeSort(arr, mid+1, end);
		
		
		mergeTwoSortedArray(arr, start, end);
		
	}
	
	
	public static void mergeTwoSortedArray(int arr[], int start, int end) {
		
		
		int mid = (start + end)/2;
		
		// find lengths of two divided sub arrays
		int len1 = mid - start + 1;
		int len2 = end - mid;
		
		// make 2 arrays of len1 and len2 respectively
		int arr1[] = new int[len1];
		int arr2[] = new int[len2];
		
		int mainArrayIndex = start;
		
		// add elements in first half of the divided sub array to arr1
		for(int i=0;i<len1;i++) {
			arr1[i] = arr[mainArrayIndex++];
		}
		
		// add elements in second half of the divided sub array to arr2
		for(int i=0;i<len2;i++) {
			arr2[i] = arr[mainArrayIndex++];
		}
		
		// merge two sorted arrays
		
		int index1 = 0; int index2 = 0;
		
		mainArrayIndex = start;
		
		while(index1 < len1 && index2 < len2) {
			
			if(arr1[index1] < arr2[index2]) {
				arr[mainArrayIndex++] = arr1[index1++];
			} else {
				arr[mainArrayIndex++] = arr2[index2++];
			}
			
		}
		
		while(index1 < len1) {
			arr[mainArrayIndex++] = arr1[index1++];
		}
		
		while(index2 < len2) {
			arr[mainArrayIndex++] = arr2[index2++];
		}
	}
	
	
	public static void main(String[] args) {
		
		int arr[] = {38,27,43,3,9,82,10,3,5,3,7,98,12,15};
		
		mergeSort(arr, 0, arr.length-1);
		
		for(int element : arr) {
			System.out.print(element + " ");
		}
	}

}
