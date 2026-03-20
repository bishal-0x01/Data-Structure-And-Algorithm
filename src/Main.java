import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br;
        BufferedWriter bw;

        if (System.getProperty("ONLINE_JUDGE") == null) {
            br = new BufferedReader(new FileReader("Input-Output-Folder/input.txt"));
            bw = new BufferedWriter(new FileWriter("Input-Output-Folder/output.txt"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        // Example
        int n = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split(" ");

        int sum = 0;
        for (String p : parts) {
            sum += Integer.parseInt(p);
        }

        bw.write("Sum = " + sum);
        bw.newLine();

        br.close();
        bw.close();
    }
}