class Solution {
    public int[][] result = new int[4][2];
    
    public void check(String survey, int choice) {
        if (survey.charAt(0) == 'R') {
            if (choice > 4) {
                result[0][1] += choice - 4;
            } else {
                result[0][0] += 4 - choice;
            }
        } else if (survey.charAt(0) == 'T') {
            if (choice > 4) {
                result[0][0] += choice - 4;
            } else {
                result[0][1] += 4 - choice;
            }
        } else if (survey.charAt(0) == 'C') {
            if (choice > 4) {
                result[1][1] += choice - 4;
            } else {
                result[1][0] += 4 - choice;
            }
        } else if (survey.charAt(0) == 'F') {
            if (choice > 4) {
                result[1][0] += choice - 4;
            } else {
                result[1][1] += 4 - choice;
            }
        } else if (survey.charAt(0) == 'J') {
            if (choice > 4) {
                result[2][1] += choice - 4;
            } else {
                result[2][0] += 4 - choice;
            }
        } else if (survey.charAt(0) == 'M') {
            if (choice > 4) {
                result[2][0] += choice - 4;
            } else {
                result[2][1] += 4 - choice;
            }
        } else if (survey.charAt(0) == 'A') {
            if (choice > 4) {
                result[3][1] += choice - 4;
            } else {
                result[3][0] += 4 - choice;
            }
        } else {
            if (choice > 4) {
                result[3][0] += choice - 4;
            } else {
                result[3][1] += 4 - choice;
            }
        } 
    }
    
    public String solution(String[] survey, int[] choices) {
        for (int i = 0; i < survey.length; i++) {
            check(survey[i], choices[i]);
        }
        
        String answer = "";
        
        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                if (result[i][0] >= result[i][1]) {
                    answer += "R";
                } else {
                    answer += "T";
                }
            } else if (i == 1) {
                if (result[i][0] >= result[i][1]) {
                    answer += "C";
                } else {
                    answer += "F";
                }
            } else if (i == 2) {
                if (result[i][0] >= result[i][1]) {
                    answer += "J";
                } else {
                    answer += "M";
                }
            } else {
                if (result[i][0] >= result[i][1]) {
                    answer += "A";
                } else {
                    answer += "N";
                }
            }
        }

        return answer;
    }
}