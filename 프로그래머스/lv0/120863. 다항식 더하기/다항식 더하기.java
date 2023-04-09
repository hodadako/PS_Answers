class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int x = 0;
        int n = 0;
        int zeroFlag = 0;
        String[] polyArr = polynomial.split(" ");
        for (int i = 0; i < polyArr.length; i++) {
            if (polyArr[i].contains("x")) {
                if (polyArr[i].length() >= 2) {
                    int k = Integer.parseInt(polyArr[i].substring(0, polyArr[i].length() - 1));
                    x += k;
                } else {
                    x += 1;
                }
            } else if (!polyArr[i].equals("+")){
                n += Integer.parseInt(polyArr[i]);
                if (Integer.parseInt(polyArr[i]) == 0) {
                    zeroFlag = 1;
                }
            } 
        }
        if (x == 1 && n == 0 && zeroFlag == 0) {
            answer = "x";
        } else if (x == 1 && n == 0 && zeroFlag == 1) {
            answer = "x + 0";
        } else if (x == 0 && n == 0 && zeroFlag == 1) {
            answer = "0";
        } else if (x == 1 && n > 0) {
            answer = "x + " + String.valueOf(n);
        } else if (x == 0 && n != 0) {
            answer = String.valueOf(n);
        } else if (x != 0 && zeroFlag == 0 && n == 0){
            answer = String.valueOf(x) + "x";
        } else if (x != 0 && zeroFlag == 1 && n == 0){
            answer = String.valueOf(x) + "x + 0";
        } else {
            answer = String.valueOf(x) + "x + " + String.valueOf(n); 
        }
        return answer;
    }
}