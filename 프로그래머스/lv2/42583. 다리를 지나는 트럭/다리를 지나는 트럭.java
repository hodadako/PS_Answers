import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int n = truck_weights.length;
        int[] bridge = new int[bridge_length];
        int[] visited = new int[truck_weights.length];
        int total = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            total += truck_weights[i];
        }
        
        int x = 0;
        int cur = 0;
        int time = 0;
        int pass = 0;
        boolean left = true;
        for (int l = 0; l < truck_weights.length * bridge_length + 1; l++ ) {
            
            
            
            if (pass == total) {
                break;
            }
            if (cur == 0 && left && visited[x] == 0) {
                bridge[bridge_length - 1] = truck_weights[x];
                cur += truck_weights[x];
                visited[x] = 1;
                if (x < truck_weights.length - 1) {
                    x += 1;
                }
            } else {
                int tmp = bridge[0];
                if (tmp > 0) {
                    cur -= tmp;
                    pass += tmp;
                }
                if (cur + truck_weights[x] > weight) {
                    for (int i = 1; i < bridge_length; i++) {
                        bridge[i - 1] = bridge[i];
                    }
                    bridge[bridge_length - 1] = 0;
                } else {
                    for (int i = 1; i < bridge_length; i++) {
                        bridge[i - 1] = bridge[i];
                    }
                    bridge[bridge_length - 1] = 0;
                    if (left && visited[x] == 0) {
                        bridge[bridge_length - 1] = truck_weights[x];
                        cur += truck_weights[x];
                        visited[x] = 1;
                        if (x < truck_weights.length - 1) {
                            x += 1;
                        }
                    }
                }
            }
            time += 1;
            if (visited[visited.length - 1] == 1) {
                left = false;
            }
            
            // System.out.print(time + ": ");
            // for (int j = 0; j < bridge_length; j++) {
            //     System.out.print(bridge[j] + " ");
            // }
            // System.out.println();
        }
        
        answer = time; 
        return answer;
    }
}