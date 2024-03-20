package core;

import java.io.*;
import java.util.*;

public class Boj1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int s = 0;
            int e = N - 1;
            boolean find = false;

            while(s <= e) {
                int mid = (s + e) / 2;
                int value = arr[mid];

                if(value == target) {
                    find = true;
                    break;
                } else if(value < target) {
                    s = mid + 1;
                } else if(value > target) {
                    e = mid - 1;
                }
            }

            if (find) {
                System.out.println("1");
                continue;
            }
            System.out.println("0");
        }
    }
}
