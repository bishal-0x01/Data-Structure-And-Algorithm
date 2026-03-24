/*

 Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.

 Link : https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/

*/

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        TreeMap<Integer,Integer> finder = new TreeMap<>();
        int len = 0;
        int n = nums.length;

        for(int i = 0,j = 0; j < n; j++){
            finder.put(nums[j],finder.getOrDefault(nums[j],0)+1);
            int min = finder.firstKey();
            int max = finder.lastKey();
            int diff = max - min;

            while(diff > limit){
                int val = finder.getOrDefault(nums[i],0);
                if(val - 1 <= 0){
                    finder.remove(nums[i]);
                }else{
                    finder.put(nums[i],val - 1);
                }

                min = finder.firstKey();
                max = finder.lastKey();
                diff = max - min;
                i++;
            }

            len = Math.max(len,j-i+1);
        }

        return len;
    }
}