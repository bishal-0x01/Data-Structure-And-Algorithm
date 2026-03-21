/*

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Link : https://leetcode.com/problems/subarray-sum-equals-k/description/

*/

class Solution {
    public int subarraySum(int[] nums, int k) {

        int n = nums.length;

        int sum = 0;
        int count = 0;

        Map<Integer,Integer> cache = new HashMap<>();
        cache.put(0,1);

        for(int num : nums){
            sum += num;

            count += cache.getOrDefault(sum - k,0);

            cache.put(sum,cache.getOrDefault(sum,0)+1);
        }

        return count;
        
    }
}