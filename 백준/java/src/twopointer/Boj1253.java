package twopointer;

import java.io.*;
import java.util.*;

public class Boj1253 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[N];
        int answer = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int k = 0; k < arr.length; k++) {
            long find = arr[k];
            int i = 0, j = N - 1;

            while(i < j) {
                int sum = arr[i] + arr[j];
                if(sum == find) {
                    if(i != k && j != k) {
                        answer++;
                        break;
                    } else if(i == k) i++;
                    else if(j == k) j--;
                } else if(sum > find) {
                    j--;
                } else if(sum < find) {
                    i++;
                }
            }
        }
        System.out.println(answer);
    }
}
