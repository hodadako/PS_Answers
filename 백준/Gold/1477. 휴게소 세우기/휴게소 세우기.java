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
    
    static int N, M, L;
    static int[] list;
    static int[] distances;
    static int target;
    
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        L = fr.nextInt();
        
        list = new int[N];
        distances = new int[N + 1];
        
        for (int i = 0; i < N; i++) {
            list[i] = fr.nextInt();
        }
        
        Arrays.sort(list);
        
        if (N != 0) {
            distances[N] = L - list[list.length - 1];
            distances[N - 1] = list[0] - 0;
        } else {
            distances[0] = L;
        }

        for (int i = 0; i < N - 1; i++) {
            distances[i] = list[i + 1] - list[i];
        }
        
        Arrays.sort(distances);
        
        int high = L - 1;
        int low = 1;
        int result = 0;
        while (low < high) {
            result = 0;
            target = (high + low) / 2;
            for (int i = 0; i < distances.length; i++) {
                result += count(distances[i]);
            }
            if (result <= M) {
                high -= 1;
            } else {
                low += 1;
            }
        }
        System.out.println(high);
    }
    
    static int count(int i) {
        if (i < target) {
            return 0;
        } else if (i % target == 0) {
            return i / target - 1;
        }
        return i / target;
    }
}
