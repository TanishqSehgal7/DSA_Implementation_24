package SearchingAndSorting;

import java.util.Arrays;

public class BookAllocationWithBinarySearch {
	
	public static int allocateBooks(int arr[], int m) {
		
		int s = 0;
		int sum = 0;
		
		for(int element: arr) {
			sum+=element;
		}
		
		int e = sum;
		int ans = -1;
		int mid = s + (e-s)/2;
		
		while(s<=e) {	
			if(isPossible(arr,m,mid)) {
				ans = mid;
				e = mid - 1;
			} else {
				s = mid + 1;
			}
			mid = s + (e-s)/2;
		}	
		return ans;
	}
	
	public static boolean isPossible(int arr[], int m, int mid) {
		
		int studentCount = 1; int pageSum = 0;
		
		for(int i=0; i<arr.length; i++) {

			if(pageSum + arr[i] <= mid) {
				pageSum += arr[i];
			} else {
				studentCount++;
				if(studentCount > m || arr[i] > mid) {
					return false;
				}
				pageSum = 0;
				pageSum += arr[i];
			}
		}	
		return true;
	}
	
	public static boolean isPossible2(int arr[], int m, int mid) {
        
		int studentCount = 1;  // Start with the first student
        int pageSum = 0;
        
        // Allocate books to students
        for (int i = 0; i < arr.length; i++) {
            // Check if current book can be added without exceeding `mid`
            if (pageSum + arr[i] <= mid) {
                pageSum += arr[i];
            } else {
                // Allocate to next student
                studentCount++;
                // If students exceed limit or current book exceeds mid, return false
                if (studentCount > m || arr[i] > mid) {
                    return false;
                }
                // Start counting pages for the new student
                pageSum = arr[i];
            }
        }
        return true; // All books allocated successfully
	}
	
	public static int paintBlocks(int blocks[], int k) {
		
		int s = 0; int sum = 0;
		
		for(int element : blocks) {
			sum += element;
		}
		
		int e = sum;
		int mid = s + (e-s)/2;
		int ans = -1;
		
		while(s<=e) {
			
			if(isBlockAllocationPossible(blocks, k, mid)) {
				ans = mid;
				e = mid - 1;
			} else {
				s = mid + 1;
			}	
			
			mid = s + (e-s)/2;
		}
		
		return ans;
	}
	
	public static boolean isBlockAllocationPossible(int blocks[], int k, int mid) {
		
		int painterCount = 0; int blockSum = 0;
		
		for(int i=0; i<blocks.length; i++) {
			
			if(blockSum + blocks[i] <= mid) {
				blockSum += blocks[i];
			} else {
				painterCount++;
				if(painterCount > k || blocks[i] > mid) {
					return false;
				}
				blockSum = 0;
				blockSum = blocks[i];
			}
		}
		
		return true;
	}
	
	public static int aggresiveCows(int stalls[], int k) {
		
		 Arrays.sort(stalls);
		 
		 int s = 0;
		 int max = -1;
		 
		 for(int element : stalls) {
			 max = Math.max(max, element);
		 }
		 
		 int e = max;
		 int ans = -1;
		 
		 int mid = s + (e-s)/2;
		 
		 while(s<=e) {
			 
			 if(isPossibleSol(stalls,k,mid)) {
				 ans = mid;
				 s = mid + 1;
			 } else {
				 e = mid - 1;
			 }
			 
			 mid = s + (e-s)/2;
		 }
		 return ans;
	}
	
	public static boolean isPossibleSol(int stalls[], int k, int mid) {
		
		int cowCount = 1; int start = stalls[0];
		
		for(int i=0; i<stalls.length; i++) {
			
			if(stalls[i] - start >= mid) {
				cowCount++;
				if(cowCount == k) {
					return true;
				}
				start = stalls[i];
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		int books[] = {10,20,30,40};
		int m = 2;
		
		int blocks[] = {5,5,5,5};
		int k = 2;
		
		int stalls[] = {4,2,1,3,6};
		int c = 2;
		
		System.out.println(allocateBooks(books,m));
		
		System.out.println(paintBlocks(blocks,k));
		
		System.out.println(aggresiveCows(stalls,c));
	}
}
