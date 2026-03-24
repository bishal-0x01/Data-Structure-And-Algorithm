/*

The score of an array is defined as the product of its sum and its length.

For example, the score of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75.
Given a positive integer array nums and an integer k, return the number of non-empty subarrays of nums whose score is strictly less than k.

A subarray is a contiguous sequence of elements within an array.

link : https://leetcode.com/problems/count-subarrays-with-score-less-than-k/description/


*/


class Solution {
    public long countSubarrays(int[] nums, long k) {

        long count = 0;
        long sum = 0;
        long length = 0;
        int n = nums.length;

        for(int i = 0,j = 0; j < n; j++){
            sum += (long) nums[j];
            long product = sum * (j-i+1);
            while(product >= k){
                sum = sum - nums[i];
                i++;
                product = sum * (j-i+1);
            }
            count += (j-i+1);
        }

        return count;
        
    }
}

