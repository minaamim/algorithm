package kakaoblind;

import java.util.*;

public class ParkingFee {

    public static void main(String args[]) {
//        int[] fees = {180, 5000, 10, 600};
//        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

//        int[] fees = {120, 0, 60, 591};
//        String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};

        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN"};

        solution(fees, records);

    }


    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        //차 번호, 입차 시간
        HashMap<String, Integer> map = new HashMap<>();
        //차 번호, 총 주차 시간
        Map<String, Integer> result = new TreeMap<>();
        
        for(String data : records) {

            String[] record = data.split(" ");

            int time = calculateTime(record[0]);
            String carNum = record[1];
            String state = record[2];

            if(state.equals("OUT")) {
                int inTime = map.remove(carNum);
                int totalTime = time - inTime;

                if(result.containsKey(carNum)) {
                    totalTime += result.get(carNum);
                }
                result.put(carNum, totalTime);

                continue;
            }
            map.put(carNum, time);
        }

        //출차 시간이 없는 경우
        for(String key : map.keySet()) {

            int inTime = map.remove(key);
            int outTime = calculateTime("23:59");
            int totalTime = outTime - inTime;

            if(result.containsKey(key)) {
                totalTime += result.get(key);
                result.replace(key, totalTime);
                continue;
            }
            result.put(key, totalTime);
        }

        //요금 계산
        answer = new int[result.size()];

        int i = 0;

        for(int time : result.values()) {

            if(time >= fees[0])
                answer[i] = fees[1] + (int) Math.ceil((time - fees[0]) / (double)fees[2]) * fees[3];
            else
                answer[i] = fees[1];

            i++;
        }

        return answer;
    }

    private static int calculateTime(String time) {
        String[] str = time.split(":");
        int hour = Integer.parseInt(str[0]) * 60;
        int minute = Integer.parseInt(str[1]);
        return hour + minute;
    }

}
