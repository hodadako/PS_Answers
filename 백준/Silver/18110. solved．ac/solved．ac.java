import java.util.*;
import java.io.*;


class Main {
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
        int n = sc.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }

        Collections.sort(nums, Comparator.naturalOrder());

        int size = (int) Math.round(nums.size() * 0.15d);
        if (n == 0) {
            System.out.println(n);
        } else {
            double result = 0;
            for (int i = size; i < nums.size() - size; i++) {
                result += nums.get(i);
            }
            System.out.println(Math.round(result / (nums.size() - size * 2)));
        }
    }
}