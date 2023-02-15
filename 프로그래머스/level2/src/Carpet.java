public class Carpet {
    public int[] solution(int brown, int yellow) {
        /**
         * 카펫의 가로 길이는 세로 길이와 같거나 길다.
         */
        int[] answer = new int[2];
        int sum = brown + yellow;

        for(int i = 3; i < sum; i++) {
            int j = sum / i;
            if(sum % i == 0 && j >= 3) {
                int x = Math.max(i, j);
                int y = Math.min(i, j);
                int center = (x - 2) * (y - 2);

                if(center == yellow) {
                    answer[0] = x;
                    answer[1] = y;
                }
            }

        }

        return answer;
    }
}
