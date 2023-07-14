import java.util.ArrayList;

class Solution {
    private long factorial(long n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }
    public int[] solution(int n, long k) {
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            temp.add(i);
        }

        int[] answer = new int[n];
        int count = 0;
        for (long i = n - 1; i >= 1; i--) {
            long f = factorial(i);
            int index = 0;
            for (long j = 0; j < i + 1; j++) {
                if (k > j * f && k <= (j + 1) * f) {
                    index = (int) j + 1;
                }
            }
            while (k > f) {
                k -= f;
            }
            answer[count] = temp.remove(index);
            visited[answer[count]] = true;
            count++;
        }
        for (int i = 0; i < n + 1; i++) {
            if (!visited[i]) {
                answer[n - 1] = temp.get(1);
            }
        }
        return answer;
    }
}