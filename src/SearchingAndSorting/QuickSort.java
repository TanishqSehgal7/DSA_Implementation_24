package SearchingAndSorting;

public class QuickSort {
	
	public static void quickSort(int arr[], int s, int e) {
		
		// base case
		if(s >= e) {
			return;
		}
		
		// find partition index
		
		int p = partition(arr, s,e);
		
		// quickSort call for left part
		quickSort(arr, s, p - 1);
		
		// quickSort call for right part
		quickSort(arr, p + 1, e);
		
	}
	
	
	public static int partition(int arr[], int s, int e) {
		
		// initialize pivot as first array element by default\
		int pivot = arr[s];
		
		int count = 0;
		
		// count number of elements less the pivot  in each sub array from s to e
		for(int i=s;i<=e;i++) {
			
			if(arr[i] < pivot) {
				count++;
			}
		}
		
		// find pivot index
		int pivotIndex = s + count;
		swap(arr, s, pivotIndex);
		
		int i = s;
		int j = e;
		
		while(i < pivotIndex && j > pivotIndex) {
			
			while(arr[i] < pivot) {
				i++;
			}
			
			while(arr[j] > pivot) {
				j--;
			}
			
			if(i < pivotIndex && j > pivotIndex) {
				swap(arr, i, j);
			}
		}
		
		return pivotIndex;
	}
	
	public static void swap(int arr[], int idx1, int idx2) {
		
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {3,5,1,8,2,4};
		
		quickSort(arr,0,arr.length-1);
		
		for(int element: arr) {
			System.out.print(element + " ");
		}
		
	}
}
