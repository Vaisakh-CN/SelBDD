package logics;

import java.util.ArrayList;
import java.util.List;

//code to find two numbers in an array that add up to a specific target sum
public class FindTwoSum {
		public static List <int[]> findTwoSum(int[] nums, int target) {
			List<int[]> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result.add(new int[]{nums[i], nums[j]});
					
				}
				
			}
		}
		return result; // Return -1, -1 if no such pair exists
	}
		public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		List<int[]> result = findTwoSum(nums, target);
		if (!result.isEmpty()) {
			for (int[] pair : result) {
				System.out.println("Found pair: " + pair[0] + " and " + pair[1]);
			}
					} else {
			System.out.println("No two numbers add up to " + target);
		}
	}

}
