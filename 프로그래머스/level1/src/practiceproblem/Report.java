package practiceproblem;

import java.util.HashMap;
import java.util.HashSet;

public class Report {
    public int[] solution(String[] id_list, String[] report, int k) {
        //유저가 받은 결과 메일 수
        int[] answer = new int[id_list.length];

        HashMap<String, HashSet<String>> reportList = new HashMap<>();
        //유저 순서 저장
        HashMap<String, Integer> memIdx = new HashMap<>();

        for(int i = 0; i < id_list.length; i++) {
            reportList.put(id_list[i], new HashSet<>());
            memIdx.put(id_list[i], i);
        }

        //신고 기록
        for(String info : report) {
            String reporter = info.split(" ")[0];
            String reported = info.split(" ")[1];
            reportList.get(reported).add(reporter);
        }

        //메일 발송
        for(String name : reportList.keySet()) {

            if(reportList.get(name).size() >= k) {
                for (String from : reportList.get(name)) {
                    int index = memIdx.get(from);
                    answer[index]++;
                }
            }

        }


        return answer;
    }
}
