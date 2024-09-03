package SearchingAndSorting;

public class SelectionSort {

	
	public static int[] selectionSort(int arr[]) {
		
	
		for(int i=0; i<arr.length -1; i++) {
			
			int minIdx = i;
			
			for(int j = i+1 ; j<arr.length; j++) {
				if(arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			
			swapElementsAtArrIdx(arr, minIdx, i);
		}
		
		return arr;
	}
	
	
	public static int[] swapElementsAtArrIdx(int arr[], int minIdx, int i) {
		
		int temp = arr[minIdx];
		arr[minIdx] = arr[i];
		arr[i] = temp;
		return arr;
	}
	
	
	public static void main(String[] args) {
		
		int arr[] = {64,25,11,22,12};
		
		arr = selectionSort(arr);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		

	}

}
