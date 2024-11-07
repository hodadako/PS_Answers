import java.util.*;
import java.io.*;

public class Main {
    public static class FastReader {
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

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }

        int x = sc.nextInt();

        Collections.sort(nums);
        int end = nums.size() - 1;
        int start = 0;
        int answer = 0;
        
        while (start < end) {
            int sum = nums.get(start) + nums.get(end);
            if (sum == x) {
                answer++;
                start++;
            } else if (sum < x) {
                start++;
            } else {
                end --;
            }
        }
        
        System.out.println(answer);
    }
}