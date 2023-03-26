package stack;

import java.util.LinkedList;
import java.util.Queue;

public class Truck {

    public static void main(String args[]) {

        int bridge_length = 2, weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0, time = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int truck : truck_weights) {

            while(true) {

                if(queue.isEmpty()) {
                    queue.add(truck);
                    sum += truck;
                    time++;
                    break;
                }

                else if (queue.size() == bridge_length) {
                    sum -= queue.poll();
                }

                else {
                    if(sum + truck > weight) {
                        queue.add(0);
                        time++;
                    } else {
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }
                }
            }

        }

        return time + bridge_length;
    }

}
