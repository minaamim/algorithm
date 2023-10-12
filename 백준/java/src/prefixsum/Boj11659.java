package prefixsum;

import java.io.*;
import java.util.*;

public class Boj11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sum = new int[N];
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        while(st.hasMoreTokens()) arr[idx++] = Integer.parseInt(st.nextToken());

        sum[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1, end = Integer.parseInt(st.nextToken()) - 1;

            if(start == 0) {
                System.out.println(sum[end]);
                continue;
            }
            System.out.println(sum[end] - sum[start - 1]);
        }
    }

}
