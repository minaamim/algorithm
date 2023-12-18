package binarysearch;

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
            boolean find = false;
            int target = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = arr.length - 1;

            while(start <= end) {
                int mid = (start + end) / 2;
                int value = arr[mid];
                if(value > target) {
                    end = mid - 1;
                } else if(value < target) {
                    start = mid + 1;
                } else {
                    find = true;
                    break;
                }
            }

            if (find) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
