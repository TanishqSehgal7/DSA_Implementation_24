package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SubSetsOfAnArray {

	
	public static List<List<Integer>> makeSubSetsOfAnArray(int arr[]) {
		
		List<List<Integer>> subsets = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		int index = 0;		
		solve(arr, subsets, list, index);

		return subsets;	
	}
	
	public static void solve(int arr[], List<List<Integer>> subsets, List<Integer> list, int index){
		
		// base case
		if(index >= arr.length) {
			subsets.add(new ArrayList<>(list));
			return;
		}
		
		// exclude call
		solve(arr, subsets, list, index+1);
		
		// include call
		int element = arr[index];
		list.add(element);
		solve(arr,subsets,list,index+1);
		
		// here we remove the last added element from the list to avoid repetition by back tracking
		list.remove(list.size()-1);
	}
	
	public static void main(String[] args) {
		
		int arr[] = {1,2,3};
		List<List<Integer>> subsets = makeSubSetsOfAnArray(arr);
		
		for(List<Integer> list: subsets) {
			System.out.print(list + " ");
		}
	}
}
