/*

You are given an integer power and two integer arrays damage and health, both having length n.

Bob has n enemies, where enemy i will deal Bob damage[i] points of damage per second while they are alive (i.e. health[i] > 0).

Every second, after the enemies deal damage to Bob, he chooses one of the enemies that is still alive and deals power points of damage to them.

Determine the minimum total amount of damage points that will be dealt to Bob before all n enemies are dead.

Note: Please do not copy the description during the contest to maintain the integrity of your submissions.


link : https://leetcode.com/contest/biweekly-contest-138/problems/minimum-amount-of-damage-dealt-to-bob/description/

*/


class Solution {
    public long minDamage(int power, int[] damage, int[] health) {

        int n = damage.length;
        int [] m = new int [n];

        for(int i = 0 ;i < n; i++){
            m[i] = (health[i] % power == 0) ? health[i]/power : health[i]/power +1;
        }

        int[][] mat = new int [n][2];
        long ans = 0, sum = 0;
        for(int i = 0; i < n;i++){
            mat[i][0] = damage[i];
            mat[i][1] = m[i];
            sum+=damage[i];
        }

        Arrays.sort(mat,new Comparator<int[]>(){
            @Override
            public int compare(int [] a,int [] b){
                return b[0]*a[1] - a[0]*b[1];
            }
        });

        for(int i = 0; i < n ; i++){
            ans+= (sum * mat[i][1]);
            sum-=mat[i][0];
        }

        return ans; 
        
    }
}