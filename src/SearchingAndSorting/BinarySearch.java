package SearchingAndSorting;

public class BinarySearch {
	
	
	public static int binarySearchSorted(int arr[], int x, int s, int e) {
		
		while(s <= e) {
			
			int mid = s + (e-s)/2;
			
			if(arr[mid] > x) { // x exists in the left part of the array
				e = mid-1;
			} else if(arr[mid] < x) { // x exists in the right part of the array
				s = mid+1;
			}
		}
		return -1;
	} 
	
	
	public static int binarySearchReverseSorted(int arr[], int x, int s, int e) {
		
		// calculate mid
		int mid = s + (e-s)/2;
		
		while(s <= e) {
			
			if(arr[mid] > x) { // x exists in the right part of the array
				s = mid + 1;
			} else if(arr[mid] < x) { // x exists in the left part of the array
				e = mid - 1;
			}
			
			mid = s + (e-s)/2;
		}
		
		if(arr[mid] == x) {
			return mid;
		} else {
			return -1;
		}
		
	}
	
	// single code for handling both monotonically increasing and monotonically decreasing functions
	public static int binarySearch(int arr[], int x, int s, int e) {
		
		boolean isIncreasing = arr[s] < arr[e];
		
		while(s <= e) {
			
			int mid = s + (e-s)/2;
			
			if(isIncreasing) {
				
				if(arr[mid] > x) {
					e = mid - 1;
				} else {
					s = mid + 1;
				}
 				
			} else {
				
				if(arr[mid] > x) {
					s = mid + 1;
				} else {
					e = mid - 1;
				}
			}
			
			if(arr[mid] == x) {
				return mid+1;
			}
			
		}
		
		return -1;
	}
	
	public static int firstOccurance(int arr[], int x, int s, int e) {
		
		int ans = -1;
		
		while(s<=e) {
			
			int mid = s + (e-s)/2;
			
			if(arr[mid] == x) {
				ans = mid;
				e = mid-1;
			}
			
			if(arr[mid] > x) { // move towards left part
				e = mid-1;
			}
			
			if(arr[mid] < x) { // move towards right part
				s = mid + 1;
			}
		}
		
		return ans;
	}
	
	
	public static int lastOccurance(int arr[], int x, int s, int e) {
		
		int ans = -1;
		
		while(s<=e) {
			
			int mid = s + (e-s)/2;
			
			if(arr[mid] == x) {
				ans = mid;
				s = mid + 1;
			}
			
			if(arr[mid] > x) {
				e = mid - 1;
			}
			
			if(arr[mid] < x) {
				s = mid + 1; 
			}
		}
		
		return ans;
	}
	
	public static int findPeakInMountainArray(int arr[]) {
	    
	    int s = 0;
	    int e = arr.length - 1;
	    
	    while (s < e) {
	        
	        int mid = s + (e - s) / 2;
	        
	        // Check if mid is in the decreasing part of the array
	        if (arr[mid] > arr[mid + 1]) {
	            e = mid; // Peak could be at mid or to the left
	        } else {
	            s = mid + 1; // Peak is to the right
	        }
	    }
	    
	    return s; // Peak index
	}
	
	public static int findPivot(int arr[]) { // linear complexity [o(n)]
		
		int totalSum = 0;
		
		for(int element :  arr) {
			totalSum += element;
		}
		
		int leftSum = 0;
		int rightSum = 0;
		
		// start from the first element of the array and return the index if the left and right sum are equal
		
		for(int i=0; i<arr.length; i++) {
			
			rightSum = totalSum - leftSum - arr[i];
			
			System.out.println("LeftSum: " + leftSum);
			System.out.println("RightSum: " + rightSum);
			
			if(leftSum ==  rightSum) {
				return i;
			}
			
			leftSum += arr[i];
		}
		
		return -1;
	}
	
	
	public static int findPivotInRotatedSortedArr(int arr[]) {
		
		int s = 0;
		int e = arr.length-1;
		
		while(s<e) {
			
			int mid = s + (e-s)/2;
			
			if(arr[mid] > arr[0]) {
				s = mid + 1;
			} else {
				e = mid;
			}
		}
		
		return s;
	}
	
	public static int binarySearchInArr(int arr[], int x, int s, int e) {
		
		// calculate mid
		int mid = s + (e-s)/2;
		
		while(s <= e) {
			
			if(arr[mid] > x) { // x exists in the left part of the array
				e = mid-1;
			} else if(arr[mid] < x) { // x exists in the right part of the array
				s = mid+1;
			}
			
			mid = s + (e-s)/2;
		}
		
		if(x == mid) {
			return mid;
		} else {
			return -1;
		}
	}
	
	public static int searchInRotatedSortedArray(int arr[], int x) {
		
		
		int pivotIndex = findPivotInRotatedSortedArr(arr);
		int ans = -1;
		System.out.println("Pivot Index: " + pivotIndex);
		
		if(x >= arr[pivotIndex] && x <= arr[arr.length-1]) {
			ans = binarySearchInArr(arr, x, pivotIndex, arr.length-1);
		} else {
			ans = binarySearchInArr(arr, x, 0, pivotIndex);
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		
		int arr1[] = {3,5,7,9,11,13,15,17,19,21};
		int k1 = 19;
		System.out.println("Element " + k1 + " found at position: " + binarySearchSorted(arr1, k1, 0, arr1.length-1));
		
		int k2 = 16;
		int arr2[] = {20,18,16,14,12,10,8,6,4,2};
		System.out.println("Element " + k2 + " found at position: " + binarySearchReverseSorted(arr2,k2, 0, arr2.length-1));
		
		
		System.out.println("Element " + k1 + " is found at position: " + binarySearch(arr1,k1,0,arr1.length-1));
		System.out.println("Element " + k2 + " is found at position: " + binarySearch(arr2,k2,0,arr2.length-1));
		
		
		int arr3[] = {1,2,4,4,4,4,4,4,6,7,7,8};
		int x = 4;
		System.out.println("Element " +  x + " has its first occurance at: " + firstOccurance(arr3, x, 0, arr3.length-1));
		System.out.println("Element " +  x + " has its first occurance at: " + lastOccurance(arr3, x, 0, arr3.length-1));
		
		int mountainArray[] = {3,5,6,4,3,2,1};
		int peak = mountainArray[findPeakInMountainArray(mountainArray)];
		System.out.println("Peak element is: " + peak);
		
		
		int arrWithPivot[] = {1,7,3,6,5,6};
		System.out.println(findPivot(arrWithPivot));
		
		int pivotInRotatedSortedArr[] = {1};
		System.out.println("Pivot in the Rotated Sorted Array is: " + pivotInRotatedSortedArr[findPivotInRotatedSortedArr(pivotInRotatedSortedArr)]);
		int key = 0;
		System.out.println(key + " is found at index: " + searchInRotatedSortedArray(pivotInRotatedSortedArr,key));
	}
}