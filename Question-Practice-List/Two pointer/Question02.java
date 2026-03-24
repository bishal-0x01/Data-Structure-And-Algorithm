/*
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

Link : https://leetcode.com/problems/subarray-product-less-than-k/description/
*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        long product = 1;
        int n = nums.length;
        int count = 0;

        if(k <= 1) return 0;
        

        for(int i = 0, j = 0 ; j < n ;j++){
            product = product * (long)nums[j];
            while(product >= k){
                product = product / nums[i];
                i++;
            }

            count += (j-i+1);
        }

        return count;
    }
}