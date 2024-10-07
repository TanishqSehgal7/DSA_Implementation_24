package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RotateArrayByKPositions {
	
	
	public static int[] rotateByKPositions(int arr[], int k) {
		
		int i = 0;
		
		while(i<k) {
			
			int firstElement = arr[0];
			System.out.println(firstElement);
			
			for(int j=0; j<arr.length-1; j++) {
				System.out.println(arr[j] + " replaced with " + arr[j+1]);
				arr[j] = arr[j+1];
			}	
			arr[arr.length-1] = firstElement;
			i++;
		}
		return arr;
	}
	
	
	public static boolean checkSortedArray(int arr[]) {
		
		boolean isSorted = true;
		
		for(int i = 0; i<arr.length-1; i++) {
			if(arr[i] > arr[i+1]) {
				isSorted = false;
				return isSorted;
			}
		}
		return isSorted;
	}
	
	
	public static int[] removeDuplicateElements(int arr[]) {
		
		int j = 0;
		
		Arrays.sort(arr);
		
		for(int i=1; i<arr.length; i++) {
			
			if(arr[i] != arr[j]) { // elements at i and j are unique
				j++;
				arr[j] = arr[i];
			}
		}
		
		int result[] = Arrays.copyOfRange(arr, 0, j+1);
		
		return result;
	}
	
	
	public static void moveAllNegativeElementToStart(int arr[]) {
		
		int pos = 0;
		
		for(int i=1; i<arr.length && pos<arr.length; i++) {
			if(arr[pos] < 0) {
				pos++;
			} else if(arr[i] < 0) {
				int temp = arr[i];
				arr[i] = arr[pos];
				arr[pos] = temp;
				pos++;
			}
		}
	}
	
	
	public static List<Integer> moveDuplicatesToEnd(List<Integer> arr) {
        // LinkedHashMap to maintain insertion order
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        
        // Count frequency of each element
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> duplicates = new ArrayList<>();
        
        // Separate non-duplicates and duplicates
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            
            // If it's a duplicate (appears more than once), move to 'duplicates' list
            if (count > 1) {
                for (int i = 0; i < count; i++) {
                    duplicates.add(num);
                }
            } else {
                // Add non-duplicates directly to the result list
                result.add(num);
            }
        }
        
        // Add all duplicates at the end of the result
        result.addAll(duplicates);
        
        return result;
    }

	
	public static void main(String[] args) {
		
		int [] arr = {1,2,3,4,5,6,7};
		arr = rotateByKPositions(arr, 2);
		
		System.out.println("\n");
		
		for(int element:arr) {
			System.out.print(element + " ");
		}
		

		int [] arr2 = {4,2,5,6,7,2,3};
		
		System.out.println("\n" + checkSortedArray(arr2));
		
		int arr3[] = {2,5,3,5,7,2,2,5,1};
		
		arr3 = removeDuplicateElements(arr3);
		for(int element:arr3) {
			System.out.print(element + " ");
		}
		
		int arr4[] = {-1,3,4,5,-3,-4,6,7};
		moveAllNegativeElementToStart(arr4);
		System.out.println("\n");
		
		for(int element: arr4) {
			System.out.print(element + " ");
		}
		
		
		List<Integer> arr5 = new ArrayList<>();
		arr5.add(1);
		arr5.add(3);
		arr5.add(3);
		arr5.add(4);
		arr5.add(6);
		arr5.add(7);
		arr5.add(7);
		arr5.add(8);
		arr5.add(9);
		
		arr5 = moveDuplicatesToEnd2(arr5);
        
        System.out.println("Original array:");
        for (int num : arr5) {
            System.out.print(num + " ");
        }

        System.out.println("\nArray after moving duplicates to end:");
        for (int num : arr5) {
            System.out.print(num + " ");
        }
		
	}
}