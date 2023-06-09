import java.util.*;

class Solution {
    private String[] banner = {"님이 들어왔습니다.", "님이 나갔습니다."};
    
    public String[] solution(String[] record) {
        HashMap<String, String> users = new HashMap<>();
        ArrayList<ArrayList<String>> messages = new ArrayList<>();
        
        for (String s : record) {
            String[] cur = s.split(" ");
            if (cur[0].equals("Enter")) {
                users.put(cur[1], cur[2]);
                ArrayList<String> temp = new ArrayList<>();
                temp.add(cur[1]);
                temp.add(banner[0]);
                messages.add(temp);
            } else if (cur[0].equals("Leave")) {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(cur[1]);
                temp.add(banner[1]);
                messages.add(temp);
            } else {
                users.put(cur[1], cur[2]);
            }
        }
        // System.out.println(messages);
        // System.out.println(users);
        String[] answer = new String[messages.size()];
        for (int i = 0; i < answer.length; i++) {
            ArrayList<String> tmp = messages.get(i);
            answer[i] = users.get(tmp.get(0)) + tmp.get(1);
        }
        return answer;
    }
}