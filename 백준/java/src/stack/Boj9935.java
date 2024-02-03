package stack;

import java.io.*;
import java.util.*;

public class Boj9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        if(str.length() < bomb.length()) {
            System.out.println(str);
            return;
        }

        for(int i = 0; i < str.length(); i++) {
            stack.add(str.charAt(i));
            int cnt = 0;

            if(stack.size() >= bomb.length()) {
                for(int j = 0; j < bomb.length(); j++) {
                    if(stack.get(stack.size() - bomb.length() + j) == bomb.charAt(j)) cnt++;
                    if(cnt == bomb.length()) {
                        for(int k = 0; k < bomb.length(); k++) {
                            stack.pop();
                        }
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
            return;
        }

        for(int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        System.out.println(sb);
    }
}
