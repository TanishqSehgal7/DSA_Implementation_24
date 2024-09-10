package SearchingAndSorting;

public class BinarySearch {
	
	public static int binarySearch(int arr[], int x, int s, int e) {
		
		int mid = 0;
		
		while(s <= e) {
			
			mid = s + (e-s)/2;
			
			if(x > arr[mid]) { // check the right part
				s = mid + 1;
			} else {
				e = mid - 1;
			}
			
			if(arr[mid] == x)
				return mid;
		}
		
		if(arr[mid] == x)
			return mid;
		else
			return -1;
	}
	
	
	public static int binarySearchReverseSorted(int arr[], int x, int s, int e) {
		
		int mid = 0;
		
		while(s <= e) {
			
			mid = s + (e-s)/2;
			
			if(arr[mid] == x)
				return mid;
			
			if(x > arr[mid]) { // check the left part
				e = mid - 1;
			} else { // check the right part
				s = mid + 1;
			}
			
			if(arr[mid] == x)
				return mid;
		}
		
		if(arr[mid] == x)
			return mid;
		else
			return -1;
	}
	
	
	public static int firstOccurance(int arr[], int x, int s, int e) {
		
		// since we have to find the firstOccurance, so we should check in the left part of the array
		
		int mid = 0;
		int ans = -1;
		
		while(s <= e) {
			
			mid = s + (e-s)/2;
			
			if(arr[mid] == x) {
				ans = mid;
				e = mid - 1;
			}
			
			if(x > arr[mid]) {
				s = mid + 1;
			}
			
			if(x < arr[mid]) {
				e = mid - 1;
			}
			
		}
		return ans;
	}
	
	
	public static int lastOccurance(int arr[], int x, int s, int e) {
		
		int ans = -1;
		int mid = 0;
		
		while(s <= e) {
		
			// since we have to check the last occurance therefore we should check the right part of the array
			
			mid = s + (e-s)/2;
			
			if(x == arr[mid]) {
				ans = mid;
				s = mid + 1;
			}
			
			if(x > arr[mid]) {
				s = mid + 1;
			}
			
			if(x < arr[mid]) {
				e = mid - 1;
			}
		}
		
		return ans;
	}
	
	public static int findPeakElementInMountainArray(int arr[]) {
		
		int s = 0; 
		int e = arr.length-1;
		
		// calculate mid
		int mid = s + (e-s)/2;
		
		while(s < e) { // we only keep checking for peak till s!=e
			
			mid = s + (e-s)/2;
			
			if(arr[mid] > arr[mid+1]) { // if element at mid > mid+1 this means that mid could be potentially the peak
				e = mid;
			} else {
				s = mid+1;
			}
		}
		return s;
	}
	
	
	public static int findPivotInSortedRotatedArray(int arr[]) {
		
		int s = 0; int e = arr.length-1;
		
		int mid = 0;
		
		while(s < e) {
			
			mid = s + (e-s)/2;
			
			if(arr[mid] > arr[0]) {
				s = mid + 1;
			} else {
				e = mid;
			}
		}
		return s;
	}
	
	public static int searchInRotatedSortedArray(int arr[], int x) {
		
		int pivotIndex = findPivotInSortedRotatedArray(arr);
		
		int ans = -1;
		System.out.println("Pivot Index: " + pivotIndex);
		if(x >= arr[pivotIndex] && x <= arr[arr.length-1]) {
			ans = binarySearch(arr, x,  pivotIndex,  arr.length-1);
		} else if(pivotIndex == 0) {
			ans = binarySearchReverseSorted(arr, x, pivotIndex, arr.length-1);
		}
		else {
			ans = binarySearch(arr, x, 0, pivotIndex-1);
		}
		
		return ans;
	}
	
	public static long findSquareRootInteger(int x) {
		
		long s = 0; long e = x;
		
		long mid = s + (e-s)/2;
		long ans = -1;
		while(s<=e) {
			
			if(Math.pow(mid,2) == x) {
				return mid;
			}
			
			if(Math.pow(mid,2) > x) {
				e = mid - 1;
			} else if(Math.pow(mid,2) < x) {
				ans = mid;
				s = mid + 1;
			}
			
			mid = s + (e-s)/2;
		}
		
		return ans;
	}
	
	public static double findSquareRootWithPrecision(int x, long integerPart, int precisionCount) {
		
		
		double factor = 1;
		
		double ans = integerPart;
		
		for(int i = 0; i<precisionCount; i++) {
			
			factor = factor/10;
			
			for(double j =integerPart; j*j<x; j+=factor) {
				ans = j;
			}
		}
		
		return ans;
	}
 	
	
	public static void main(String[] args) {
		
		int arr1[] = {1,3,5,7,9,11,13,15,17,19,21};
		int k1 = 19;
		System.out.println("Element " + k1 + " found at position: " + binarySearch(arr1, k1, 0, arr1.length-1));
		
		System.out.println("\n");
		
		int arr2[] = {21,19,17,15,13,11,9,7,5,3,1};
		int k2 = 11;
		System.out.println("Element " + k2 + " found at position: " + binarySearchReverseSorted(arr2, k2, 0, arr2.length-1));
		
		System.out.println("\n");
		
		int arr3[] = {1,2,3,3,5};
		int k3 = 3;
		System.out.println("First Occurance of " + k3 + " is at index: " + firstOccurance(arr3,k3,0,arr3.length-1));
		System.out.println("First Occurance of " + k3 + " is at index: " + lastOccurance(arr3,k3,0,arr3.length-1));
		
		System.out.println("\n");
		
		int mountainArray[] = {4,5,6,7,3,2,1};
		System.out.println("Peak element in the mountain array is: " + mountainArray[findPeakElementInMountainArray(mountainArray)]);
		
		System.out.println("\n");
		
		int rotatedSorted[] = {7,9,1,2,3};
		int k4 = 9;
		int k5 = 2;
		int pivot = rotatedSorted[findPivotInSortedRotatedArray(rotatedSorted)];
		System.out.println("Pivot Element in the Rotated Sorted Array is: " + pivot);
		System.out.println("Element " + k4 + " is found at index: " + searchInRotatedSortedArray(rotatedSorted,k4));
		System.out.println("Element " + k5 + " is found at index: " + searchInRotatedSortedArray(rotatedSorted,k5));
		
		System.out.println("\n");
		
		int x = 10;
		long integerPartOfSqRoot = findSquareRootInteger(x);
		int precisionCount = 3;
		double precisionPartOfSqRoot = findSquareRootWithPrecision(x, integerPartOfSqRoot, precisionCount);
		System.out.println("Integer Square Root of " + x + " is: " + integerPartOfSqRoot);
		System.out.println("Precise Square Root of " + x + " is: " + precisionPartOfSqRoot);
	}
}
