package Recursion;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutations {

	public static void main(String[] args) {
	
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		System.out.println(arrayPermutations(arr));
	}
	
	public static List<List<Integer>> arrayPermutations(List<Integer> arr) {
		
		List<List<Integer>> ans = new ArrayList<>();
		int index = 0;
		solve(arr,ans,index);
		return ans;
	}
	
	
	public static void solve(List<Integer> arr, List<List<Integer>> ans, int index) {
		
		if(index >= arr.size()) {
			ans.add(new ArrayList<>(arr));
			return;
		}
		
		for(int j = index; j<arr.size(); j++) {
			swap(arr, j, index);
			solve(arr,ans,index + 1);
			swap(arr, j, index);
		}
	}
	
	public static void swap(List<Integer> arr, int j, int index) {
		
		int temp = arr.get(index);
		arr.set(index, arr.get(j));
		arr.set(j, temp);
	}
}
