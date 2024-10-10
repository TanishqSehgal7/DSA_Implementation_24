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
	
	
	public static void main(String[] args) {
		
		int arr[] = {8,5,3,10,7,4,1};
		
		largestElement(arr);		
	}

}
