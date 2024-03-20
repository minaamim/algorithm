package core;

import java.io.*;
import java.util.*;

public class Boj1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] operation = str.split("-");

        for(int i = 0; i < operation.length; i++) {
            String[] plus = operation[i].split("\\+");
            int n = 0;
            for(int j = 0; j < plus.length; j++) {
                n += Integer.parseInt(plus[j]);
            }
            operation[i] = String.valueOf(n);
        }
        int ans = Integer.parseInt(operation[0]);

        for(int i = 1; i < operation.length; i++) {
            ans -= Integer.parseInt(operation[i]);
        }
        System.out.println(ans);
    }
}