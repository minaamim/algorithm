package greedy;

import java.io.*;

public class Boj1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 0;

        String[] splited = str.split("-");
        int[] arr = new int[splited.length];

        for(int i = 0; i < splited.length; i++) {
            String[] temp = splited[i].split("\\+");
            for(String sum : temp) {
                arr[i] += Integer.parseInt(sum);
            }
            if (i == 0) {
                answer += arr[i];
            } else {
                answer -= arr[i];
            }
        }
        System.out.println(answer);
    }
}
