/*

William Macfarlane wants to look at an array.

You are given a list of N numbers and Q queries. Each query is specified by two numbers i and j; the answer to each query is the sum of every number between the range [i, j] (inclusive).

Note: the query ranges are specified using 0-based indexing.

Input
The first line contains N, the number of integers in our list (N ≤ 100,000). The next line holds N numbers that are guaranteed to fit inside an integer. Following the list is a number Q (Q ≤ 10,000). The next Q lines each contain two numbers i and j which specify a query you must answer (0 ≤ i, j ≤ N-1).


Link : https://www.spoj.com/problems/CSUMQ/

*/




import java.io.*;
import java.util.*;

public class Main {

    public static int solve(int [] prefix,int left,int right){
        return prefix[right] - (left == 0 ? 0 : prefix[left-1]);
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();

        int [] arr = new int[n];
        for(int i = 0; i < n;i++){
            arr[i] = sc.nextInt();
        }

        int [] prefix = new int [n];
        prefix[0] = arr[0];

        for(int i = 1;i < n;i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        int q = sc.nextInt();

        while(q -- > 0){

            int left = sc.nextInt();
            int right = sc.nextInt();

            System.out.println(solve(prefix,left,right));
        }

        

        sc.close();
    }
}