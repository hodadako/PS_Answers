class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> target = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        int len = words[0].length();
        int count = 0;
        for (String str : words) {
            target.put(str, target.getOrDefault(str, 0) + 1);
            count += str.length();
        }

        HashMap<String, Integer> window = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int left = i, right = i + count;
            while (right <= s.length()) {
                String now = s.substring(left, right);
                if (window.isEmpty()) {
                    for (int j = 0; j <= now.length() - len; j += len) {
                        String cur = now.substring(j, j + len);
                        window.put(cur, window.getOrDefault(cur, 0) + 1);
                    }
                } else {
                    String prev = s.substring(left - len, left);
                    String next = s.substring(right - len, right);
                    window.put(prev, window.getOrDefault(prev, 0) - 1);
                    window.put(next, window.getOrDefault(next, 0) + 1);
                }

                // System.out.println(i + " " + left + " " + right + " " + window);
                if (check(target, window))
                    answer.add(left);
                left += len;
                right += len;
            }
            window.clear();
        }
        return answer;
    }

    boolean check(HashMap<String, Integer> target, HashMap<String, Integer> window) {
        for (String s : target.keySet()) {
            if (!window.containsKey(s))
                return false;
            if (!window.get(s).equals(target.get(s)))
                return false;
        }
        return true;
    }
}