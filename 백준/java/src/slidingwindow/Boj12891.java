package slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12891 {

    static char[] DNA;
    static int[] mine = new int[4];
    static int[] check = new int[4];
    static int satisfy = 0;

    public static void main(String[] args) throws IOException {
        int S, P;
        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        DNA = new char[S];
        DNA = st.nextToken().toCharArray();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
            if(check[i] == 0) satisfy++;
        }

        for(int i = 0; i < P; i++) {
            add(DNA[i]);
        }

        if(satisfy == 4) result++;

        for(int i = P; i < S; i++) {
            int previous = i - P;
            remove(DNA[previous]);
            add(DNA[i]);
            if(satisfy == 4) result++;
        }
        System.out.println(result);
    }

    private static void add(char ch) {
        switch (ch) {
            case 'A':
                mine[0]++;
                if(mine[0] == check[0]) satisfy++;
                break;
            case 'C':
                mine[1]++;
                if(mine[1] == check[1]) satisfy++;
                break;
            case 'G':
                mine[2]++;
                if(mine[2] == check[2]) satisfy++;
                break;
            case 'T':
                mine[3]++;
                if(mine[3] == check[3]) satisfy++;
                break;
        }
    }

    private static void remove(char ch) {
        switch (ch) {
            case 'A':
                if(mine[0] == check[0]) satisfy--;
                mine[0]--;
                break;
            case 'C':
                if(mine[1] == check[1]) satisfy--;
                mine[1]--;
                break;
            case 'G':
                if(mine[2] == check[2]) satisfy--;
                mine[2]--;
                break;
            case 'T':
                if(mine[3] == check[3]) satisfy--;
                mine[3]--;
                break;
        }
    }
}
