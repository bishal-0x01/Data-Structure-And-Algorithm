/*

During a break in the buffet of the scientific lyceum of the Kingdom of Kremland, there was formed a queue of 𝑛
 high school students numbered from 1
 to 𝑛
. Initially, each student 𝑖
 is on position 𝑖
. Each student 𝑖
 is characterized by two numbers — 𝑎𝑖
 and 𝑏𝑖
. Dissatisfaction of the person 𝑖
 equals the product of 𝑎𝑖
 by the number of people standing to the left of his position, add the product 𝑏𝑖
 by the number of people standing to the right of his position. Formally, the dissatisfaction of the student 𝑖
, which is on the position 𝑗
, equals 𝑎𝑖⋅(𝑗−1)+𝑏𝑖⋅(𝑛−𝑗)
.

The director entrusted Stas with the task: rearrange the people in the queue so that minimize the total dissatisfaction.

Although Stas is able to solve such problems, this was not given to him. He turned for help to you.

Input
The first line contains a single integer 𝑛
 (1≤𝑛≤105
) — the number of people in the queue.

Each of the following 𝑛
 lines contains two integers 𝑎𝑖
 and 𝑏𝑖
 (1≤𝑎𝑖,𝑏𝑖≤108
) — the characteristic of the student 𝑖
, initially on the position 𝑖
.

Output
Output one integer — minimum total dissatisfaction which can be achieved by rearranging people in the queue.


Link : https://codeforces.com/contest/1151/problem/D

*/


import java.io.*;
import java.util.*;

public class Main {

     static Scanner sc;

     public static void solve(){

        int n = sc.nextInt();

        long [][] nums = new long[n][2];

        for(int i = 0; i < n;i++){
            nums[i][0] = sc.nextLong(); //a[i]
            nums[i][1] = sc.nextLong(); //b[i]
        }


        Arrays.sort(nums,new Comparator<long[]>(){
            @Override
            public int compare(long [] a, long [] b){
                return (int) ((b[0] - b[1]) - (a[0] - a[1]));
            }

        });


        long ans = 0;

        for(int i = 0; i < n; i++){
            long y = n*nums[i][1] - nums[i][0];
            long x = nums[i][0]-nums[i][1];

            ans+=(x * (i+1))+ y;
        }

        System.out.println(ans);
     }

    public static void main(String[] args) throws Exception {
       sc = new Scanner(System.in);
       solve();
       sc.close();
    }
}


