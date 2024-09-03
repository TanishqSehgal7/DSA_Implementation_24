package SearchingAndSorting;

public class BubbleSort {
	
	
	public static int[] bubbleSort(int arr[]) {
		
		
		for(int i = 0; i<arr.length; i++) { // for n-1 rounds
			
			for(int j = 0; j<arr.length-i-1;j++) { 
				
				/* arr.length - i - 1 is done because already sorted part
				of the array is not to be checked
				*/
				
				if(arr[j] > arr[j+1]) {
					swap(arr, j , j+1);
				} else {
					continue;
				}
			}
			
		}
		return arr;
	}
	
	public static int[] bubbleSortOptimized(int arr[]) {
		
		for(int i=0; i<arr.length-1; i++) {
			
			boolean isSwapped = false;
			
			for(int j=0; j<arr.length-i-1;j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr,j,j+1);
					isSwapped = true;
				} else {
					continue;
				}
			}
			
			if(!isSwapped) {
				break;
			}
		}
		
		return arr;
	}
	
	public static void swap(int[] arr, int j, int jPlsOne) {
		
		int temp = arr[j];
		arr[j] = arr[jPlsOne];
		arr[jPlsOne] = temp;
	}
	

	public static void main(String[] args) {
		
		
		int arr[] = {10,1,7,6,14,9};
		
		arr = bubbleSort(arr);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println("\n");
		
		int arr2[] = {10,22,54,46,92,17,21};
		arr2 = bubbleSortOptimized(arr2);
		
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i] + " ");
		}
		
	}

}
