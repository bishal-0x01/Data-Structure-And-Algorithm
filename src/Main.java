import java.io.*;
import java.util.*;

public class Main {

    static class Pair {
        int count;
        char ch;

        Pair(int count, char ch) {
            this.count = count;
            this.ch = ch;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();

            StringBuilder sb = new StringBuilder();

            while (true) {
                List<Pair> list = new ArrayList<>();
                if (r > 0) list.add(new Pair(r, 'R'));
                if (g > 0) list.add(new Pair(g, 'G'));
                if (b > 0) list.add(new Pair(b, 'B'));

                // sort by remaining count descending
                list.sort((a, c) -> c.count - a.count);

                boolean placed = false;

                for (Pair p : list) {
                    int n = sb.length();

                    // check constraints
                    if (n >= 1 && sb.charAt(n - 1) == p.ch) continue;
                    if (n >= 3 && sb.charAt(n - 3) == p.ch) continue;

                    // place character
                    sb.append(p.ch);

                    if (p.ch == 'R') r--;
                    else if (p.ch == 'G') g--;
                    else b--;

                    placed = true;
                    break;
                }

                if (!placed) break; // no valid move
            }

            System.out.println(sb.toString());
        }
    }
}