import java.util.*;
import java.io.*;

class Main {

    static int n, m;
    static HashSet<ArrayList<Integer>> set = new HashSet<>();
    static ArrayList<Integer> nums = new ArrayList<>();

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

    private static void permutation(ArrayList<Integer> list, int count) {
        if (count == 0) {
            set.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            int now = nums.remove(i);
            list.add(now);
            permutation(list, count - 1);
            list.remove(list.size() - 1);
            nums.add(i, now);
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }
        permutation(new ArrayList<>(), m);
        Comparator<ArrayList<Integer>> comparator = new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int result = 0;
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) == o2.get(i)) continue;
                    if (o1.get(i) < o2.get(i)) {
                        result = -1;
                        break;
                    } else {
                        result = 1;
                        break;
                    }
                }
                return result;
            }
        };

        ArrayList<ArrayList<Integer>> answerList = new ArrayList<>(set);
        Collections.sort(answerList, comparator);
        for (ArrayList<Integer> arrayList : answerList) {
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.print(arrayList.get(i) + " ");
            }
            System.out.println();
        }
    }
}