import java.util.*;

class Solution {
    private void count(int index, Set<String> ban, Set<Set<String>> banSet, ArrayList<ArrayList<String>> bans) {
        if (index == bans.size()) {
            banSet.add(new HashSet<String>(ban));
            return;
        }
        
        for (String key : bans.get(index)) {
            if (ban.contains(key)) continue;
            ban.add(key);
            count(index + 1, ban, banSet, bans); 
            ban.remove(key);
        } 
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        Set<Set<String>> banSet = new HashSet<>();
        ArrayList<ArrayList<String>> bans = new ArrayList<>();
        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace("*", ".");
            bans.add(new ArrayList<String>());
            for (int j = 0; j < user_id.length; j++) {
                if (user_id[j].matches(banned_id[i])) {
                    bans.get(i).add(user_id[j]);
                }
            }
        }
        
        count(0, new HashSet<String>(), banSet, bans);
        return banSet.size();
    }
}