


/*
count the number of subarray whose sum is equal to its length

Link : https://www.geeksforgeeks.org/dsa/count-of-subarrays-having-sum-equal-to-its-length/

*/


import java.io.*;
import java.util.*;

public class Main {
    public static Scanner sc;

    public static void solve(){
        int n = sc.nextInt();
        int [] nums = new int [n+1];
        int [] prefix = new int [n+1];

        for(int i = 1;i <= n; i++){
            nums[i] = sc.nextInt();
            prefix[i] = prefix[i-1]+nums[i];
        }

        prefix[0] = nums[0] = 0;

        /*

            Assumption : i < j
            p[j] - p[i-1] = subarraySum(i,j) = j-i+1;
            p[j] - j = p[i-1] - (i-1)
            lets say i-1 = t
            as i < j therefore i-1 < j therefore t < j
            p[j] - j = p[t] - t
        */

        int ans = 0;
        Map<Integer,Integer> cache = new HashMap<>();
        cache.put(0,1);

        for(int i = 1; i <= n; i++){

            int y = prefix[i] - i;
            
            ans+= cache.getOrDefault(y,0);
            cache.put(y,cache.getOrDefault(y,0)+1);
        }

        System.out.println(ans);
    }
   
    public static void main(String[] args) throws Exception {
       sc = new Scanner(System.in);

       int test = sc.nextInt();

       while(test-- > 0){
        solve();
       }
        sc.close();
    }
}