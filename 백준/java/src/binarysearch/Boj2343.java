package binarysearch;

import java.io.*;
import java.util.*;

public class Boj2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lesson = Integer.parseInt(st.nextToken());
        int blu_ray = Integer.parseInt(st.nextToken());
        int start = 0, end = 0;

        st = new StringTokenizer(br.readLine());

        int[] minutes = new int[lesson];

        for(int i = 0; i < lesson; i++) {
            int minute = Integer.parseInt(st.nextToken());
            minutes[i] = minute;
            if(minute > start) start = minute;
            end += minute;
        }

        while(start <= end) {
            //용량
            int capacity = (start + end) / 2;
            int sum = 0, cnt = 0;

            for(int i = 0; i < lesson; i++) {
                if(sum + minutes[i] > capacity) {
                    cnt++;
                    sum = 0;
                }
                sum += minutes[i];
            }

            if(sum != 0) cnt++;
            if(cnt > blu_ray) start = capacity + 1;
            else end = capacity - 1;
        }
        System.out.println(start);
    }
}
