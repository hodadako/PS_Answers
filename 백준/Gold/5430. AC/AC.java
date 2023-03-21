import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        String[] answerList = new String[t];
        for (int i = 0; i < t; i++) {
            String oper = sc.next();
            int n = sc.nextInt();
            String str = sc.next().replace("]", "").replace("[", "");

            int l = oper.length();
            int status = 1;
            int removeIdx = 0;
            int rCount = 0;


            String[] strArr = str.split(",");
            LinkedList<String> arr = new LinkedList<>(Arrays.asList(strArr));
  
            //함수에 따른 배열 변환
            if (n == 0 && oper.contains("D")) {
                status = 0;
            } else {
                for (int k = 0; k < l; k++) {
                    if (oper.charAt(k) == 'R') {
                        rCount += 1;
                        if (removeIdx == 0) {
                            removeIdx = -1;
                        } else {
                            removeIdx = 0;
                        }
                    } else {
                        if (arr.isEmpty()) {
                            status = 0;
                        } else {
                            if (removeIdx == -1) {
                                arr.removeLast();
                            } else {
                                arr.removeFirst();
                            }
                        }
                    }
                }   
            }

            //결과 출력
            if (status == 0) {
                answerList[i] = "error";
            } else {
                if (rCount % 2 != 0) {
                    Collections.reverse(arr);
                }
                String answer = "[";
                String listString = String.join(",", arr);
                answer += listString;
                answer += "]";
                answerList[i] = answer;
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println(answerList[i]);
        }
    }
}