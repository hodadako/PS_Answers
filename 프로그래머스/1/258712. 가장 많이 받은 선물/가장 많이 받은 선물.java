import java.util.*;

class Solution {
    int[][] exchange;
    int[][] record;
    int n;
    HashMap<String, Integer> map = new HashMap<>();
    
    public int solution(String[] friends, String[] gifts) {
        n = friends.length;
        exchange = new int[n][n];
        record = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            map.put(friends[i], i);
        }
        
        for (String gift : gifts) {
            String[] names = gift.split(" ");
            int name1 = map.get(names[0]);
            int name2 = map.get(names[1]);
            exchange[name1][name2]++;
            record[name1][0]++;
            record[name2][1]++;
        }
        
        for (int i = 0; i < n; i++) {
            record[i][2] = record[i][0] - record[i][1];
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (exchange[i][j] > exchange[j][i]) {
                        count++;
                    } else if (exchange[j][i] == exchange[i][j]) {
                        if (record[i][2] > record[j][2]) {
                            count++;
                        }
                    }
                }
            }
            answer = Math.max(answer, count);
        }
            
        return answer;
    } 
}