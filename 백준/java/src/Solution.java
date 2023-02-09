import java.sql.Array;
import java.util.*;



public class Solution {
    public static void main(Solution[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
//        String i[];
//        int length = i.length;

        Stack<Character> characters = new Stack<>();

        String hi = "hi";
        String[] ch = hi.split(" ");
        HashMap<Character, HashSet<Integer>> temp = new HashMap<>();

        Collections col = (Collections) temp.values();

        List<Integer> arr = new ArrayList<>();
        Integer[] array = new Integer[3];
        Arrays.sort(array);
        Arrays.sort(array, Collections.reverseOrder());


        for(int i = 0; i < a; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

