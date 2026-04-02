/*

Link : https://www.codechef.com/problems/SHOOT0



*/


import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static class Pair{
        public long sum;
        public long count;
        
        public Pair(long sum,long count){
            this.sum = sum;
            this.count = count;
        }
    }
    
    public static Scanner sc;
    
    public static long [] helper(int v, int [] arr,int m){
        
        Pair [] prefixA = new Pair[m];
        Pair [] suffixA = new Pair[m];
        
        // prefix init
        if(arr[0] == v || arr[0] == 3){
            prefixA[0] = new Pair(0,1);
        }else{
            prefixA[0] = new Pair(0,0);
        }
        
        // suffix init (IMPORTANT FIX already done)
        if(arr[m-1] == v || arr[m-1] == 3){
            suffixA[m-1] = new Pair(m-1,1);
        }else{
            suffixA[m-1] = new Pair(0,0);
        }
       
        // prefix build
        for(int i = 1; i < m; i++){
            long sum = prefixA[i-1].sum;
            long count = prefixA[i-1].count;
           
            if(arr[i] == v || arr[i] == 3){
                sum += i;
                count++;
            }
           
            prefixA[i] = new Pair(sum,count);
        }
       
        // suffix build
        for(int i = m-2; i >= 0; i--){
            long sum = suffixA[i+1].sum;
            long count = suffixA[i+1].count;
            
            if(arr[i] == v || arr[i] == 3){
                sum += i;
                count++;
            }
           
            suffixA[i] = new Pair(sum,count);
        }
       
        long [] res = new long[m];
       
        for(int i = 0; i < m; i++){
            long val = prefixA[i].count * i - prefixA[i].sum;
            val += suffixA[i].sum - suffixA[i].count * i;
           
            res[i] = val;
        }
       
        return res;
    }
    
    public static void solve(){
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int [] arr = new int [m];
        
        for(int i = 0; i < m; i++){
            arr[i] = sc.nextInt();
        }
        
        long [] valA = helper(1,arr,m);
        long [] valB = helper(2,arr,m);
        
        for(int i = 0; i < m; i++){
            System.out.print(Math.abs(valA[i] - valB[i]) + " ");
        }
        
        System.out.println();
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		while(test-- > 0){
		    solve();
		}
	}
}