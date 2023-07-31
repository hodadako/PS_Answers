import java.util.*;

class Main {
    static int answer = Integer.MAX_VALUE;
    private static void combination(int count, int index, ArrayList<String> list, ArrayList<String> stringList) {
        if (count == 0) {
//            System.out.println(getDistance(list.get(0), list.get(1), list.get(2)));
//            System.out.println(list);
            answer = Math.min(answer, getDistance(list.get(0), list.get(1), list.get(2)));
            return;
        }

        for (int i = index; i < stringList.size(); i++) {
            String s = stringList.get(i);
            list.add(s);
            combination(count - 1, i + 1, list, stringList);
            list.remove(list.size() - 1);
        }
    }
    private static int getDistance(String a, String b, String c) {
        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                result++;
            }
            if (a.charAt(i) != c.charAt(i)) {
                result++;
            }
            if (b.charAt(i) != c.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt();
            if (n <= 32) {
                ArrayList<String> types = new ArrayList<>();
                HashMap<String, Integer> typeCount = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    String s = sc.next();
                    if (typeCount.getOrDefault(s, 0) < 3) {
                        typeCount.put(s, typeCount.getOrDefault(s, 0) + 1);
                        types.add(s);
                    }
                }
                combination(3, 0, new ArrayList<String>(), types);
                System.out.println(answer);
            } else {
                for (int j = 0; j < n; j++) {
                    String s = sc.next();
                }
                System.out.println(0);
            }
            answer = Integer.MAX_VALUE;
        }
    }
}