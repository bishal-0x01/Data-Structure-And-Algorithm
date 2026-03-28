/*

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

link : https://leetcode.com/problems/single-element-in-a-sorted-array/description/

*/


class Solution {
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;

        int low = 0,high = n-1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if((mid == 0 || nums[mid] != nums[mid-1]) && (mid == n-1 || nums[mid] != nums[mid+1])){
                return nums[mid];
            }else if((mid % 2 == 0 && nums[mid] == nums[mid-1]) || (mid %2 ==1 && nums[mid] == nums[mid+1])){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
        
    }
}