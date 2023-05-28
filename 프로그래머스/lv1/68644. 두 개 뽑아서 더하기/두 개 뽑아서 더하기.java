import java.util.*;

class Solution {
    public ArrayList<Integer> result = new ArrayList<>();
    public void combination(int[] numbers, boolean[] visited, int start, int r) {
        if (r == 0) {
            int tmp = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (visited[i]) {
                    tmp += numbers[i];
                }
            }
            result.add(tmp);
        } else {
            for (int i = start; i < numbers.length; i++) {
                visited[i] = true;
                combination(numbers, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    public int[] solution(int[] numbers) {
        boolean[] visited = new boolean[numbers.length];
        combination(numbers, visited, 0, 2);
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            if (!tmp.contains(result.get(i))) {
                tmp.add(result.get(i));
            }
        }
        
        int[] answer = tmp.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        return answer;
    }
}