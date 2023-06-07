import java.util.*;

class Solution {
    private HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    private int lowerBound(ArrayList<Integer> intList, int target) {
        int s = 0, e = intList.size() - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (intList.get(mid) < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return s;
    }

    private void makeKey(String[] strArr, int count, String str, int score) {
        if (count < 4) {
            makeKey(strArr, count + 1, str + strArr[count], score);
            makeKey(strArr, count + 1, str + "-", score);
        } else {
            if (map.containsKey(str)) {
                ArrayList<Integer> tmp = map.get(str);
                tmp.add(score);
                map.put(str, tmp);
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(score);
                map.put(str, tmp);
            }
        }
    }

    public int[] solution(String[] info, String[] query) {
        int n = info.length, m = query.length;
        int[] answer = new int[m];

        for (int i = 0; i < n; i++) {
            String[] cur = info[i].split(" ");
            int score = Integer.parseInt(cur[4]);
            makeKey(cur, 0, "", score);
        }
        
        for (String s: map.keySet()) {
            ArrayList<Integer> temp = map.get(s);
            Collections.sort(temp, Comparator.naturalOrder());
            map.put(s, temp);
        }

        for (int i = 0; i < m; i++) {
            query[i] = query[i].replace(" and ", "");
            String[] cur = query[i].split(" ");

            int key = Integer.parseInt(cur[1]);
            if (map.containsKey(cur[0])) {
                ArrayList<Integer> tmp = map.get(cur[0]);
                int length = lowerBound(tmp, key);
                answer[i] = tmp.size() - length;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}