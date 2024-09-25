package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PhoneKeypadProblem {

	
	
	public static List<String> phoneKeypasCombinations(String digits) {
		
		List<String> ans = new ArrayList<>();
		String output = "";
		int index = 0;
		
		String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		solve(digits,output,index,ans,map);
		
		return ans;
	}
	
	public static void solve(String digits, String output, int index, List<String> ans, String[] map) {
		
		// base case
		if(index >= digits.length()) {
			ans.add(output);
		}
		
		
		int digit = digits.charAt(index) - '0';
		
		String value = map[digit];
		
		for(int i=0; i<value.length(); i++) {
			String valuetoBeAdded = Character.toString(value.charAt(i));
			output+=valuetoBeAdded;
			solve(digits,output,index+1, ans, map);
			// backtrack the last added character
			output = output.substring(0, output.length()-1);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		String digits = "34";
		List<String> combinations = phoneKeypasCombinations(digits);
		
		System.out.println(combinations);
		
	}

}
