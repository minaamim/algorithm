import java.util.Stack;

public class Hamburger {
    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> order = new Stack<>();

        for(int in : ingredient) {
            order.push(in);

            if(order.size() >= 4) {
                int size = order.size();
                if(order.get(size - 1) == 1
                && order.get(size - 2) == 3
                && order.get(size - 3) == 2
                && order.get(size - 4) == 1) {
                    answer++;
                    order.pop();
                    order.pop();
                    order.pop();
                    order.pop();
                }
            }

        }
        return answer;
    }
}
