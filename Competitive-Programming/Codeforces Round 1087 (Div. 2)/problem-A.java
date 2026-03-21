/*

problem Link : https://codeforces.com/contest/2209/problem/A

*/

import java.io.*;
import java.util.*;

public class Main {
    public static Scanner sc;

    public static void solve(){
        int n = sc.nextInt();
        long c = sc.nextLong();
        long k = sc.nextLong();

        long [] arr = new long [n];

        for(int i = 0; i < n;i++){
            arr[i] = sc.nextLong();
        }








        Arrays.sort(arr);

        for(int i = 0; i < n;i++){
            if(c < arr[i]) break;

            long rem = c - arr[i];

            if(k >= rem){
                arr[i]+=rem;
                k-=rem;
            }else{
                arr[i]+=k;
                k = 0;
            }

            c+=arr[i];
        }

        System.out.println(c);

        
    }
   
    public static void main(String[] args) throws Exception {
       sc = new Scanner(System.in);

       long test = sc.nextLong();

       while(test-- > 0){
        solve();
       }
        sc.close();
    }
}