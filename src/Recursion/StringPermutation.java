package Recursion;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

	public static void main(String[] args) {
		
		String str = "abc";
		
		System.out.println(stringPermutation(str));
	}
	
	
//	public static List<String> stringPermutation(String str) {
//		
//		List<String> ans = new ArrayList<>();
//		int index = 0;
//		char[] charArr = str.toCharArray();
//		solve(charArr,ans,index);
//		return ans;
//	}
//	
//	public static void solve(char[] charArr, List<String> ans, int index) {
//		
//		// base case
//		if(index >= charArr.length) {
//			ans.add(new String(charArr));
//			return;
//		}
//		
//		for(int j=index; j<charArr.length; j++) {
//			
//			swap(charArr, j,index);
//			solve(charArr,ans,index+1);
//			// backtrack
//			swap(charArr,j,index);
//		
//		}
//	}
//	
//	
//	public static void swap(char[] charArr, int j, int index) {
//		
//		char temp = charArr[index];
//		charArr[index] = charArr[j];
//		charArr[j] = charArr[index];
//	}
	
	public static List<String> stringPermutation(String str) {
	    List<String> ans = new ArrayList<>();
	    char[] chars = str.toCharArray(); // Convert string to char array for easy manipulation
	    solve(chars, ans, 0);
	    return ans;
	}

	public static void solve(char[] chars, List<String> ans, int index) {
	    // Base case: when index reaches the end, add the permutation to the result
	    if (index == chars.length) {
	        ans.add(new String(chars)); // Convert char array back to string
	        return; // Return to avoid further recursion
	    }

	    // Recursively swap each character and generate permutations
	    for (int j = index; j < chars.length; j++) {
	        swap(chars, j, index); // Swap characters
	        solve(chars, ans, index + 1); // Recursively solve for the next index
	        swap(chars, j, index); // Backtrack by swapping the characters back
	    }
	}

	// Helper function to swap characters in the char array
	private static void swap(char[] chars, int i, int j) {
	    char temp = chars[i];
	    chars[i] = chars[j];
	    chars[j] = temp;
	}

}
