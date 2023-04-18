package kakaoblind;

import java.util.*;
import java.io.*;

public class SortFilename {

    private static class File {
        String name;
        String head;
        int number;
        String tail;

        public File(String name, String head, int number, String tail) {
            this.name = name;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }

    public static void main(String args[]) {
//        String[] files = {
//                "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
//        };

        String[] files = {
                "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"
        };

        solution(files);
    }

    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];

        File[] fileInfo = new File[files.length];

        Map<Integer, File> map = new HashMap<>();

        for(int index = 0; index < files.length; index++) {

            String file = files[index].toUpperCase();
            String head = null, number = "", tail = null;

            for(int i = 0; i < file.length() - 1; i++) {
                Character now = file.charAt(i);

                if('0' <= now && now <= '9') {
                    head = file.substring(0, i);
                    number += now;

                    for(int j = i+1; j < file.length(); j++) {
                        if('0' <= file.charAt(j) && file.charAt(j) <= '9') {
                            number += file.charAt(j);
                        } else {
                            i = j;
                            tail = file.substring(j);
                            break;
                        }
                    }

                }
            }

            File temp = new File(files[index], head, Integer.parseInt(number), tail);
            fileInfo[index] = temp;
            map.put(index, temp);
        }

        Arrays.sort(fileInfo, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if((o1.head).equals(o2.head)) {
                    return o1.number - o2.number;
                } else {
                    return (o1.head).compareTo(o2.head);
                }
            }
        });

        for(int i = 0; i < files.length; i++) {
            answer[i] = fileInfo[i].name;
            System.out.println(answer[i]);
        }

        return answer;
    }
}
