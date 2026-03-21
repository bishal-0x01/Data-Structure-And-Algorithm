/*
Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


Link : https://leetcode.com/problems/range-sum-query-immutable/description/



*/


class NumArray {
    int [] prefix;

    public NumArray(int[] nums) {
        
        int n = nums.length;
        prefix = new int [n];
        prefix[0] = nums[0];

        for(int i =1; i < n;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {

        int n = prefix.length;

        return prefix[right] - ((left == 0)? 0: prefix[left-1]);
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */