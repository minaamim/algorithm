package practice;

import java.util.*;

public class P131704 {

    public static void main(String[] args) {
        int[] order1 = {4, 3, 1, 2, 5};
        int[] order2 = {5, 4, 3, 2, 1};
        System.out.println("answer: " + solution(order1));
        System.out.println("answer: " + solution(order2));
    }

    public static int solution(int[] order) {
        int answer = 0;
        int index = 0;
        Stack<Integer> stack = new Stack<>();

        for(int box = 1 ; box <= order.length; box++) {
            if(order[index] != box){
                stack.push(box);
            } else {
                index++;
                answer++;
            }

            while(!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop();
                index++;
                answer++;
            }
        }
        return answer;
    }
}
