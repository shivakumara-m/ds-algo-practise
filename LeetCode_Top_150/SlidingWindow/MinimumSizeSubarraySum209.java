

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 */

package LeetCode_Top_150.SlidingWindow;

public class MinimumSizeSubarraySum209 {
    public static void main(String[] args) {
        MinimumSizeSubarraySum209 m = new MinimumSizeSubarraySum209();
        int[] nums = new int[] { 1 };
        System.out.println(m.minSubArrayLen(1, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minLen = nums.length + 1;
        int currentSum = 0;
        for (int right = 0; right < nums.length; right++) {
            //System.out.println("right in for " + right);
            currentSum += nums[right];
            while (currentSum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }
        return minLen == nums.length+1 ? 0: minLen;
    }

}
