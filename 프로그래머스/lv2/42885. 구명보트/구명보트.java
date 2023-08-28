import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int s = 0, e = people.length;
        while (s < e) {
            if (people[e - 1] + people[s] <= limit) {
                e--;
                s++;
                answer++;
            } else if (people[e - 1] + people[s] > limit) {
                e--;
                answer++;
            }
        }
        return answer;
    }
}