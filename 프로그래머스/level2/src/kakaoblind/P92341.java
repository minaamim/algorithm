package kakaoblind;

import java.util.*;

public class P92341 {

    public static void main(String[] args) {

        int[] fees1 = {180, 5000, 10, 600};
        String[] records1 = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        solution(fees1, records1);
    }

    public static int[] solution(int[] fees, String[] records) {
        int[] answer;
        final String IN = "IN", OUT = "OUT";

        //차량 번호: 입차 시간
        Map<String, String> inInfo = new HashMap<>();
        //차량 번호 : 주차 시간(분)
        Map<String, Integer> result = new TreeMap<>();

        for(int i = 0; i < records.length; i++) {
            String[] arr = records[i].split(" ");
            String time = arr[0];
            String car = arr[1];
            String value = arr[2];

            if(value.equals(IN)) inInfo.put(car, time);
            if(value.equals(OUT)) {
                String enter = inInfo.remove(car);
                int minutes = getTime(enter, time);

                if(result.containsKey(car)) {
                    result.put(car, result.getOrDefault(car, 0) + minutes);
                } else result.put(car, minutes);
            }
        }

        if(!inInfo.isEmpty()) {
            for(String key : inInfo.keySet()) {
                String enter = inInfo.remove(key);
                int minutes = getTime(enter, "23:59");

                if(result.containsKey(key)) result.put(key, result.getOrDefault(key, 0) + minutes);
                else result.put(key, minutes);
            }
        }

        answer = new int[result.size()];

        int idx = 0;
        for(String key : result.keySet()) {
            System.out.println("key: " + key + "using Time: " + result.get(key));

            int usingHour = result.get(key);
            if(usingHour <= fees[0]) answer[idx] = fees[1];
            else {
                answer[idx] += fees[1];

                usingHour -= fees[0];

                answer[idx] = fees[1] + (int) (fees[3] * Math.ceil(usingHour / (double) fees[2]));
            }

            idx++;
        }

        for(int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

        return answer;
    }

    private static int getTime(String enter, String leave) {
        int minute;

        String[] enterArr = enter.split(":");
        String[] leaveArr = leave.split(":");

        int enterHour = Integer.parseInt(enterArr[0]);
        int enterMinute = Integer.parseInt(enterArr[1]);

        int leaveHour = Integer.parseInt(leaveArr[0]);
        int leaveMinute = Integer.parseInt(leaveArr[1]);

        minute = (leaveHour * 60 + leaveMinute) - (enterHour * 60 + enterMinute);

        return minute;
    }

}
