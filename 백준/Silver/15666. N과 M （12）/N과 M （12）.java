import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static ArrayList<Integer> nums = new ArrayList<>();
    static HashSet<ArrayList<Integer>> set = new HashSet<>();
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

    private static void combination(ArrayList<Integer> list, int index, int count) {
        if (count == 0) {
            set.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < nums.size(); i++) {
            int now = nums.get(i);
            list.add(now);
            combination(list, i, count - 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        HashSet<Integer> temp = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            temp.add(a);
        }
        nums.addAll(temp);
        Collections.sort(nums);
        combination(new ArrayList<>(), 0, m);

        HashSet<ArrayList<Integer>> answer = new HashSet<>();
        for (ArrayList<Integer> now : set) {
            Collections.sort(now);
            answer.add(now);
        }

        ArrayList<ArrayList<Integer>> answerList = new ArrayList<>(answer);
        Collections.sort(answerList, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int result = 0;
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) == o2.get(i)) continue;
                    if (o1.get(i) > o2.get(i)) {
                        result = 1;
                        break;
                    } else {
                        result = -1;
                        break;
                    }
                }
                return result;
            }
        });

        for (int i = 0; i < answerList.size(); i++) {
            for (int j = 0; j < answerList.get(i).size(); j++) {
                System.out.print(answerList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}