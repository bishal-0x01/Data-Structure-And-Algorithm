/*


219. Contains Duplicate II

Companies
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.


Leetcode link : https://leetcode.com/problems/contains-duplicate-ii/description/



*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer,Integer> cache = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(cache.containsKey(nums[i]) && Math.abs(cache.get(nums[i])-i)<=k){
                return true;
            }

            cache.put(nums[i],i);
        }

        return false;
    }
}