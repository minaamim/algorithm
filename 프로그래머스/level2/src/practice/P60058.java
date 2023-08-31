package practice;

import java.util.*;

public class P60058 {

    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
        System.out.println(solution(")("));
        System.out.println(solution("()))((()"));
    }

    public static String solution(String p) {
        String answer = "";

        if(check(p)) return p;

        answer = recursion(p);

        return answer;
    }

    private static String recursion(String str) {

        if(str.equals("")) return str;

        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        int left = 0, right = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') left++;
            else if(str.charAt(i) == ')') right++;

            if(left == right) {
                u.append(str, 0, i + 1);
                v.append(str.substring(i + 1));
                break;
            }
        }

        if(check(u.toString())) {
            u.append(recursion(v.toString()));
        } else if(!check(u.toString())) {
            StringBuilder temp = new StringBuilder();
            temp.append("(");
            temp.append(recursion(v.toString()));
            temp.append(")");
            temp.append(reverse(u.toString()));
            return temp.toString();
        }
        return u.toString();
    }

    private static String reverse(String str) {
        str = str.substring(1, str.length() - 1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') sb.append(')');
            else if(str.charAt(i) == ')') sb.append('(');
        }

        return sb.toString();
    }

    private static boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') stack.add(str.charAt(i));
            else if(str.charAt(i) == ')' && !stack.isEmpty()) stack.pop();
            else if(str.charAt(i) == ')' && stack.isEmpty()) return false;
        }
        return true;
    }
}
