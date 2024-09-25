package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceOfString {

	
	public static List<String> subSequencesOfString(String str) {
		
		List<String> list = new ArrayList<>();
		String ans = "";
		int index = 0;
		solve(str, list, ans, index);
		
		return list;
	}
	
	
	public static void solve(String str, List<String> list, String ans, int index) {
		
		// base case 
		if(index >= str.length()) {
			if(ans.length()>0) 
				list.add(ans);
			return;
		}
		
		// exclude call
		solve(str, list, ans, index+1);
		
		// include call
		char ch = str.charAt(index);
		ans+=ch;
		solve(str,list,ans,index+1);
		
		ans = "";
	}
	
	
	public static void main(String[] args) {
		
		String str = "abc";
		
		List<String> subSequence = subSequencesOfString(str);
		
		System.out.println(subSequence);

	}

}
