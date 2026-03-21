/*

Count pairs with given sum

You are given an array arr[] and an integer target. You have to count all pairs in the array such that their sum is equal to the given target.

link : https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum--150253/1

*/


class Solution {
    int countPairs(int nums[], int target) {
        // code here
        
        Map<Integer,Integer> counter = new HashMap<>();
        
        int n = nums.length;
        int count = 0;
        
        for(int i = 0; i < n; i++){
            count+= counter.getOrDefault(target-nums[i],0);
            counter.put(nums[i],counter.getOrDefault(nums[i],0)+1);
        }
        
        return count;
        
    }
}