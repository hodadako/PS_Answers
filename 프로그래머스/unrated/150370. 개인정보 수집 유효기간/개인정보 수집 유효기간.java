import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] tmp = terms[i].split(" ");
            map.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        String[] todayArr = today.split("\\.");
        int[] todayDate = new int[todayArr.length];
        for (int k = 0; k < todayArr.length; k++) {
            todayDate[k] = Integer.parseInt(todayArr[k]);
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            String[] contStr = privacy[0].split("\\.");
            int[] contDate = new int[3];
            for (int k = 0; k < 3; k++) {
                contDate[k] = Integer.parseInt(contStr[k]);
            }
            if (contDate[1] + map.get(privacy[1]) > 12) {
                int year = (contDate[1] + map.get(privacy[1])) / 12;
                int month = (contDate[1] + map.get(privacy[1])) % 12;
                if (month == 0) {
                    year -= 1;
                    month = 12;
                }
                contDate[0] += year;
                contDate[1] = month;
            }
            else {
                contDate[1] += map.get(privacy[1]);
            }

            boolean flag = true;
            for (int l = 0; l< 3; l++) {
                System.out.println(todayDate[l] + " " + contDate[l]);
                if (todayDate[l] > contDate[l]) {
                    flag = false;
                } else if (contDate[l] > todayDate[l]) {
                    break;
                } else if (flag && l == 2){
                    if (todayDate[l] >= contDate[l]) {
                        flag = false;
                    }
                }
            }

            if (!flag) {
                result.add(i + 1);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}