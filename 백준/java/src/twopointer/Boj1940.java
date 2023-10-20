package twopointer;

import java.io.*;
import java.util.*;

public class Boj1940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int index = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) arr[index++] = Integer.parseInt(st.nextToken());

        int start = 0, end = N - 1;
        Arrays.sort(arr);

        int cnt = 0;
        while(start < end) {
            if(arr[start] + arr[end] < M) start++;
            else if(arr[start] + arr[end] > M) end--;
            else {
                cnt++;
                start++;
                end--;
            }
        }
        System.out.println(cnt);
    }
}
