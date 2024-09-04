package SearchingAndSorting;

public class InsertionSort {

	public static int[] insertionSort(int arr[]) {
		
		for(int i=1;i<arr.length;i++) { // for number of rounds
			
			int temp = arr[i]; // save element to be compared in a variable
			int j = i-1; // we start comparing from j=i-1 down to 0
			
			for(; j>=0; j--) {
				
				if(arr[j] > temp) {
					arr[j+1] = arr[j]; 
					/* shift all elements towards right since temp goes towards 
					 	left of all elements which are greater than temp
					 */
				} else {
					break; // because in this case element is already in sorted so we break 
				}
			}
			
			/*
				now correct position of temp is to the right of 
				element < temp and left of element > temp
			*/
			
			arr[j+1] = temp;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		
		
		int arr[] = {10,1,7,4,8,2};
		
		arr = insertionSort(arr);
		
		for(int element : arr) {
			System.out.print(element + " ");
		}
	}

}
