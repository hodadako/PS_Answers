import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int dasom = sc.nextInt();
        int answer = 0;
        
        PriorityQueue<Integer> others = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < N - 1; i++) {
            int now = sc.nextInt();
            others.add(now);
        }
        
        while (true) {
            if (others.isEmpty()) {
                break;
            }
            int opps = others.poll();
            if (dasom > opps) {
                break;
            }
            answer++;
            opps--;
            dasom++;
            others.add(opps);
        }
        
        System.out.println(answer);
    }
}
