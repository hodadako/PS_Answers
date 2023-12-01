import java.util.*;

class Solution {
    Shuttle[] shuttles;
    
    class Shuttle {
        Time time;
        ArrayList<Time> passengers = new ArrayList<>();
        
        public Shuttle(Time time) {
            this.time = time;
        } 
    }
    
    class Time {
        int hour, minute;
        String strTime;
        
        public Time(String s) {
            String[] strArr = s.split(":");
            this.hour = Integer.parseInt(strArr[0]);
            this.minute = Integer.parseInt(strArr[1]);
            this.strTime = s;
        }
        
        public Time(Time time) {
            this.hour = time.hour;
            this.minute = time.minute;
            this.strTime = time.strTime;
        }
        
        public boolean isPrior(Time other) {
            if (this.hour < other.hour) {
                return true;
            } else if (this.hour == other.hour) {
                if (this.minute <= other.minute) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        public void addMinute(int t) {
            this.minute += t;
            if (this.minute >= 60) {
                this.hour += this.minute / 60;
                this.minute %= 60;
            }
            if (this.hour < 10) {
                if (this.minute < 10) {
                    this.strTime = "0" + String.valueOf(this.hour) + ":" + "0" + String.valueOf(this.minute);
                } else {
                    this.strTime = "0" + String.valueOf(this.hour) + ":" + String.valueOf(this.minute);
                }
            } else {
                if (this.minute < 10) {
                    this.strTime = String.valueOf(this.hour) + ":" + "0" + String.valueOf(this.minute);
                } else {
                    this.strTime = String.valueOf(this.hour) + ":" + String.valueOf(this.minute);
                }
            }
        }
        
        public void subMinute(int t) {
            this.minute -= t;
            if (this.minute < 0) {
                this.hour--;
                this.minute += 60;
            }
            if (this.hour < 10) {
                if (this.minute < 10) {
                    this.strTime = "0" + String.valueOf(this.hour) + ":" + "0" + String.valueOf(this.minute);
                } else {
                    this.strTime = "0" + String.valueOf(this.hour) + ":" + String.valueOf(this.minute);
                }
            } else {
                if (this.minute < 10) {
                    this.strTime = String.valueOf(this.hour) + ":" + "0" + String.valueOf(this.minute);
                } else {
                    this.strTime = String.valueOf(this.hour) + ":" + String.valueOf(this.minute);
                }
            }
        }
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        shuttles = new Shuttle[n];
        for (int i = 0; i < n; i++) {
            Time now = new Time("09:00");
            now.addMinute(t * i);
            shuttles[i] = new Shuttle(now);
        }
        
        Arrays.sort(timetable);
        
        ArrayList<Time> times = new ArrayList<>();
        Time control = new Time("18:01");
        for (String s : timetable) {
            times.add(new Time(s));
            if (control.isPrior(times.get(times.size() - 1))) {
                times.remove(times.size() - 1);
            } 
        }
        
        boolean[] visited = new boolean[times.size()];
        
        for (int i = 0; i < shuttles.length; i++) {
            for (int j = 0; j < times.size(); j++) {
                Time cur = times.get(j);
                if (cur.isPrior(shuttles[i].time) && shuttles[i].passengers.size() < m && !visited[j]) {
                    shuttles[i].passengers.add(cur);
                    visited[j] = true;
                }
            }
        }
        
        if (shuttles[n - 1].passengers.size() < m) {
            answer = shuttles[n - 1].time.strTime;
        } else {
            Time first = shuttles[n - 1].passengers.get(shuttles[n - 1].passengers.size() - 1);
            first.subMinute(1);
            answer = first.strTime;
        }
        return answer;
    }
}