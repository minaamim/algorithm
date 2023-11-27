package stack;

import java.io.*;
import java.util.*;

public class Boj1874 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();

        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int N = sc.nextInt();

        int idx = 1;
        for(int i = 0; i < N; i++) {
            int n = sc.nextInt();

            if(idx <= n) {
                while (idx <= n) {
                    stack.push(idx++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else if(idx > n) {
                int pop = stack.pop();

                if(pop > n) {
                    System.out.println("NO");
                    return;
                }
                sb.append("-\n");
            }
        }
        System.out.println(sb.toString());
    }
}
