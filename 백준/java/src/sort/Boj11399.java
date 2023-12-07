package sort;

import java.io.*;
import java.util.*;

public class Boj11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int ans;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        ans = arr[0];

        for(int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
            ans += arr[i];
        }
        System.out.println(ans);
    }
}
