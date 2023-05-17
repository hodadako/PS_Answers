import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int M = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tm = new TreeMap<>();

            for(int j = 0; j < M; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String operation = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(operation.equals("I")){
                    tm.put(num, tm.getOrDefault(num,0) + 1);
                }else{
                    if(tm.isEmpty()) continue;

                    int key = (num == 1)? tm.lastKey() : tm.firstKey();
                    // 이전 값을 반환함
                    if(tm.put(key,tm.get(key) - 1) == 1){
                        tm.remove(key);
                    }
                }
            }
            if (tm.size() == 0) {
                answer.append("EMPTY\n");
            } else {
                answer.append(tm.lastKey() + " " + tm.firstKey() + "\n");
            }
        }
        System.out.print(answer);
    }
}