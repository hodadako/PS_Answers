import java.io.*;
import java.util.*;

class Main {
    static ArrayList<LinkedList<Integer>> gears = new ArrayList<>();
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

    private static void clockWise(int num, ArrayList<LinkedList<Integer>> gears) {
        gears.get(num).addFirst(gears.get(num).removeLast());
    }

    private static void antiClockWise(int num, ArrayList<LinkedList<Integer>> gears) {
        gears.get(num).addLast(gears.get(num).removeFirst());
    }

    private static int[] getDirections(int num, int dir) {
        int[] result = new int[4];
        result[num] = dir;
        for (int i = num; i < 4; i++) {
            if (i == num) continue;
            if (gears.get(i - 1).get(2) == gears.get(i).get(6)) {
                break;
            } else if (gears.get(i - 1).get(2) != gears.get(i).get(6)) {
                result[i] = -1 * result[i - 1];
            }
        }
        for (int i = num; i >= 0; i--) {
            if (i == num) continue;
            if (gears.get(i + 1).get(6) == gears.get(i).get(2)) {
                break;
            } else if (gears.get(i + 1).get(6) != gears.get(i).get(2)) {
                result[i] = -1 * result[i + 1];
            }
        }

        return result;
    }

    private static int getScore() {
        int total = 0, count = 1;
        for (int i = 0; i < 4; i++) {
            total += gears.get(i).get(0) == 0 ? 0 : count;
            count *= 2;
        }
        return total;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        for (int i = 0; i < 4; i++) {
            String gear = sc.next();
            LinkedList<Integer> temp = new LinkedList<>();
            for (int j = 0; j < gear.length(); j++) {
                temp.add(Character.getNumericValue(gear.charAt(j)));
            }
            gears.add(temp);
        }

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt() - 1, dir = sc.nextInt();
            ArrayList<LinkedList<Integer>> nextGears = new ArrayList<>(gears);
            int[] directions = getDirections(num, dir);
            for (int j = 0; j < 4; j++) {
                if (directions[j] == -1) {
                    antiClockWise(j, nextGears);
                } else if (directions[j] == 1) {
                    clockWise(j, nextGears);
                }
            }
            gears = nextGears;
        }
        System.out.println(getScore());
    }
}