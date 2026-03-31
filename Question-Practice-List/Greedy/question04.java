/*

You are given an array nums consisting of positive integers.

You are also given an integer array queries of size m. For the ith query, you want to make all of the elements of nums equal to queries[i]. You can perform the following operation on the array any number of times:

Increase or decrease an element of the array by 1.
Return an array answer of size m where answer[i] is the minimum number of operations to make all elements of nums equal to queries[i].

Note that after each query the array is reset to its original state.


Link : https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal/description/

*/


import java.util.*;
class Solution {
    public int findLeftIndx(int [] nums, int target){

        int low = 0;
        int high = nums.length -1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(target >= nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return high; // last index where nums[i] <= target
    }

    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;

        Arrays.sort(nums);

        long [] prefix = new long [n];
        prefix[0] = nums[0];

        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        long total = prefix[n - 1];

        List<Long> res = new ArrayList<>();

        for(int i = 0; i < queries.length; i++){
            int target = queries[i];
            int left_indx = findLeftIndx(nums, target);

            long ans = 0;
            if(left_indx >= 0){
                ans += (long)(left_indx + 1) * target - prefix[left_indx];
            }

            if(left_indx < n - 1){
                long rightSum = total - (left_indx >= 0 ? prefix[left_indx] : 0);
                int count = n - left_indx - 1;
                ans += rightSum - (long)count * target;
            }

            res.add(ans);
        }

        return res;
    }
}