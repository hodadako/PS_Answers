import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            String start = sc.next();
            String end = sc.next();
        
            int[] sCount = new int[200];
            int[] eCount = new int[200];
            for (int j = 0; j < start.length(); j++) {
                sCount[(int)start.charAt(j)]++;
            }
            for (int j = 0; j < end.length(); j++) {
                eCount[(int)end.charAt(j)]++;
            }
            boolean flag = true;
            for (int j = 0; j < 200; j++) {
                if (sCount[j] != eCount[j]) {
                    flag = false;
                    break;
                }
            }
            
            sb.append((flag ? "Possible" : "Impossible") + "\n");
        }
        
        System.out.println(sb.toString());
    }
}
