package twopointer;

import java.io.*;
import java.util.*;

public class Boj1253 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0;
        while(st.hasMoreTokens()) arr[idx++] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++) {
            int target = arr[i];

            int start = 0, end = arr.length - 1;
            int sum;

            while(start < end) {
                sum = arr[start] + arr[end];

                if(sum == target) {
                    if(start == i) start++;
                    else if(end == i) end--;
                    else {
                        answer++;
                        break;
                    }
                }
                if(sum > target) end--;
                else if(sum < target) start++;
            }
        }

        System.out.println(answer);
    }
}
