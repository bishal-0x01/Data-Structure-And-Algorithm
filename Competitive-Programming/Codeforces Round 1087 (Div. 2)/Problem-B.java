import java.io.*;
import java.util.*;

public class Main {
    public static Scanner sc;

    public static void solve(){
        int n = sc.nextInt();
        
        long [] arr = new long[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLong();
        }


        for(int i = 0; i < n; i++){
            long count = 0;
            long epCount = 0;
            for(int j = i+1; j < n; j++){
                if((arr[i] > arr[j]) ) count++; 
                else if(arr[i] < arr[j]) epCount++;
            }

            System.out.print(Math.max(count,epCount) + " ");
        }

        System.out.println();
        
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