/*

Given an integer array nums and an integer k, return the number of pairs (i, j) where i < j such that |nums[i] - nums[j]| == k.

The value of |x| is defined as:

x if x >= 0.
-x if x < 0.


Link : https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/ 

*/

class Solution {
    public int countKDifference(int[] nums, int k) {

        int n = nums.length;

        Map<Integer,Integer> counter = new HashMap<>();

        int count = 0;

        for(int num: nums){
            int pre = num -  k;
            int post = num + k;


            count += counter.getOrDefault(pre,0);
            count += counter.getOrDefault(post,0);

            counter.put(num,counter.getOrDefault(num,0)+1);
        }

        return count;

        
    }
}