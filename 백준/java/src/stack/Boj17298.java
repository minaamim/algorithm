package stack;

import java.io.*;
import java.util.*;

public class Boj17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[N];
        int[] ans = new int[N];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(0);

        for(int i = 1; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ans[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        for(int i = 0; i < ans.length; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
    }
}
