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

        long nextLong() {
            return Long.parseLong(next());
        }
	}

    static long[] rides;

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		long N = fr.nextLong();
		int M = fr.nextInt();

        if (N <= M) {
            System.out.println(N);
            return;
        }
        
        rides = new long[M];
		for (int i = 0; i < M; i++) {
			rides[i] = fr.nextLong();
		}

        long low = 0;
        long high = (long)23e11;
        long mid = 0;
        long count = 0;
        while (low < high) {
            mid = (low + high) / 2;
            count = 0;
            for (int i = 0; i < M; i++) {
                count += (mid / rides[i] + 1) ;
            }
            
            if (count < N) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        int answer = 0;
        
        if (count < N) {
            for (int i = 0; i < M; i++) {
                if (high % rides[i] == 0) {
                    count++;
                }
                
                if (count == N) {
                    answer = i + 1;
                    break;
                }
            }
        } else {
            long current = 0;
            high--; 
            
            for (int i = 0; i < M; i++) {
                current += (high / rides[i] + 1);
            }
            
            high++;
            
            for (int i = 0; i < M; i++) {
                
                if (high % rides[i] == 0) {
                    current++;
                }
                
                if (current == N) {
                    answer = i + 1;
                    break;
                }
            }
        }
        
        System.out.println(answer);
        
        // System.out.println(low);
        // System.out.println(mid);
        // System.out.println(emptySpot);
	}
}
