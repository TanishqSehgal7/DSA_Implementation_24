package Arrays;

public class ArraysQuestions {

	
	public static void largestElement(int arr[]) {
		
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		int smallest = Integer.MAX_VALUE;
		
		if (arr.length < 2) {
	        System.out.println("Array must have at least two elements");
	        return; // Handle case where there are fewer than 2 elements
	    }
		
		for(int i=0; i<arr.length; i++) {
			
			if(arr[i] > max) { // if another max is found then current max becomes the secondMax
				secondMax = max;
				max = arr[i];
			} else if(arr[i] > secondMax && arr[i] < max) { 
				secondMax = arr[i];
			} else if(arr[i] < smallest) {
				smallest = arr[i];
			}
			
		}
		
		if(max == Integer.MIN_VALUE || secondMax == Integer.MIN_VALUE) {
			System.out.println("Max Or Second Max does not exist or array contains single element");
		} else {
			System.out.println("Max Element isL " + max);
			System.out.println("Second Max Element is: " + secondMax);
			System.out.println("Smallest Element is: " + smallest);
		}
	}
	
	
	public static int rowWithMaxNumberOfOnes(int arr[][]) {
		
		int countOfOnes = 0;
		int maxCountOfOnes = Integer.MIN_VALUE;
		
		int s = 0;
		int e = arr.length -1;
		
		int mid = s + (e-s)/2;
		
		int row = 0;
		int ans = row;
		
		while(row < arr.length) {
			
			mid = s + (e-s)/2;
			countOfOnes = 0;
			
			if(arr[row][mid] == 1) {
				countOfOnes = (arr[0].length - mid);
				maxCountOfOnes = Math.max(maxCountOfOnes, countOfOnes);
				ans = row;
			}
			
			if(arr[row][mid] < 1) {
				s = mid -1;
			}
			row++;
		}
		
		return ans;
	}
	
	
	public static void main(String[] args) {
		
		int arr[] = {8,5,3,10,7,4,1};
		
		int arr2[][] = {{0,1,1,1}, {0,0,1,1}, {1,1,1,1}, {0,0,0,0}};
		
		int key = 1;
		
		largestElement(arr);
		
		System.out.println("\n");
		
		System.out.println(rowWithMaxNumberOfOnes(arr2));
	}

}
