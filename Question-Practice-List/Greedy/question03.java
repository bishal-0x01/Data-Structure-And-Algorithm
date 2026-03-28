/*

Andy and Bob are the only two delivery men of Pizza-chef store. Today, the store received N orders. It's known that the amount of tips may be different when handled by different delivery man. More specifically, if Andy takes the ith order, he would be tipped Ai dollars and if Bob takes this order, the tip would be Bi dollars.

They decided that they would distribute the orders among themselves to maximize the total tip money. One order will be handled by only one person. Also, due to time constraints Andy cannot take more than X orders and Bob cannot take more than Y orders. It is guaranteed that X + Y is greater than or equal to N, which means that all the orders can be handled by either Andy or Bob.

Please find out the maximum possible amount of total tip money after processing all the orders.

link : https://www.codechef.com/problems/TADELIVE?tab=statement 

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int [][] nums = new int [n][2];
		
		for(int i = 0 ;i < n; i++){
		    nums[i][0] = sc.nextInt();
		}
		for(int i = 0; i < n; i++){
		    nums[i][1] = sc.nextInt();
		}
		
		Arrays.sort(nums,new Comparator<int[]>(){
		    @Override
		    public int compare(int [] a,int [] b){
		        return Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]);
		    }
		});
		
		
		long ans = 0;
		
		int i = 0;
		
		while(i < n){
		    if(x > 0 && y > 0){
		        if(nums[i][0] >= nums[i][1]){
		            x--;
		            ans+=nums[i][0];
		        }else{
		            y--;
		            ans+=nums[i][1];
		        }
		    }else if(x > 0){
		        ans+=nums[i][0];
		        x--;
		    }else if(y > 0){
		        ans+=nums[i][1];
		        y--;
		    }
		    
		    i++;
		}
		
		System.out.println(ans);
		sc.close();

	}
}
