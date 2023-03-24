package bruteforce;

public class MinimumRectangle {

    public int solution(int[][] sizes) {
        int answer = 0;

        int x = 0, y = 0;

        for(int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }

            if(sizes[i][0] > x)
                x = sizes[i][0];

            if(sizes[i][1] > y)
                y = sizes[i][1];
        }


        answer = x * y;


        return answer;
    }

}
