package binarysearch;

import java.io.*;
import java.util.*;

public class Boj1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M ; i++) {
            if(list.contains(Integer.parseInt(st.nextToken()))) {
                System.out.println("1");
                continue;
            }
            System.out.println("0");
        }
    }
}
