import java.util.*;
import java.io.*;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next()); 
        }
    }
    
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int N = sc.nextInt();
        LinkedList<int[]> stack = new LinkedList<>();
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            int now = sc.nextInt(); 
            
            while (!stack.isEmpty() && stack.peek()[0] <= now) {
                stack.removeFirst();
            }
            
            if (!stack.isEmpty()) {
                answer[i] = stack.getFirst()[1] + 1;
            }
            
            stack.addFirst(new int[]{now, i});
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }
        
        System.out.print(sb);
    }
}