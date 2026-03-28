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