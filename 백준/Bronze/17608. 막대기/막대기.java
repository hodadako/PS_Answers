import java.util.*;

public class Main {
    static int N;
    static int[] sticks;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sticks = new int[N];
        for (int i = 0; i < N; i++) {
            sticks[i] = sc.nextInt();
        }
        
        LinkedList<Integer> stack = new LinkedList<>();
        
        int start = sticks[N - 1];
        stack.add(start);
        for (int i = N - 1; i >= 0; i--) {
            if (sticks[i] > start) {
                stack.add(start);
                start = sticks[i];
            }
        }
        
        System.out.println(stack.size());
    }
}
