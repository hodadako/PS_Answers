class Solution {
    private int[][] map = new int[1024][1024];
    private int[] answer = {0, 0};
    
    private void init(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                map[i][j] = arr[i][j];
            }
        }
    }
    
    private boolean check(int x1, int x2, int y1, int y2) {
        int count = 0; 
        for (int i = x1 ; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }
        
        if (count == 0 || count == (x2 - x1) * (y2 - y1)) {
            return true;
        } else {
            return false;
        }
    }
    
    private void quad(int x1, int x2, int y1, int y2) {
        int n = x2 - x1;
        int m = y2 - y1;
        if (check(x1, x2, y1, y2)) {
            if (map[x1][y1] == 1) {
                answer[1]++;
            } else {
                answer[0]++;
            }
        } else {         
            if (n == 2 && m == 2) {
                for (int i = x1; i < x2; i++) {
                    for (int j = y1; j < y2; j++) {
                        if (map[i][j] == 1) {
                            answer[1]++;
                        } else {
                            answer[0]++;
                        }
                    }
                }
            } else {
                int mid = (x2 - x1) / 2;
                quad(x1, x1 + mid, y1, y1 + mid);
                quad(x1 + mid, x2, y1, y1 + mid);
                quad(x1, x1 + mid, y1 + mid, y2);
                quad(x1 + mid, x2, y1 + mid, y2);
            }
        }
    }
    
    public int[] solution(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        init(arr);
        quad(0, n, 0, m);
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0;  j < m; j++) {
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return answer;
    }
}