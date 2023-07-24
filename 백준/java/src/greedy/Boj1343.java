package greedy;

import java.io.*;

public class Boj1343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        solution(str);
    }

    private static void solution(String str) {
        str = str.replace("XXXX", "AAAA");
        str = str.replace("XX", "BB");

        if(str.contains("X")) System.out.println("-1");
        else System.out.println(str);
    }
}
