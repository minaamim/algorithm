package core;

import java.io.*;
import java.util.*;

public class Boj1253 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        int N = sc.nextInt();
        long[] num = new long[N];
        for(int i = 0; i < N; i++) {
            num[i] = sc.nextLong();
        }

        Arrays.sort(num);

        for (int i = 0; i < N; i++) {
            int s = 0;
            int e = N - 1;
            while(s < e) {
                if(num[s] + num[e] == num[i]) {
                    if(s != i && e != i) {
                        ans++;
                        break;
                    }
                    if(s == i) s++;
                    if(e == i) e--;
                } else if(num[s] + num[e] > num[i]) {
                    e--;
                } else if(num[s] + num[e] < num[i]) {
                    s++;
                }
            }
        }
        System.out.println(ans);
    }
}
