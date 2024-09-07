package SearchingAndSorting;

public class BinarySearch {
	
	
	public static int binarySearchSorted(int arr[], int x, int s, int e) {
		
		
		while(s!=e) {
			
			// calculate mid
			int mid = s + (e-s)/2;
			
			if(arr[mid] > x) { // x exists in the left part of the array
				e = mid-1;
			} else if(arr[mid] < x) { // x exists in the right part of the array
				s = mid+1;
			}
			
			if(arr[mid] == x) {
				return mid+1;
			}
		}
		
		return -1;
	}
	
	
	public static int binarySearchReverseSorted(int arr[], int x, int s, int e) {
		
		
		while(s!=e) {
			
			// calculate mid
			int mid = s + (e-s)/2;
			
			if(arr[mid] > x) { // x exists in the right part of the array
				s = mid + 1;
			} else if(arr[mid] < x) { // x exists in the left part of the array
				e = mid - 1;
			}
			
			if(arr[mid] == x) {
				return mid+1;
			}
		}
		
		return -1;
	}
	
	// single code for handling both monotonically increasing and monotonically decreasing functions
	
	public static int binarySearch(int arr[], int x, int s, int e) {
		
		boolean isIncreasing = arr[s] < arr[e];
		
		while(s!=e) {
			
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

	}

}
