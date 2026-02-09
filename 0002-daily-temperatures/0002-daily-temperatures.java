class Solution {
    LinkedList<Integer> q = new LinkedList<>();
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (q.isEmpty()) {
                q.add(i);
            } else if (temperatures[q.peekLast()] < temperatures[i]){
                while (!q.isEmpty()) {
                    if (temperatures[q.peekLast()] < temperatures[i]) {
                        int now = q.removeLast();
                        answer[now] = i - now;
                    } else {
                        break;
                    }
                }
                q.add(i);
            } else {
                q.add(i);
            }
        }
        return answer;
    }
}