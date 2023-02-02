

public class FoodFight {
    public String solution(int[] food) {

        /**
         * food = 칼로리가 적은 순서대로 배열된 음식
         */

        String answer = "";

        for(int i = 1; i < food.length; i++) {
            for(int j = 0; j < food[i] / 2; j++) {
                answer += i;
            }
        }

        String reversed = new StringBuffer(answer).reverse().toString();
        answer += "0" + reversed;

        return answer;
    }
}
