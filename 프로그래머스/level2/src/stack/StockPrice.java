package stack;

public class StockPrice {

    public static void main(String args[]) {
        int[] prices = {1, 2, 3, 2, 3};
        solution(prices);
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if(prices[j] < prices[i]) break;
            }
        }

        for(int i : answer) System.out.print(i + " ");

        return answer;
    }

}
