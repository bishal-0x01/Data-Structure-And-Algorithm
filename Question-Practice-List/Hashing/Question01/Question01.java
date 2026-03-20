/*

We are given an Array of Numbers. We have to find and print any Number with Maximum Frequency and Minimum Frequency.

Example Testcase:-

Arr = [3, 2, 3, 2, 4, 3]

Frequencies of Elements of Array are:-

3 - 3
2 - 2
4 - 1

Maximum Frequency:- Element is 3, Frequency is 3
Minimum Frequency:- Element is 4, Frequency is 1

*/



import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int [] arr = new int [n];

        for(int i = 0; i < n ;i++){
            arr[i] = sc.nextInt();
        }


        Map<Integer,Integer> frequencyCounter = new HashMap<>();

        for(int num : arr){
            frequencyCounter.put(num,frequencyCounter.getOrDefault(num,0)+1);
        }

        int mnFreq = Integer.MAX_VALUE;
        int mxFreq = Integer.MIN_VALUE;
        int mn = -1,mx = -1;


        for(Map.Entry<Integer,Integer> entry : frequencyCounter.entrySet()){
            if(mnFreq > entry.getValue()){
                mn = entry.getKey();
                mnFreq = entry.getValue();
            }

            if(mxFreq < entry.getValue()){
                mx = entry.getKey();
                mxFreq = entry.getValue();
            }
        }

        System.out.println("Maximum Frequency:- Element is "+mx+", Frequency is "+mxFreq);
        System.out.println("Minimum Frequency:- Element is "+mn+", Frequency is "+mnFreq);


        

        sc.close();
    }
}