import java.util.*;
import java.io.*;

public class Boj1316 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, cnt = 0;
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            List<Character> list = new ArrayList<>();
            String str = br.readLine();
            list.add(str.charAt(0));

            boolean check[] = new boolean[26];
            boolean temp = true;

            for(int j = 0; j < str.length(); j++) {
                int idx = str.charAt(j) - 'a';

                if(check[idx]) {
                    if(str.charAt(j - 1) != str.charAt(j)) {
                        temp = false;
                        break;
                    }
                } else check[idx] = true;
            }

            if(temp) cnt++;

        }
        System.out.println(cnt);
    }
}
