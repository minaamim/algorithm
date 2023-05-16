package d2;

import java.util.*;
import java.io.*;

public class MillionaireProject {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < str.length; j++) arr[j] = Integer.parseInt(str[j]);

            long max = 0;
            long diff = 0;

            for(int j = N -1; j >= 0; j--) {
                if(arr[j] > max) max = arr[j];
                diff += max - arr[j];
            }
            System.out.println("#" + i + " " + diff);
        }

    }
}
