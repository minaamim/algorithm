package kakaoblind;

import java.util.*;

public class ParkingFee {

    public static void main(String args[]) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};


//        int[] fees = {120, 0, 60, 591};
//        String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};


        solution(fees, records);

    }


    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        //차 번호, 입차 시간
        HashMap<String, String> map = new HashMap<>();
        //차 번호, 총 주차 시간
        Map<String, Integer> fee = new TreeMap<>();
        
        for(String str : records) {
            fee.put(str.split(" ")[1], 0);
        }
        
        for(int i = 0; i < records.length; i++) {

            String[] record = records[i].split(" ");

            if(map.containsKey(record[1])) {
                String[] enter = map.get(record[1]).split(":");
                String[] end = record[0].split(":");
                int hour = Integer.parseInt(end[0]) - Integer.parseInt(enter[0]);
                int minute = Integer.parseInt(end[1]) - Integer.parseInt(enter[1]);

                fee.replace(record[1], fee.get(record[1]) + (hour * 60) + minute);
                map.remove(record[1]);
            } else {
                map.put(record[1], record[0]);
            }

        }

        //출차 시간이 없는 경우
        for(String key : map.keySet()) {
            String[] enter = map.get(key).split(":");

            int hour = 23 - Integer.parseInt(enter[0]);
            int minute = 59 - Integer.parseInt(enter[1]);

            int time = fee.get(key) + hour * 60 + minute;

            fee.replace(key, fee.get(key) + (hour * 60) + minute);
            map.remove(key);
        }

        //요금 계산
        answer = new int[fee.size()];
        int i = 0;

        for(String key : fee.keySet()) {
            int time = fee.get(key);

            if(time > fees[0])
                answer[i] = fees[1] + (int) Math.ceil((fee.get(key) - fees[0]) / (double)fees[2]) * fees[3];
            else
                answer[i] = fees[1];

            i++;
        }

        return answer;
    }

}
