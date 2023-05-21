import java.util.*;

class Solution {
    
    public String[] decode(int[][] arr1, int[][] arr2, int n, int[][] map) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String k = "";
            for (int j = 0; j < n; j++) {
                if (arr1[i][j] == 1 || arr2[i][j] == 1) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
                
                if (map[i][j] == 0) {
                    k += " ";
                } else {
                    k += "#";
                }
            }
            answer[i] = k;
        }
        return answer;
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] map = new int[n][n];
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            String a = Integer.toBinaryString(arr1[i]);
            String b = Integer.toBinaryString(arr2[i]);
            if (a.length() < n) {
                String na = "";
                for (int k = 0; k < n - a.length(); k++) {
                    na += "0";
                }
                na += a;
                a = na;
            }
            if (b.length() < n) {
                String nb = "";
                for (int k = 0; k < n - b.length(); k++) {
                    nb += "0";
                }
                nb += b;
                b = nb;
            }
            for (int j = 0; j < n; j++) {
                map1[i][j] = Character.getNumericValue(a.charAt(j));
                map2[i][j] = Character.getNumericValue(b.charAt(j));
            }
        }
        
        answer = decode(map1, map2, n, map);
        return answer;
    }
}