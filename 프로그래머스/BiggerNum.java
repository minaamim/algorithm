public class BiggerNum {
    public int solution(int n) {
        int answer = 0;
        int countN = Integer.bitCount(n);

        while(true) {
            n++;
            if (countN == Integer.bitCount(n)) {
                answer = n;
                break;
            }
        }

        return answer;
    }

}
