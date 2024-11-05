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
    
    static int N, S, count = 0;
    static int[] arr;
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        S = fr.nextInt();
        
        arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            int now = fr.nextInt();
            arr[i] = now;
        }
        if (S == 0) {
            count--;
        }
        dfs(0, 0);
        System.out.println(count);
    }
    
    static void dfs(int idx, int sum) {
        if (idx == N) {
            // System.out.println(sum);
            if (sum == S) {
               count++; 
            }
            return;
        }
        
        dfs(idx + 1, sum + arr[idx]);
        dfs(idx + 1, sum);
    }
}
