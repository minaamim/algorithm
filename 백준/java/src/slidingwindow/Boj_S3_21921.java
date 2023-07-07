package slidingwindow;

import java.io.*;
import java.util.*;

public class Boj_S3_21921 {
    public static void main(String args[]) throws IOException {
        int N, X;
        int[] visitor;
        int max = 0;
        int cnt = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visitor = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) visitor[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < X; i++) max += visitor[i];

        int sum = max;
        for(int i = X; i < N; i++) {
            sum += visitor[i] - visitor[i - X];
            if(max == sum) cnt++;
            else if(max < sum) {
                max = sum;
                cnt = 1;
            }
        }

        if(max == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(cnt);
    }
}
