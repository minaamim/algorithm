package summerwintercoding;

public class BaseStationInstallation {

    public static void main(String args[]) {
        int N1 = 11, N2 = 16;
        int[] stations1 = {4, 11};
        int[] stations2 = {9};
        int W1 = 1, W2 = 2;

        System.out.println(solution(N1, stations1, W1));
        System.out.println(solution(N2, stations2, W2));
    }

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;

        for(int station : stations) {
            if(start < station - w) {
                int end = station - w;
                //전파가 닿지 않는 범위
                int len = end - start;
                int cnt = len / (w*2+1);
                if(len % (w*2+1) != 0) cnt++;

                answer += cnt;
            }

            start = station + w + 1;
        }

        if(stations[stations.length - 1] + w + 1 <= n) {
            start = stations[stations.length - 1] + w + 1;

            int end = n + 1;
            int len = end - start;
            int cnt = len / (w*2+1);
            if(len % (w*2+1) != 0) cnt++;
            answer += cnt;
        }
        return answer;
    }
}
